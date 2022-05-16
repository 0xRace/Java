package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import listAndSublist.ListNoOrder;
import listAndSublist.ListInOrder;

/* This class contains utility methods that create and return example Course
 * objects that the public (and secret) tests can use, to reduce the amount
 * of code needed in different tests to create objects to test the methods
 * with.  You can use these methods in your student tests as well, but don't
 * modify this file, because our version is going to be used on the submit
 * server.  (You can either write your own helper methods in your
 * StudentTests class, and you can add your own classes to the tests
 * package, if you want to use modified versions of these methods.)
 *
 * Although this wasn't covered in lecture, this class contains generic
 * methods, even though it's not a generic class.
 */

public class TestData {

  // Adds all elements of an array of any type (that implements Comparable)
  // to a ListNoOrder of the same type and returns it, for use in creating
  // lists for testing the methods.
  public static <T extends Comparable<T>>
                           ListNoOrder<T> makeListNoOrder(T[] arr) {
    ListNoOrder<T> list= new ListNoOrder<T>();

    if (arr != null)
      for (T elt : arr)
        list.add(elt);

    return list;
  }

  // Adds all elements of an array of any type (that implements
  // Comparable)to a ListInoOrder of the same type and returns it, for use
  // in creating lists for testing the methods.
  public static <T extends Comparable<T>>
                           ListInOrder<T> makeListInOrder(T[] arr) {
    ListInOrder<T> list= new ListInOrder<T>();

    if (arr != null)
      for (T elt : arr)
        list.add(elt);

    return list;
  }

  public static ListNoOrder<Integer> intNoOrderList() {
    return makeListNoOrder(new Integer[]{ 7,  8, 15, 15,  2,  8,  8, 14,  3,
                                         16, 13,  7, 13, 17,  8,  2, 20, 10});
  }

  public static ListNoOrder<Character> charNoOrderList() {
    return makeListNoOrder(new Character[]{'c', 'a', 'p', 'e', 'd', 'c', 'r',
                                           'u', 's', 'a', 'd', 'e', 'r'});
  }

  public static ListNoOrder<String> stringNoOrderList() {
    return makeListNoOrder(new String[]{"cat", "rat", "dog", "owl", "pig",
                                        "eel", "emu", "yak", "fox", "cow"});
  }

  // note: returns a superclass reference referring to a subclass object
  public static ListNoOrder<Integer> intInOrderList() {
    return makeListInOrder(new Integer[]{ 7,  8, 15, 15,  2,  8,  8, 14,  3,
                                         16, 13,  7, 13, 17,  8,  2, 20, 10});
  }

}
