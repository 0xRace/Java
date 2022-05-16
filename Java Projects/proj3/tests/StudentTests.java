/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create tests for the ListInOrder class and ListNoOrder class
 */
package tests;

import org.junit.*;

import listAndSublist.ListInOrder;
import listAndSublist.ListNoOrder;

import static org.junit.Assert.*;

public class StudentTests {

	// tests possible values for length of a ListNoOrder object
	@Test
	public void testLength() {
		assertEquals(18, TestData.intNoOrderList().length());
		ListNoOrder<String> myTests = new ListNoOrder<String>();
		assertEquals(0, myTests.length());
		myTests.add("Hello");
		assertEquals(1, myTests.length());
		myTests.add("Hellos");
		assertEquals(2, myTests.length());
		myTests.add("Hellox");
		myTests.add("Helloc");
		myTests.add("Helloz");
		myTests.add("Helloc");

	}

	// tests that strings are returned correctly with the toString method, for
	// both strings and integers
	@Test
	public void testToString() {

		assertEquals("7, 8, 15, 15, 2, 8, 8, 14, 3, " + "16, 13, 7, 13, 17, 8, 2, 20, 10",
				TestData.intNoOrderList().toString());

		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		intList.reset();
		assertEquals(0, intList.length());

		intList.add(1);
		intList.add(3);
		intList.add(2);

		assertEquals(3, intList.length());
		assertEquals("1, 3, 2", intList.toString());
	}
	
	//tests reset method functions as intended
	@Test
	public void testReset() {
		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		intList.reset();
		assertEquals(0, intList.length());

		intList.add(1);
		intList.add(3);
		intList.add(2);

		assertEquals(3, intList.length());
		assertEquals("1, 3, 2", intList.toString());

	}
	//tests the possible cases for number of elements occurrences
	@Test
	public void testNumOccurrencesOfElement() {
		assertEquals(0, TestData.charNoOrderList().numOccurrencesOfElement('z'));
		assertEquals(2, TestData.charNoOrderList().numOccurrencesOfElement('c'));
	}
	//tests the possible cases for positions of elements
	@Test
	public void testPositionOfElement() {
		ListNoOrder<String> stringList = TestData.stringNoOrderList();
		assertEquals(-1, stringList.positionOfElement("cccccccc"));
		assertEquals(1, stringList.positionOfElement("rat"));
		assertEquals(5, stringList.positionOfElement("eel"));
		assertEquals(8, stringList.positionOfElement("fox"));
	}

	@Test
	public void testElementAtPosition() {
		assertEquals("rat", TestData.stringNoOrderList().elementAtPosition(1).toString());
		ListNoOrder<Integer> intList = TestData.intNoOrderList();
		try {
			intList.numOccurrencesOfElement(null);

			fail();
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	public void testElementsAfter() {
		ListNoOrder<Character> charList = TestData.charNoOrderList();

		assertEquals("s, a, d, e, r", charList.elementsAfter('u').toString());
		assertEquals("", charList.elementsAfter('z').toString());

		assertEquals("p, e, d, c, r, u, s, a, d, e, r", charList.elementsAfter('a').toString());
	}

	@Test
	public void testDistanceBetween() {
		ListNoOrder<String> stringList = TestData.stringNoOrderList();
		assertEquals(2, stringList.distanceBetween("rat", "owl"));
		assertEquals(2, stringList.distanceBetween("rat", "owl"));
		assertEquals(9, stringList.distanceBetween("cat", "cow"));

	}

	@Test
	public void testRemove() {
		ListNoOrder<String> stringList = TestData.stringNoOrderList();

		assertEquals(2, stringList.distanceBetween("rat", "owl"));

	}

	@Test
	public void testCompareTo() {
		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		assertEquals(0, intList.compareTo(intList));
	}

}
