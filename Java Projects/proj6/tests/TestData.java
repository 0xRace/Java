package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

/* This class contains utility methods that create and return example
 * NonEmptyTree objects that the public (and secret) tests can use, to
 * reduce the amount of code needed in different tests to create objects to
 * test the methods with.  You can use these methods in your student tests
 * as well, but don't modify this file, because our version is going to be
 * used on the submit server.  (You can either write your own helper methods
 * in your StudentTests class, and you can add your own classes to the tests
 * package, if you want to use modified versions of these methods.)
 */

import polymorphicBST.Tree;
import polymorphicBST.EmptyTree;

public class TestData {

  // Adds all elements of a key array of any type and a value array of any
  // type to a tree, and returns it.  The arrays should be the same size,
  // but we handle things gracefully if they're not.
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>, U> Tree<T, U>
                createTree(T[] keyArr, U[] valueArr) {
    Tree<T, U> tree= EmptyTree.getInstance();
    int max, i;

    if (keyArr != null && valueArr != null) {
      max= keyArr.length < valueArr.length ? keyArr.length : valueArr.length;
      for (i= 0; i < max; i++)
        tree= tree.insertKeyValuePair(keyArr[i], valueArr[i]);
    }

    return tree;
  }

  // Returns a tree with several elements, with Integer keys and Character
  // values.
  public static Tree<Integer, Character> firstSampleTree() {
    return createTree(new Integer[]{8, 4, 12, 10, 14, 6, 2},
                      new Character[]{'t', 'r', 'e', 'n', 'n', 'x', 'o'});
  }

  // Returns a tree with several elements, with String keys and Character
  // values.
  public static Tree<String, Character> secondSampleTree() {
    return createTree(new String[]{"fox", "rat", "cat", "owl", "pig", "eel",
                                   "emu", "yak", "dog", "ape", "cow", "bat",
                                   "elk", "bee"},
                      new Character[]{'e', 's', 'm', 'l', 'i', 'n', 'm', 't',
                                      'l', 'a', 'a', 'n', 'a', 'i'});
  }

}
