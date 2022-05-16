package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import polymorphicBST.Tree;
import polymorphicBST.EmptyTree;
import polymorphicBST.EmptyTreeException;
import org.junit.*;
import static org.junit.Assert.*;

@SuppressWarnings({"unchecked", "rawtypes"})
public class PublicTests {

  // Obviously all tests also call and therefore test the effects of
  // insertKeyValuePair() as well.

  // Tests calling size() on an EmptyTree.
  @Test public void testPublic1() {
    assertEquals(0, EmptyTree.getInstance().size());
  }

  // Tests calling size() on an NonEmptyTree.
  @Test public void testPublic2() {
    assertEquals(7, TestData.firstSampleTree().size());
  }

  // Tests calling toString() on an EmptyTree.
  @Test public void testPublic3() {
    assertEquals("", EmptyTree.getInstance().toString());
  }

  // Tests calling toString() on a NonEmptyTree.
  @Test public void testPublic4() {
    assertEquals("ape->a bat->n bee->i cat->m cow->a dog->l eel->n elk->a " +
                 "emu->m fox->e owl->l pig->i rat->s yak->t ",
                 TestData.secondSampleTree().toString());
  }

  // Tests calling getValueForKey() on an EmptyTree.
  @Test public void testPublic5() {
    assertNull(EmptyTree.getInstance().getValueForKey('X'));
  }

  // Tests calling getValueForKey() on an element that is present in a
  // NonEmptyTree.
  @Test public void testPublic6() {
    assertEquals('r', (char) TestData.firstSampleTree().getValueForKey(4));
  }

  // Tests calling getValueForKey() on an element that is not present in a
  // NonEmptyTree.
  @Test public void testPublic7() {
    assertNull(TestData.firstSampleTree().getValueForKey(5));
  }

  // Tests calling depthOfKey() on an element in a NonEmptyTree.
  @Test public void testPublic8() {
    assertEquals(1, TestData.firstSampleTree().depthOfKey(12));
  }

  // Tests calling copyOfTree() on an EmptyTree.
  @Test public void testPublic9() {
    Tree<Integer, Integer> tree1= EmptyTree.getInstance();
    Tree<Integer, Integer> tree2= tree1.copyOfTree();

    assertEquals(0, tree2.size());
    assertEquals("", tree2.toString());
  }

  // Tests calling copyOfTree() on a NonEmptyTree.
  @Test public void testPublic10() {
    Tree<String, Character> tree1= TestData.secondSampleTree();
    Tree<String, Character> tree2= tree1.copyOfTree();

    assertEquals(tree1.size(), tree2.size());
    assertEquals(tree1.toString(), tree2.toString());
  }

  // Tests calling min() on an EmptyTree.  (The "throws" clause is just to
  // make the compiler happy; the exception should not actually be thrown.)
  @Test(expected=EmptyTreeException.class)
  public void testPublic11() throws EmptyTreeException {
    EmptyTree.getInstance().min();
  }

  // Tests calling min() on a NonEmptyTree.  (The "throws" clause is just to
  // make the compiler happy; the exception should not actually be thrown.)
  @Test public void testPublic12() throws EmptyTreeException {
    assertEquals(2, (int) TestData.firstSampleTree().min());
  }

  // Tests calling max() on an EmptyTree.  (The "throws" clause is just to
  // make the compiler happy; the exception should not actually be thrown.)
  @Test(expected=EmptyTreeException.class)
  public void testPublic13() throws EmptyTreeException {
    EmptyTree.getInstance().max();
  }

  // Tests calling max() on a NonEmptyTree.  (The "throws" clause is just to
  // make the compiler happy; the exception should not actually be thrown.)
  @Test public void testPublic14() throws EmptyTreeException {
    assertEquals(14, (int) TestData.firstSampleTree().max());
  }

  // Tests calling deleteKeyValuePair() on an element of a NonEmptyTree.
  @Test public void testPublic15() {
    Tree<Integer, Character> tree=
                             TestData.firstSampleTree().deleteKeyValuePair(6);

    assertEquals(6, tree.size());
    assertEquals("2->o 4->r 8->t 10->n 12->e 14->n ", tree.toString());
  }

}
