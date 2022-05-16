package testCode;
import static org.junit.Assert.*;

import org.junit.Test;

import studentCode.AlphaListV1;
import studentCode.AlphaListV2;


public class ExampleTests {

	@Test
	public void exampleConstructorTestV1() {
		AlphaListV1 testList = new AlphaListV1();
		assertTrue(testList.list.size() == 26);
		for (int letterPosition=0; letterPosition<26; letterPosition++) {
			assertEquals(0, testList.list.get(letterPosition).size());
		}
	}
	
	@Test
	public void exampleConstructorTestV2() {
		AlphaListV2 testList = new AlphaListV2();
		assertTrue(testList.list.length == 26);
		for (int letterPosition=0; letterPosition<26; letterPosition++) {
			assertEquals(0, testList.list[letterPosition].length);
		}
	}

	@Test
	public void exampleAddTestV1() {
		AlphaListV1 testList = new AlphaListV1();
		testList.insert("APPLE");
		testList.insert("BANANA");
		testList.insert("FISH");
		testList.insert("ZEBRA");
		assertTrue(testList.list.get(0).get(0).equals("APPLE"));
		assertTrue(testList.list.get(1).get(0).equals("BANANA"));
		assertTrue(testList.list.get(5).get(0).equals("FISH"));
		assertTrue(testList.list.get(25).get(0).equals("ZEBRA"));
	}
	
	@Test
	public void exampleAddTestV2() {
		AlphaListV2 testList = new AlphaListV2();
		testList.insert("APPLE");
		testList.insert("BANANA");
		testList.insert("FISH");
		testList.insert("ZEBRA");
		assertTrue(testList.list[0][0].equals("APPLE"));
		assertTrue(testList.list[1][0].equals("BANANA"));
		assertTrue(testList.list[5][0].equals("FISH"));
		assertTrue(testList.list[25][0].equals("ZEBRA"));
	}


}




