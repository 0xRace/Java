package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import iterators.Shape;
import iterators.Picture;
import iterators.Power;
import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // Checks the value of calling hasNext() on a new iterator over a nonempty
  // Picture, which should be true.
  @Test public void testPublic1() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();

    assertTrue(iter.hasNext());
  }

  // Checks that when hasNext() is called on an iterator for a Picture with
  // several elements, it still returns true after the first call to next().
  @Test public void testPublic2() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();

    iter.next();  // just ignore the Shape returned

    assertTrue(iter.hasNext());
  }

  // Checks the values returned by multiple iterations on an iterator.  Note
  // that there is no requirement that an iterator return the elements of an
  // object in any particular order, so we are checking that the iterator
  // next() method returns the Shapes in the Picture but we don't know what
  // order they will be returned in.
  @Test public void testPublic3() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    int i= 0;

    // this is calling the Shape equals() method
    assertTrue(TestData.findShape(expectedShapes, iter.next()));
    assertTrue(TestData.findShape(expectedShapes, iter.next()));
    assertTrue(TestData.findShape(expectedShapes, iter.next()));
    assertTrue(TestData.findShape(expectedShapes, iter.next()));
    assertTrue(TestData.findShape(expectedShapes, iter.next()));
  }

  // Checks the value of hasNext() on a new iterator over an empty Picture,
  // which should be false.
  @Test public void testPublic4() {
    Picture picture= new Picture(8);
    Iterator<Shape> iter= picture.iterator();

    assertFalse(iter.hasNext());
  }

  // Checks the values returned by multiple calls to next() on a Picture
  // iterator, until hasNext() returns false, which is also testing that
  // hasNext() properly returns false when it should, and the iterator
  // doesn't have any errors in this case.
  @Test public void testPublic5() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };

    // this is calling the Shape equals() method
    while (iter.hasNext())
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
  }

  // The same as the previous test, but in this case the number of Shapes
  // bing stored in the Picture is different from the Picture's capacity, so
  // this is checking that hasNext() is implemented correctly and is testing
  // the right condition.
  @Test public void testPublic6() {
    Picture picture= TestData.examplePicture2();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("dodecahedron", 6), new Shape("pentagon", 1),
      new Shape("square", 4), new Shape("circle", 2), new Shape("octagon", 8), 
      new Shape("line", 3), new Shape("triangle", 5)
    };

    // this is calling the Shape equals() method
    while (iter.hasNext())
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
  }

  // Verifies that a Picture iterator's next() method properly throws a
  // NoSuchElementException when next() is called more times than the number
  // of Shapes in a Picture.
  @Test(expected= NoSuchElementException.class) public void testPublic7() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();

    while (true)
      iter.next();
  }

  // Tests that a new iterator can iterate over a Picture object after one
  // iterator has already iterated over it.
  @Test public void testPublic8() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    // make a copy of the array, because it will be destroyed by findShape()
    Shape[] expectedShapes2= Arrays.copyOf(expectedShapes,
                                           expectedShapes.length);
    int count= 0;

    // this is calling the Shape equals() method
    while (iter.hasNext()) {
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
      count++;
    }
    assertEquals(5, count);

    // now do the same thing with a new iterator
    count= 0;
    iter= picture.iterator();

    // this is calling the Shape equals() method
    while (iter.hasNext()) {
      assertTrue(TestData.findShape(expectedShapes2, iter.next()));
      count++;
    }
    assertEquals(5, count);
  }

  // Tests that two iterators can simultaneously iterate over a Picture
  // object.
  @Test public void testPublic9() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter1= picture.iterator();
    Iterator<Shape> iter2= null;
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    // make a copy of the array, because it will be destroyed by findShape()
    Shape[] expectedShapes2= Arrays.copyOf(expectedShapes,
                                           expectedShapes.length);
    int count= 0;

    while (iter2 == null || iter2.hasNext()) {
      if (iter1.hasNext()) {
        assertTrue(TestData.findShape(expectedShapes, iter1.next()));
        count++;
      }

      if (count == 2)
        iter2= picture.iterator();
      else
        if (count > 2) {
          assertTrue(TestData.findShape(expectedShapes2, iter2.next()));
          count++;
        }
    }

    assertEquals(10, count);
  }

  // This test tests the Power iterator explicitly, although it is also
  // called from the toString() methods in the tests below.
  @Test public void testPublic10() {
    Power p= new Power(4, 6);
    Iterator<Integer> iter= p.iterator();

    assertEquals(4, (int) iter.next());     // 4^1
    assertEquals(16, (int) iter.next());    // 4^2
    assertEquals(64, (int) iter.next());    // 4^3
    assertEquals(256, (int) iter.next());   // 4^4
    assertEquals(1024, (int) iter.next());  // 4^5
    assertEquals(4096, (int) iter.next());  // 4^6
  }

  // Tests the Power toString() method, which uses the Power iterator, for a
  // typical case.
  @Test public void testPublic11() {
    Power p= new Power(2, 6);

    assertEquals("2 4 8 16 32 64", p.toString());
  }

  // Tests the Power iterator (called from the Power toString() method) on
  // 1^1.
  @Test public void testPublic12() {
    Power p= new Power(1, 1);

    assertEquals("1", p.toString());
  }

  // Tests the Power iterator (called from the Power toString() method) on
  // 27^1.
  @Test public void testPublic13() {
    Power p= new Power(27, 1);

    assertEquals("27", p.toString());
  }

  // Tests the Power iterator (called from the Power toString() method) with
  // a negative value raised to a positive power.
  @Test public void testPublic14() {
    Power p= new Power(-8, 5);

    assertEquals("-8 64 -512 4096 -32768", p.toString());
  }

  // Tests the basic operation of the Picture iterator remove() method to
  // remove just one Shape from a Picture.
  @Test public void testPublic15() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    int i= 0;

    iter.next();
    iter.remove();

    // check the remaining four elements (this is calling the Shape equals()
    // method)
    for (i= 1; i <= 4; i++)
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
  }

  // Tests using the Picture iterator remove() method to remove all Shapes
  // from a Picture.
  @Test public void testPublic16() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    int i= 0;

    // this is calling the Shape equals() method
    for (i= 1; i <= 5; i++) {
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
      iter.remove();
    }

    // ensure everything has been removed
    iter= picture.iterator();
    assertFalse(iter.hasNext());
  }

  // Test calling the Picture iterator remove() method to remove only some
  // Shapes from a Picture object.
  @Test public void testPublic17() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2)
    };
    int i= 0, count= 0;

    for (i= 1; i <= 5; i++) {
      iter.next();
      if (i >= 3)
        iter.remove();
    }

    // now count the elements remaining and ensure that there are two
    iter= picture.iterator();
    while (iter.hasNext()) {
      iter.next();
      count++;
    }

    assertEquals(2, count);
  }

  // Tests that its hasNext() method returns false after all of the Shapes
  // have been removed from a Picture by calling the remove() iterator
  // method.
  @Test public void testPublic18() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    int i= 0;

    while (iter.hasNext()) {
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
      iter.remove();
    }

    // ensure everything has been removed
    iter= picture.iterator();
    assertFalse(iter.hasNext());
  }

  // Tests that the right element is removed by calling the Picture iterator
  // remove() method, meaning the one returned by the most recent call to
  // next().
  @Test public void testPublic19() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();
    Shape[] expectedShapes= new Shape[]{
      new Shape("square", 4), new Shape("circle", 2),
      new Shape("dodecahedron", 6), new Shape("triangle", 5),
      new Shape("pentagon", 1)
    };
    int i= 0;
    Shape shapeToRemove;

    iter.next();
    // save the shape that's going to be removed from the picture
    shapeToRemove= iter.next();
    iter.remove();

    // now remove the shape that was removed from the picture from
    // expectedShapes, by calling findShape(), then iterate over the picture
    // again, making sure that all of the remaining shapes are present in it
    // (meaning that the right one was removed)
    TestData.findShape(expectedShapes, shapeToRemove);

    iter= picture.iterator();
    while (iter.hasNext())
      assertTrue(TestData.findShape(expectedShapes, iter.next()));
  }

  // Tests that the Picture iterator next() method throws the expected
  // NoSuchElementException when called after all of the elements have been
  // removed by the iterator remove() method.
  @Test(expected= NoSuchElementException.class) public void testPublic20() {
    Picture picture= TestData.examplePicture1();
    Iterator<Shape> iter= picture.iterator();

    while (iter.hasNext()) {
      iter.next();
      iter.remove();
    }

    assertFalse(picture.iterator().hasNext());
    // the Picture should be empty now, so this should throw the exception
    iter.next();
  }

  // Tests that the Picture iterator remove() method throws the expected
  // IllegalStateException if remove() is called before next().
  @Test(expected= IllegalStateException.class) public void testPublic21() {
    Picture picture= TestData.examplePicture2();
    Iterator<Shape> iter= picture.iterator();

    iter.remove();
  }

  // Tests that the Picture iterator remove() method throws the expected
  // IllegalStateException if remove() has already been called after the
  // last call to next(), so the element has already been removed.
  @Test(expected= IllegalStateException.class) public void testPublic22() {
    Picture picture= TestData.examplePicture2();
    Iterator<Shape> iter= picture.iterator();

    iter.next();
    iter.next();

    iter.remove();
    iter.remove();
  }

}
