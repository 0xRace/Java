package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import names.Names;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // Tests creating one thread that reads a webpage containing one pair of
  // names, just to ensure that one thread can be created and manipulated
  // correctly.  Calls numNamePairs() to verify that the names were read
  // correctly.
  @Test public void testPublic1() {
    Names names= new Names();

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public1+2.html"
      });

    assertEquals(1, names.numNamePairs());
  }

  // Tests creating one thread that reads a webpage containing one pair of
  // names.  Calls getGirlName(), getBoyName(), getGirlRank() and
  // getBoyRank() on the name to verify that it was read correctly.
  @Test public void testPublic2() {
    Names names= new Names();

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public1+2.html"
      });

    assertEquals("Emma", names.getGirlName(2015, 1));
    assertEquals("Noah", names.getBoyName(2015, 1));

    assertEquals(1, names.getGirlRank(2015, "Emma"));
    assertEquals(1, names.getBoyRank(2015, "Noah"));
  }

  // Tests creating one thread that reads a webpage containing several pairs
  // of names for the same year.
  @Test public void testPublic3() {
    Names names= new Names();
    String[] expectedGirlNames= new String[]{"Emma", "Olivia", "Sophia", "Ava",
                                             "Isabella"};
    String[] expectedBoyNames= new String[]{"Noah", "Liam", "Mason", "Jacob",
                                            "William"};
    int i;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public3.html"
      });

    for (i= 1; i <= 5; i++) {
      assertEquals(expectedGirlNames[i - 1], names.getGirlName(2015, i));
      assertEquals(expectedBoyNames[i - 1], names.getBoyName(2015, i));
      assertEquals(i, names.getGirlRank(2015, expectedGirlNames[i - 1]));
      assertEquals(i, names.getBoyRank(2015, expectedBoyNames[i - 1]));
    }
  }

  // Tests creating one thread that reads a webpage containing several pairs
  // of names for different years (one pair for each year).
  @Test public void testPublic4() {
    Names names= new Names();
    String[] expectedGirlNames= new String[]{"Kaitlyn", "Annabelle", "Morgan",
                                             "Jasmine", "Khloe"};
    String[] expectedBoyNames= new String[]{"Jaden", "Ryder", "Juan",
                                            "Tristan", "Elias"};
    int i;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public4.html"
      });

    for (i= 0; i <= 4; i++) {
      assertEquals(expectedGirlNames[i], names.getGirlName(2011 + i, 1));
      assertEquals(expectedBoyNames[i], names.getBoyName(2011 + i, 1));
      assertEquals(1, names.getGirlRank(2011 + i, expectedGirlNames[i]));
      assertEquals(1, names.getBoyRank(2011 + i, expectedBoyNames[i]));
    }
  }

  // Tests creating one thread that reads a webpage containing multiple
  // pairs of names for different years (multiple pairs for each year).
  @Test public void testPublic5() {
    Names names= new Names();
    String[][] expectedGirlNames= new String[][]{
      {"Alexa", "Angelica", "Erika"},
      {"Alexa", "Cynthia", "Michaela"},
      {"Michaela", "Angelica", "Makayla"},
      {"Angela", "Kristen", "Catherine"},
      {"Leslie", "Diana", "Molly"}
    };
    String[][] expectedBoyNames= new String[][]{
      {"Noah", "Angel", "Mason"},
      {"Victor", "Derek", "Angel"},
      {"Edward", "Jake", "Peter"},
      {"Jackson", "Bradley", "Jake"},
      {"Jeffrey", "Gavin", "Travis"}
    };
    int i, j;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public5+10.html"
      });

    for (i= 0; i <= 4; i++)
      for (j= 1; j <= 3; j++) {
        assertEquals(expectedGirlNames[i][j - 1],
                     names.getGirlName(1995 + i, j));
        assertEquals(expectedBoyNames[i][j - 1],
                     names.getBoyName(1995 + i, j));
        assertEquals(j, names.getGirlRank(1995 + i,
                                          expectedGirlNames[i][j - 1]));
        assertEquals(j, names.getBoyRank(1995 + i,
                                         expectedBoyNames[i][j - 1]));
    }
  }

  // Tests creating two threads that each read their own webpage containing
  // several pairs of names for the same year.
  @Test public void testPublic6() {
    Names names= new Names();
    String[] expectedGirlNames= new String[]{"Michaela", "Angelica",
                                             "Makayla", "Jamie", "Leah",
                                             "Cassidy", "Alexa", "Kaylee",
                                             "Claire", "Chloe"};
    String[] expectedBoyNames= new String[]{"Edward", "Jake", "Peter",
                                             "Gregory", "Spencer", "Victor",
                                             "Derek", "Brendan", "Colton",
                                             "Shawn"};
    int i;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public6a.html",
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public6b.html",
      });

    for (i= 1; i <= 9; i++) {
      assertEquals(expectedGirlNames[i - 1], names.getGirlName(1997, i));
      assertEquals(expectedBoyNames[i - 1], names.getBoyName(1997, i));
      assertEquals(i, names.getGirlRank(1997, expectedGirlNames[i - 1]));
      assertEquals(i, names.getBoyRank(1997, expectedBoyNames[i - 1]));
    }
  }

  // Tests creating two threads that each read their own webpage containing
  // several pairs of names for different years (multiple pairs for each
  // year).
  @Test public void testPublic7() {
    Names names= new Names();
    String[][] expectedGirlNames= new String[][]{
      {"Alexa", "Cynthia", "Michaela", "Kaitlin", "Autumn"},
      {"Michaela", "Angelica", "Makayla", "Jamie", "Leah"},
      {"Angela", "Kristen", "Catherine", "Michaela", "Shannon"},
      {"Leslie", "Diana", "Molly", "Leah", "Zoe"}
    };
    String[][] expectedBoyNames= new String[][]{
      {"Victor", "Derek", "Angel", "Seth", "Mason"},
      {"Edward", "Jake", "Peter", "Gregory", "Spencer"},
      {"Jackson", "Bradley", "Jake", "Mitchell", "Taylor"},
      {"Jeffrey", "Gavin", "Travis", "Edward", "Bradley"}
    };
    int i, j;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public7a.html",
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public7b.html"
      });

    for (i= 0; i <= 3; i++)
      for (j= 1; j <= 4; j++) {
        assertEquals(expectedGirlNames[i][j - 1],
                     names.getGirlName(1996 + i, j));
        assertEquals(expectedBoyNames[i][j - 1],
                     names.getBoyName(1996 + i, j));
        assertEquals(j, names.getGirlRank(1996 + i,
                                          expectedGirlNames[i][j - 1]));
        assertEquals(j, names.getBoyRank(1996 + i,
                                         expectedBoyNames[i][j - 1]));
    }
  }

  // Tests creating three threads that each read their own webpage
  // containing several pairs of names for different years (one pair for
  // each year).
  @Test public void testPublic8() {
    Names names= new Names();
    String[] expectedGirlNames= new String[]{"Bernice", "Fanny", "Lettie",
                                             "Violet", "Helena", "Lily",
                                             "Cecelia", "Dollie", "Jeanette"};
    String[] expectedBoyNames= new String[]{"Clayton", "Pete", "Marvin",
                                            "Reuben", "Sylvester", "Millard",
                                            "Christopher", "Alva", "Hubert"};
    int i, j;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public8a.html",
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public8b.html",
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public8c.html"
      });

    for (i= 1; i <= 8; i++) {
      assertEquals(expectedGirlNames[i], names.getGirlName(1880 + i, 1));
      assertEquals(expectedBoyNames[i], names.getBoyName(1880 + i, 1));
      assertEquals(1, names.getGirlRank(1880 + i, expectedGirlNames[i]));
      assertEquals(1, names.getBoyRank(1880 + i, expectedBoyNames[i]));
    }
  }

  // Tests creating three threads that each read their own webpage
  // containing several pairs of names for different years (multiple pairs
  // for each year).
  @Test public void testPublic9() {
    Names names= new Names();
    String[][] expectedGirlNames= new String[][]{
      {"Gwendolyn", "Colleen", "Judith"},
      {"Deloris", "Imogene", "Nora"},
      {"Mable", "Miriam", "Madeline"},
      {"Kay", "Laverne", "Jeannette"},
      {"Nora", "Rosemarie", "Inez"},
      {"Deloris", "Jennie", "Beulah"}
    };
    String[][] expectedBoyNames= new String[][]{
      {"Bobbie", "Clinton", "Wendell"},
      {"Ramon", "Orville", "Ivan"},
      {"Marshall", "Leland", "Dwight"},
      {"Wendell", "Matthew", "Ira"},
      {"Alexander", "Ivan", "Matthew"},
      {"Juan", "Leland", "Buddy"}
    };
    int i, j;

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public9a.html",
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public9b.html",
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public9c.html"
      });

    for (i= 0; i <= 5; i++)
      for (j= 1; j <= 3; j++) {
        assertEquals(expectedGirlNames[i][j - 1],
                     names.getGirlName(1930 + i, j));
        assertEquals(expectedBoyNames[i][j - 1],
                     names.getBoyName(1930 + i, j));
        assertEquals(j, names.getGirlRank(1930 + i,
                                          expectedGirlNames[i][j - 1]));
        assertEquals(j, names.getBoyRank(1930 + i,
                                         expectedBoyNames[i][j - 1]));
    }
  }

  // Tests that getGirlName() and getBoyName() return null for a year that
  // was not within range for the years passed into getNames().
  @Test public void testPublic10() {
    Names names= new Names();

    names.getNames(new String[]{
        "http://www.cs.umd.edu/class/spring2017/cmsc132/public5+10.html"
      });

    assertNull(names.getGirlName(1994, 1));
    assertNull(names.getBoyName(1994, 1));
    assertNull(names.getGirlName(2000, 1));
    assertNull(names.getBoyName(2000, 1));
  }

}
