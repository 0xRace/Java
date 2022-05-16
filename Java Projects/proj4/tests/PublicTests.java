package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import recursiveList.RecursiveMethodsList;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  @Test public void testPublic1() {
    RecursiveMethodsList<Integer> list= new RecursiveMethodsList<>();

    for (Integer i : new int[]{1, 3, 5})
      list.add(i);

    assertTrue(list.isNonDecreasing());
  }

  @Test public void testPublic2() {
    RecursiveMethodsList<Integer> list= new RecursiveMethodsList<>();

    for (Integer i : new int[]{1, 3, 2})
      list.add(i);

    assertEquals(3, (int) list.elementAfter(1));
  }

  @Test public void testPublic3() {
    RecursiveMethodsList<Integer> list= new RecursiveMethodsList<>();

    for (Integer i : new int[]{1, 3, 9, 5, 7})
      list.add(i);

    assertEquals("3, 5", list.elementsBetweenValues(2, 6).toString());
  }

  @Test public void testPublic4() {
    RecursiveMethodsList<Character> list1= new RecursiveMethodsList<>();
    RecursiveMethodsList<Character> list2= new RecursiveMethodsList<>();

    for (Character ch : new char[]{'t', 'o', 'r', 'p', 'e', 'd', 'o'})
      list1.add(ch);

    for (Character ch : new char[]{'e', 's', 't', 'u'})
      list2.add(ch);

    list1.replaceWithOtherList(list2, 1);

    assertEquals("t, e, s, t, u, d, o", list1.toString());
  }

}
