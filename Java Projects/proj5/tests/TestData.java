package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import iterators.Shape;
import iterators.Picture;

/* This class contains utility methods that create and return example Course
 * objects that the public (and secret) tests can use, to reduce the amount
 * of code needed in different tests to create objects to test the methods
 * with.  You can use these methods in your student tests as well, but don't
 * modify this file, because our version is going to be used on the submit
 * server.  (You can either write your own helper methods in your
 * StudentTests class, and you can add your own classes to the tests
 * package, if you want to use modified versions of these methods.)
 */

public class TestData {

  // returns a sample Picture with an array of size 5 that is storing five
  // Shapes
  public static Picture examplePicture1() {
    Picture picture= new Picture(5);

    picture.addShape(new Shape("square", 4));
    picture.addShape(new Shape("circle", 2));
    picture.addShape(new Shape("dodecahedron", 6));
    picture.addShape(new Shape("triangle", 5));
    picture.addShape(new Shape("pentagon", 1));

    return picture;
  }

  // returns another sample Picture with an array of size 10 that is storing
  // seven Shapes
  public static Picture examplePicture2() {
    Picture picture= new Picture(10);

    picture.addShape(new Shape("dodecahedron", 6));
    picture.addShape(new Shape("pentagon", 1));
    picture.addShape(new Shape("square", 4));
    picture.addShape(new Shape("circle", 2));
    picture.addShape(new Shape("octagon", 8));
    picture.addShape(new Shape("line", 3));
    picture.addShape(new Shape("triangle", 5));

    return picture;
  }

  // searches for a shape in an unsorted array of shapes, returning true if
  // and only if it is found; also removes the shape from the array (so we
  // can test that an iterator is returning each value only once)
  public static boolean findShape(Shape[] shapeArray, Shape aShape) {
    int i= 0;
    boolean found= false;

    while (i < shapeArray.length && !found) {
      if (shapeArray[i] != null)
        found= shapeArray[i].equals(aShape);
      i++;
    }

    if (found) {
      while (i < shapeArray.length - 1) {
        // note: i was already incremented one past the shape, if found
        shapeArray[i - 1]= shapeArray[i];
        i++;
      }

      shapeArray[i - 1]= null;  // really remove the last element
    }

    return found;
  }

}
