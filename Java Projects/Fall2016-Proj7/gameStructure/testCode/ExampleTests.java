package testCode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import studentCode.BattleCow;
import studentCode.BattleDeck;
import studentCode.BattleFish;
import studentCode.Battleable;
import studentCode.PouchCreature;
import studentCode.Universe.Outcomes;

public class ExampleTests {

	public void twoStrings(String str1, String str2) {
		assertEquals(str1.replaceAll(" ", ""),str2.replaceAll(" ", ""));
	}



	@Test
	public void exampleTestOne() {
		Battleable thing;

		thing = new BattleCow("Jan", 7);
		twoStrings("BattleCow<Name: Jan  Strength: 7  Level: 5>", thing.toString());


		thing = new BattleFish("Jim", 5);
		twoStrings("BattleFish<Name: Jim  Strength: 5  Level: 1>", thing.toString());


		thing = new PouchCreature("PeekAtYou", 3);
		twoStrings("PouchCreature<Name: PeekAtYou  Strength: 3  Level: 0>", thing.toString());

		thing = new PouchCreature("Eeek", 3);
		twoStrings("PouchCreature<Name: Eeek  Strength: 3  Level: 9>", thing.toString());
	}



	@Test
	public void exampleTestTwo() {
		Battleable thing;

		thing = new BattleCow("Jan", 7);
		assertEquals("Jan", thing.getName());
		assertEquals(5,thing.getLevel());
		assertEquals(7,thing.getStrength());


		thing = new BattleFish("Jim", 5);
		assertEquals("Jim", thing.getName());
		assertEquals(1,thing.getLevel());
		assertEquals(5,thing.getStrength());

		thing = new PouchCreature("PeekAtYou", 3);
		assertEquals("PeekAtYou", thing.getName());
		assertEquals(0,thing.getLevel());
		assertEquals(3,thing.getStrength());

		thing = new PouchCreature("Eeek", 3);
		assertEquals("Eeek", thing.getName());
		assertEquals(9,thing.getLevel());
		assertEquals(3,thing.getStrength());
	}


	@Test
	public void exampleTestThree() {
		Battleable thing;

		thing = new BattleCow("Jan", 7);
		assertEquals(thing, thing.returnDuplicate());
		assertFalse(thing == thing.returnDuplicate());

		thing = new BattleFish("Jim", 5);
		assertEquals(thing, thing.returnDuplicate());
		assertFalse(thing == thing.returnDuplicate());

		thing = new PouchCreature("PeekAtYou", 3);
		assertEquals(thing, thing.returnDuplicate());
		assertFalse(thing == thing.returnDuplicate());

		thing = new PouchCreature("Eeek", 3);
		assertEquals(thing, thing.returnDuplicate());
		assertFalse(thing == thing.returnDuplicate());
	}


	@Test
	public void exampleTestFour() {
		Battleable thing;

		thing = new BattleCow("Jan", 7);
		for (int i=0; i<16; i++) {
			thing.inform(Outcomes.WIN);
			assertEquals(5,thing.getLevel());
		}
		thing.inform(Outcomes.DRAW);
		assertEquals(5,thing.getLevel());
		assertEquals(7,thing.getStrength());
		thing.inform(Outcomes.WIN);
		assertEquals(6,thing.getLevel());
		thing.inform(Outcomes.LOSE);
		assertEquals(0,thing.getStrength());
	}




	@Test
	public void exampleTestFive() {
		BattleDeck<BattleFish> bq = new BattleDeck<BattleFish>();
		bq.add(new BattleFish("one", 1));
		bq.add(new BattleFish("two", 2));
		bq.add(new BattleFish("three", 3));
		bq.add(new BattleFish("four", 4));
		bq.add(new BattleFish("five", 5));

		twoStrings(
				"Contents: [ BattleFish<Name: five  Strength: 5  Level: 1>, BattleFish<Name: three  Strength: 3  Level: 1>, BattleFish<Name: one  Strength: 1  Level: 1>, BattleFish<Name: two  Strength: 2  Level: 1>, BattleFish<Name: four  Strength: 4  Level: 1> ]",
				bq.toString()
				);
	}



