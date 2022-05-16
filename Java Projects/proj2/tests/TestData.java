package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

/* Although the project grading policies say not to use this form of import
 * (to use explicit imports instead), we have to use it here, because we
 * don't know what classes you will write in the taManager package.
 */
import taManager.*;

/* This class contains utility methods that create and return example Course
 * objecs that the public (and secret) tests can use, to reduce the amout of
 * code needed in different tests to create objects to test the methods
 * with.  You can use these methods in your student tests as well, but don't
 * modify this file, because our version is going to be used on the submit
 * server.  (You can either write your own helper methods in your
 * StudentTests class, and you can add your own classes to the tests
 * package, if you want to use modified versions of these methods.)
 */

public class TestData {

  public static Course stat400() {
    Course course= University.createCourse("STAT", 400, 6);

    course.hireGraduateTA("Sally", "Salamander", 21000.0);
    course.hireGraduateTA("Freddy", "Frog", 18900.0);
    course.hireGraduateTA("Jerry", "Giraffe", 19950.0);
    course.hireGraduateTA("Kourtney", "Koala", 19425.0);

    return course;
  }

  public static Course engl101() {
    Course course= University.createCourse("ENGL", 101, 6);

    course.hireUndergraduateTA("Paul", "Pupil", 15.0);
    course.hireUndergraduateTA("Steve", "Student", 15.25);
    course.hireUndergraduateTA("Ursula", "Undergraduate", 16.0);
    course.hireUndergraduateTA("Junior", "Junior", 15.75);
    course.hireUndergraduateTA("Sophie", "Sophomore", 16.5);
    course.hireUndergraduateTA("Frieda", "Freshperson", 15.5);

    return course;
  }

  public static Course psyc100() {
    Course course= University.createCourse("PSYC", 100, 20);

    course.hireGraduateTA("Lizzie", "Lizard", 18900.0);
    course.hireUndergraduateTA("Paul", "Pupil", 15.0);
    course.hireUndergraduateTA("Frieda", "Freshperson", 15.5);
    course.hireGraduateTA("Kourtney", "Koala", 19425.0);
    course.hireUndergraduateTA("Junior", "Junior", 15.75);
    course.hireUndergraduateTA("Steve", "Student", 15.25);
    course.hireGraduateTA("Ginny", "Giraffe", 19950.0);
    course.hireUndergraduateTA("Sophie", "Sophomore", 16.5);
    course.hireUndergraduateTA("Ursula", "Undergraduate", 16.0);
    course.hireGraduateTA("Sally", "Salamander", 21000.0);

    return course;
  }

  public static Course arec365() {
    Course course= University.createCourse("PSYC", 100, 10);

    course.hireGraduateTA("Sally", "Salamander", 21000.0);
    course.hireUndergraduateTA("Freddy", "Frog", 15.0);
    course.hireGraduateTA("Jerry", "Giraffe", 19950.0);
    course.hireUndergraduateTA("Kourtney", "Koala", 16.0);

    course.holdOfficeHours("Kourtney", "Koala", 6);
    course.holdOfficeHours("Freddy", "Frog", 2);
    course.holdOfficeHours("Sally", "Salamander", 4);
    course.holdOfficeHours("Freddy", "Frog", 5);
    course.holdOfficeHours("Freddy", "Frog", 3);
    course.holdOfficeHours("Jerry", "Giraffe", 3);
    course.holdOfficeHours("Sally", "Salamander", 6);
    course.holdOfficeHours("Freddy", "Frog", 2);
    course.holdOfficeHours("Jerry", "Giraffe", 3);
    course.holdOfficeHours("Jerry", "Giraffe", 5);
    course.holdOfficeHours("Freddy", "Frog", 4);
    course.holdOfficeHours("Jerry", "Giraffe", 3);
    course.holdOfficeHours("Kourtney", "Koala", 6);

    return course;
  }

  public static Course cmsc132() {
    Course course= University.createCourse("CMSC", 132, 3);

    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
    course.hireGraduateTA("Horace", "Horse", 19215.0);

    return course;
  }

  public static Course cmsc250() {
    Course course= University.createCourse("CMSC", 250, 4);

    course.hireGraduateTA("Emily", "Emu", 18270.0);
    course.hireUndergraduateTA("Rhianna", "Rhinoceros", 13.35);
    course.hireGraduateTA("Manuel", "Manatee", 18690.0);
    course.hireGraduateTA("Otto", "Otter", 19320.0);

    course.gradeProjects("Rhianna", "Rhinoceros", 16);
    course.gradeProjects("Emily", "Emu", 10);
    course.gradeProjects("Rhianna", "Rhinoceros", 4);
    course.gradeProjects("Emily", "Emu", 20);
    course.gradeProjects("Emily", "Emu", 15);
    course.gradeProjects("Manuel", "Manatee", 12);
    course.gradeProjects("Manuel", "Manatee", 12);
    course.gradeProjects("Manuel", "Manatee", 6);
    course.gradeProjects("Otto", "Otter", 32);

    return course;
  }

}
