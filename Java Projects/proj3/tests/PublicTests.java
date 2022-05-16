package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import listAndSublist.ListNoOrder;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

	// Tests adding some elements to a ListNoOrder object and checking its
	// length.
	@Test
	public void testPublic1() {
		assertEquals(18, TestData.intNoOrderList().length());
	}

	// Tests calling toString() on a ListNoOrder object, after adding some
	// elements.
	@Test
	public void testPublic2() {
		assertEquals("7, 8, 15, 15, 2, 8, 8, 14, 3, " + "16, 13, 7, 13, 17, 8, 2, 20, 10",
				TestData.intNoOrderList().toString());
		
	}

	// Tests whether reset() properly removes all elements from a ListNoOrder
	// object.
	@Test
	public void testPublic3() {
		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		// reset the list
		intList.reset();
		assertEquals(0, intList.length());

		// now add some new elements
		intList.add(1);
		intList.add(3);
		intList.add(2);

		// now check the current contents
		assertEquals(3, intList.length());
		assertEquals("1, 3, 2", intList.toString());
	}

	// Tests calling numOccurrencesOfElement() on different elements that are
	// present in a ListNoOrder object.
	@Test
	public void testPublic4() {
		ListNoOrder<Character> charList = TestData.charNoOrderList();

		assertEquals(1, charList.numOccurrencesOfElement('p'));
		assertEquals(1, charList.numOccurrencesOfElement('u'));
		assertEquals(2, charList.numOccurrencesOfElement('e'));
		assertEquals(2, charList.numOccurrencesOfElement('d'));
	}

	// Tests calling numOccurrencesOfElement() on an element that is not
	// present in a ListNoOrder object.
	@Test
	public void testPublic5() {
		assertEquals(0, TestData.charNoOrderList().numOccurrencesOfElement('z'));
	}

	// Tests calling positionOfElement on different elements that are present
	// in a ListNoOrder object.
	@Test
	public void testPublic6() {
		ListNoOrder<String> stringList = TestData.stringNoOrderList();

		assertEquals(1, stringList.positionOfElement("rat"));
		assertEquals(5, stringList.positionOfElement("eel"));
		assertEquals(8, stringList.positionOfElement("fox"));
	}

	// Tests calling positionOfElement() on an element that is not present in
	// a ListNoOrder object.
	@Test
	public void testPublic7() {
		assertEquals(-1, TestData.stringNoOrderList().positionOfElement("bat"));
	}

	// Tests calling elementAtPosition() on a ListNoOrder object in typical
	// cases.
	@Test
	public void testPublic8() {
		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		assertEquals(8, (int) intList.elementAtPosition(1));
		assertEquals(3, (int) intList.elementAtPosition(8));
		assertEquals(20, (int) intList.elementAtPosition(16));
	}

	// Tests calling elementAtPosition() on a ListNoOrder object when position
	// is negative, which should throw the expected IndexOutOfBoundsException.
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPublic9() {
		TestData.intNoOrderList().elementAtPosition(-2);
	}

	// Tests calling elementAtPosition() on a ListNoOrder object when position
	// is greater than the position of the last element in the current object
	// list, which should throw the expected IndexOutOfBoundsException.
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPublic10() {
		TestData.intNoOrderList().elementAtPosition(18);
	}

	// Tests calling elementsAfter() on a ListNoOrder object in typical cases.
	@Test
	public void testPublic11() {
		ListNoOrder<Character> charList = TestData.charNoOrderList();

		assertEquals("s, a, d, e, r", charList.elementsAfter('u').toString());
		// there are multiple occurrences of 'a' in the list
		assertEquals("p, e, d, c, r, u, s, a, d, e, r", charList.elementsAfter('a').toString());
	}

	// Tests calling distanceBetween() on a ListNoOrder object in typical
	// cases.
	@Test
	public void testPublic12() {
		ListNoOrder<String> stringList = TestData.stringNoOrderList();

		assertEquals(2, stringList.distanceBetween("rat", "owl"));
		assertEquals(9, stringList.distanceBetween("cat", "cow"));
	}

	// Tests calling compareTo() on two ListNoOrder objects that have all the
	// same elements in the same order.
	@Test
	public void testPublic13() {
		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		assertEquals(0, intList.compareTo(intList));
	}

	// Tests calling compareTo() on two ListNoOrder objects that have
	// different elements.
	@Test
	public void testPublic14() {
		ListNoOrder<Character> otherList = new ListNoOrder<Character>();

		for (Character ch : new Character[] { 'b', 'a', 't', 'm', 'a', 'n' })
			otherList.add(ch);

		assertTrue(TestData.charNoOrderList().compareTo(otherList) > 0);
	}

	// Tests calling toString() on a ListInOrder object, after adding some
	// elements.
	@Test
	public void testPublic15() {

		assertEquals("2, 2, 3, 7, 7, 8, 8, 8, 8, 10, " + "13, 13, 14, 15, 15, 16, 17, 20",
				TestData.intInOrderList().toString());
	}

	// Tests calling a few of the methods on empty lists.
	@Test
	public void testPublic16() {
		ListNoOrder<Boolean> emptyList = new ListNoOrder<Boolean>();

		assertEquals(0, emptyList.length());

		emptyList.reset(); // should have no effect; list should still be empty
		assertEquals(0, emptyList.length());
		assertEquals("", emptyList.toString());

		assertEquals(0, emptyList.compareTo(emptyList));
	}

	// Tests calling some of the methods with null parameters. This test
	// illustrates another way of testing whether expected exceptions are
	// thrown, which may be more convenient when it's expected that multiple
	// exceptions will be thrown by tests in a single method.
	@Test
	public void testPublic17() {
		ListNoOrder<Integer> intList = TestData.intNoOrderList();

		try {
			intList.numOccurrencesOfElement(null);
			// if we reach here- meaning if the expected exception is not
			// thrown-
			// the test should fail
			fail();
		} catch (IllegalArgumentException iae) {
			// if we get here the expected exception was thrown, so continue to
			// the
			// next thing we want to test
		}

		try {
			intList.positionOfElement(null);
			// if we reach here- meaning if the expected exception is not
			// thrown-
			// the test should fail
			fail();
		} catch (IllegalArgumentException iae) {
			// if we get here the expected exception was thrown, so continue to
			// the
			// next thing we want to test
		}

		try {
			intList.elementsAfter(null);
			// if we reach here- meaning if the expected exception is not
			// thrown-
			// the test should fail
			fail();
		} catch (IllegalArgumentException iae) {
			// if we get here the test should pass
		}
	}

}