	@Test
	public void exampleTestSix() {
		BattleDeck<BattleFish> bq = new BattleDeck<BattleFish>();
		bq.add(new BattleFish("one", 11));
		bq.add(new BattleFish("two", 12));
		bq.add(new BattleFish("three", 13));
		bq.add(new BattleFish("four", 14));
		bq.add(new BattleFish("five", 15));

		bq.weakenCreatures(1);
		twoStrings(
				"Contents: [ BattleFish<Name: five  Strength: 14  Level: 1>, BattleFish<Name: three  Strength: 12  Level: 1>, BattleFish<Name: one  Strength: 10  Level: 1>, BattleFish<Name: two  Strength: 11  Level: 1>, BattleFish<Name: four  Strength: 13  Level: 1> ]",
				bq.toString()
				);
	}


	@Test
	public void exampleTestSeven() {
		BattleDeck<BattleFish> bq = new BattleDeck<BattleFish>();
		bq.add(new BattleFish("one", 11));
		bq.add(new BattleFish("two", 12));
		bq.add(new BattleFish("three", 13));
		bq.add(new BattleFish("four", 14));
		bq.add(new BattleFish("five", 15));

		bq.weakenCreatures(11);
		bq.sweepDeck();
		twoStrings(
				"Contents: [ BattleFish<Name: five  Strength: 4  Level: 1>, BattleFish<Name: three  Strength: 2  Level: 1>, BattleFish<Name: two  Strength: 1  Level: 1>, BattleFish<Name: four  Strength: 3  Level: 1> ]",
				bq.toString()
				);

	}


	@Test
	public void exampleTestEight() {
		BattleDeck<BattleFish> bq = new BattleDeck<BattleFish>();
		bq.add(new BattleFish("one", 11));
		bq.add(new BattleFish("two", 12));
		bq.add(new BattleFish("three", 13));
		bq.add(new BattleFish("four", 14));

		twoStrings(
				"Contents: [ BattleFish<Name: three  Strength: 13  Level: 1>, BattleFish<Name: one  Strength: 11  Level: 1>, BattleFish<Name: two  Strength: 12  Level: 1>, BattleFish<Name: four  Strength: 14  Level: 1> ]",
				bq.toString()
				);

		twoStrings(
				"BattleFish<Name: four  Strength: 14  Level: 1>",
				bq.solitaireFight().toString()
				);

		twoStrings(
				"BattleFish<Name: two  Strength: 11  Level: 1>",
				bq.solitaireFight().toString()
				);
	}



	@Test
	public void exampleTestNine() {
		BattleDeck<Battleable> bq = new BattleDeck<Battleable>();

		bq.add(new BattleCow("one", 11));
		bq.add(new PouchCreature("A", 7));
		bq.add(new BattleFish("two", 12));
		bq.add(new PouchCreature("Z", 7));
		bq.add(new BattleCow("three", 13));
		bq.add(new PouchCreature("L", 7));
		bq.add(new BattleFish("four", 14));

		twoStrings(
				"[PouchCreature<Name: Z  Strength: 7  Level: 0>]",
				Arrays.toString(bq.export2Darray()[0])
				);
		twoStrings(
				"[BattleFish<Name: four  Strength: 14  Level: 1>, BattleFish<Name: two  Strength: 12  Level: 1>]",
				Arrays.toString(bq.export2Darray()[1])
				);
		twoStrings(
				"[]",
				Arrays.toString(bq.export2Darray()[2])
				);	
		twoStrings(
				"[]",
				Arrays.toString(bq.export2Darray()[3])
				);	
		twoStrings(
				"[]",
				Arrays.toString(bq.export2Darray()[4])
				);	
		twoStrings(
				"[BattleCow<Name: three  Strength: 13   Level: 5>, BattleCow<Name: one  Strength: 11  Level: 5>, PouchCreature<Name: A  Strength: 7  Level: 5>]",
				Arrays.toString(bq.export2Darray()[5])
				);	
		twoStrings(
				"[PouchCreature<Name: L  Strength: 7  Level: 6>]",
				Arrays.toString(bq.export2Darray()[6])
				);	
		twoStrings(
				"[]",
				Arrays.toString(bq.export2Darray()[7])
				);	
		twoStrings(
				"[]",
				Arrays.toString(bq.export2Darray()[8])
				);	
		twoStrings(
				"[]",
				Arrays.toString(bq.export2Darray()[9])
				);	
	}

	

}
