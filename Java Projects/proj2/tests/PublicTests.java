package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

/* The four tests of getPay() (tests 16-19) use a form of assertEquals() is
 * used to compare two floating-point (real) numbers, which has three
 * arguments: assertEquals(double1, double2, delta).  It will say that the
 * two doubles are equal if their values are within delta of each other.
 * For instance, a call like assertEquals(2.5, 2.501, 0.01) will be true,
 * while assertEquals(2.5, 2.55, 0.01) will fail.  Comparing real numbers
 * this way is needed due to the imprecision involved with doing arithmetic
 * with them.
 */

/* Although the project grading policies say not to use the form of import
 * using '*' (you should use explicit imports instead), we have to use it in
 * the next line here, because we don't know what classes different students
 * will write in the taManager package, so we can't explicitly import them.
 */
import taManager.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // Just tests creating some Course objects and calling getCourseName() on
  // them.
  @Test public void testPublic1() {
    Course cmsc132= University.createCourse("CMSC", 132, 10);
    Course math140= University.createCourse("MATH", 140, 8);

    assertEquals("CMSC 132", cmsc132.getCourseName());
    assertEquals("MATH 140", math140.getCourseName());
  }

  // Tests hiring some TAs (all of the same type) for a course and calling
  // numTAs().
  @Test public void testPublic2() {
    Course stat400= TestData.stat400();

    assertEquals(4, stat400.numTAs());
  }

  // Tests hiring some TAs (of different types) for a course and calling
  // numTAs(TAType whichType).
  @Test public void testPublic3() {
    Course psyc100= TestData.psyc100();

    assertEquals(10, psyc100.numTAs());
  }

  // Tests the basic operation of taCapacity().
  @Test public void testPublic4() {
    Course engl101= TestData.engl101();
    Course psyc100= TestData.psyc100();

    assertEquals(6, engl101.taCapacity());
    assertEquals(20, psyc100.taCapacity());
  }

  // Tests calling increaseTACapacity() to increase the number of TAs who
  // can be hired for a course.
  @Test public void testPublic5() {
    Course engl101= TestData.engl101();
    Course psyc100= TestData.psyc100();

    engl101.increaseTACapacity(2);
    psyc100.increaseTACapacity(3);

    assertEquals(8, engl101.taCapacity());
    assertEquals(23, psyc100.taCapacity());
  }

  // Tests calling getTANames() for a course that has multiple TAs who are
  // all of the same type.
  @Test public void testPublic6() {
    Course engl101= TestData.engl101();

    assertEquals("Frieda Freshperson, Junior Junior, Paul Pupil, " +
                 "Sophie Sophomore, Steve Student, Ursula Undergraduate",
                 engl101.getTANames());
  }

  // Tests calling getTANames() for a course that has multiple TAs who are
  // of different types.
  @Test public void testPublic7() {
    Course psyc100= TestData.psyc100();

    assertEquals("Frieda Freshperson, Ginny Giraffe, Junior Junior, " +
                 "Kourtney Koala, Lizzie Lizard, Paul Pupil, " +
                 "Sally Salamander, Sophie Sophomore, Steve Student, " +
                 "Ursula Undergraduate",
                 psyc100.getTANames());
  }

  // Tests calling hireUndergraduateTA() and hireGraduateTA() to try to hire
  // TAs with the same names as existing TAs.
  @Test public void testPublic8() {
    Course psyc100= TestData.psyc100();

    assertFalse(psyc100.hireGraduateTA("Kourtney", "Koala", 19530.0));
    assertFalse(psyc100.hireUndergraduateTA("Sophie", "Sophomore", 16.0));

    assertEquals(10, psyc100.numTAs());
  }

  // Tests trying to hire TAs beyond a non-CMSC course's capacity.
  @Test public void testPublic9() {
    Course engl101= TestData.engl101();

    assertFalse(engl101.hireUndergraduateTA("Leanne", "Learner", 14.65));
    assertEquals(6, engl101.numTAs());
    assertEquals(6, engl101.taCapacity());
  }

  // Tests trying to hire TAs beyond a CMSC course's capacity.
  @Test public void testPublic10() {
    Course cmsc132= TestData.cmsc132();
    assertTrue(cmsc132.hireGraduateTA("Leanne", "Learner", 17010.0));

    assertEquals(4, cmsc132.numTAs());

    assertEquals(4, cmsc132.taCapacity());

  }

  // Tests increasing the TA capacity of courses.
  @Test public void testPublic11() {
    Course engl101= TestData.engl101();
    Course cmsc132= TestData.cmsc132();

    assertTrue(engl101.increaseTACapacity(2));
    assertTrue(cmsc132.increaseTACapacity(3));
    assertEquals(8, engl101.taCapacity());
    assertEquals(6, cmsc132.taCapacity());
  }

  // Tests the basic operation of holdOfficeHours() and numOfficeHours().
  @Test public void testPublic12() {
    Course arec365= TestData.arec365();

    assertEquals(16, arec365.numOfficeHours("Freddy", "Frog"));
    assertEquals(14, arec365.numOfficeHours("Jerry", "Giraffe"));
    assertEquals(12, arec365.numOfficeHours("Kourtney", "Koala"));
    assertEquals(10, arec365.numOfficeHours("Sally", "Salamander"));
  }

  // Tests the basic operation of gradeProjects() and numProjectsGraded().
  @Test public void testPublic13() {
    Course cmsc250= TestData.cmsc250();

    assertEquals(45, cmsc250.numProjectsGraded("Emily", "Emu"));
    assertEquals(30, cmsc250.numProjectsGraded("Manuel", "Manatee"));
    assertEquals(32, cmsc250.numProjectsGraded("Otto", "Otter"));
    assertEquals(20, cmsc250.numProjectsGraded("Rhianna", "Rhinoceros"));
  }

  // Tests an undergraduate TA trying to hold more than 20 hours of office
  // hours.
  @Test public void testPublic14() {
    Course bmgt110= University.createCourse("BMGT", 110, 10);

    bmgt110.hireUndergraduateTA("Sheena", "Sheep", 13.90);

    assertTrue(bmgt110.holdOfficeHours("Sheena", "Sheep", 19));
    assertFalse(bmgt110.holdOfficeHours("Sheena", "Sheep", 2));
    assertEquals(19, bmgt110.numOfficeHours("Sheena", "Sheep"));
  }

  // Tests a graduate TA trying to grade more than 150 projects.
  @Test public void testPublic15() {
    Course hist131= University.createCourse("HIST", 131, 10);

    hist131.hireGraduateTA("Arthur", "Aardvark", 21210.0);

    assertTrue(hist131.gradeProjects("Arthur", "Aardvark", 100));
    assertTrue(hist131.gradeProjects("Arthur", "Aardvark", 40));
    assertFalse(hist131.gradeProjects("Arthur", "Aardvark", 20));
    assertEquals(140, hist131.numProjectsGraded("Arthur", "Aardvark"));
  }

  // Tests the basic operation of getPay() for an undergraduate TA who has
  // held some office hours.
  @Test public void testPublic16() {
    Course arec365= TestData.arec365();

    assertEquals(192.0, arec365.getPay("Kourtney", "Koala"), 0.0001);
  }

  // Tests the basic operation of getPay() for an undergraduate TA who has
  // graded some projects.
  @Test public void testPublic17() {
    Course cmsc250= TestData.cmsc250();

    assertEquals(133.5, cmsc250.getPay("Rhianna", "Rhinoceros"), 0.0001);
  }

  // Tests the basic operation of getPay() for a graduate TA who has held
  // some office hours.
  @Test public void testPublic18() {
    Course arec365= TestData.arec365();

    assertEquals(950.0, arec365.getPay("Jerry", "Giraffe"), 0.0001);
  }

  // Tests the basic operation of getPay() for an graduate TA who has graded
  // some projects.
  @Test public void testPublic19() {
    Course cmsc250= TestData.cmsc250();

    assertEquals(870.0, cmsc250.getPay("Emily", "Emu"), 0.0001);
  }

  // Tests nonexistent TAs trying to hold office hours and grade projects.
  @Test public void testPublic20() {
    Course cmsc250= TestData.cmsc250();

    assertFalse(cmsc250.holdOfficeHours("Antonio", "Antelope", 1));
    assertFalse(cmsc250.gradeProjects("Quinn", "Quokka", 1));
  }

}
