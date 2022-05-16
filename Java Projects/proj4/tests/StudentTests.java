/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 */
package tests;

import recursiveList.RecursiveMethodsList;
import org.junit.*;
import static org.junit.Assert.*;

public class StudentTests {
	@Test
	public void testNonDecreasing() {
		RecursiveMethodsList<Integer> list = new RecursiveMethodsList<>();
		assertTrue(list.isNonDecreasing());

		for (Integer i : new int[] { 1 })
			list.add(i);
		assertTrue(list.isNonDecreasing());

		for (Integer i : new int[] { 1, 3, 5 })
			list.add(i);
		assertTrue(list.isNonDecreasing());

		list = new RecursiveMethodsList<>();
		for (Integer i : new int[] { 1, 3, 3, 5 })
			list.add(i);
		assertTrue(list.isNonDecreasing());

		list = new RecursiveMethodsList<>();
		for (Integer i : new int[] { 1, 6, 5 })
			list.add(i);
		assertFalse(list.isNonDecreasing());
	}

	@Test
	public void testElementAfter() {
		RecursiveMethodsList<Integer> list = new RecursiveMethodsList<>();

		for (Integer i : new int[] { 1, 3, 2 })
			list.add(i);

		assertEquals(3, (int) list.elementAfter(1));
		assertEquals(null, list.elementAfter(2));
		assertEquals(null, list.elementAfter(0));
	}

	@Test
	public void testElementsBetween() {
		RecursiveMethodsList<Integer> list = new RecursiveMethodsList<>();

		for (Integer i : new int[] { 1, 3, 9, 5, 7 })
			list.add(i);

		assertEquals("3, 5", list.elementsBetweenValues(2, 6).toString());
		assertEquals("1", list.elementsBetweenValues(1, 1).toString());
		assertEquals("", list.elementsBetweenValues(6, 2).toString());
		assertEquals("", list.elementsBetweenValues(11, 11).toString());
	}

	@Test
	public void testReplace() {
		RecursiveMethodsList<Character> list1 = new RecursiveMethodsList<>();
		RecursiveMethodsList<Character> list2 = new RecursiveMethodsList<>();

		for (Character ch : new char[] { 't', 'o', 'r', 'p', 'e', 'd', 'o' })
			list1.add(ch);

		for (Character ch : new char[] { 'e', 's', 't', 'u' })
			list2.add(ch);

		list1.replaceWithOtherList(list2, 1);
		assertEquals("t, e, s, t, u, d, o", list1.toString());
		list1.replaceWithOtherList(list2, 8);
		assertEquals("t, e, s, t, u, d, o", list1.toString());
	}

	// write your student tests in this class

}
