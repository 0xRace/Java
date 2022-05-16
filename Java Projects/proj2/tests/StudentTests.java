/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create tests for the University class
 */
package tests;

import org.junit.*;

import taManager.Course;
import taManager.TAManager.TAType;
import taManager.University;

import static org.junit.Assert.*;

public class StudentTests {
	
	//Tests that courses may only be created under the right circumstances
	@Test	
	public void TestCourse()
	{
		
	    assertEquals(null,University.createCourse("", 1, 1));
	    assertEquals(null,University.createCourse(null, 1, 1));
	    assertEquals(null,University.createCourse(" ", 0, 1));
	    assertEquals(null,University.createCourse(" ", 1, 0));
	}
	
	//Tests that courseName returns correctly with the number included
	@Test	
	public void TestCourseName()
	{
		Course course= University.createCourse("CMSC", 132, 3);
	    assertEquals("CMSC 132",course.getCourseName());
	}
	
	//Tests that hireUndergraduateTA only adds TAs under the correct circumstances
	// and that course size is correctly increased depending on if it is cmsc or not
	@Test	
	public void TestHireUTA()
	{
		Course course= University.createCourse("OTHER", 132, 1);	
		assertEquals(1,course.taCapacity());
	    assertEquals(false, course.hireUndergraduateTA(null, "Zebra", 13.25));
	    assertEquals(false, course.hireUndergraduateTA("Zebra", null, 13.25));
	    assertEquals(false, course.hireUndergraduateTA("ZE", "Zebra", 0));
	    assertEquals(true, course.hireUndergraduateTA("ZE", "Zebra", 1));
	    assertEquals(false, course.hireUndergraduateTA("ZE", "Zebra", 1));
	    assertEquals(false, course.hireUndergraduateTA("ZEb", "Zebrdsa", 1));
	    course.increaseTACapacity(1);
	    assertEquals(true, course.hireUndergraduateTA("ZEb", "Zebrdsa", 1));
	    assertEquals(false, course.hireUndergraduateTA("ZEsdb", "Zebrdsasdf", 1));
	    
	    Course courseb= University.createCourse("CMSC", 132, 1);	
		assertEquals(1,courseb.taCapacity());
	    assertEquals(true, courseb.hireUndergraduateTA("ZE", "Zebra", 1));   
	    assertEquals(true, courseb.hireUndergraduateTA("ZEb", "Zebrdsa", 1));
	    
	    
	    

	}
	
	//Tests that hireGraduateTA only adds TAs under the correct circumstances
	// and that course size is correctly increased depending on if it is cmsc or not
	@Test	
	public void TestHireGTA()
	{
		Course course= University.createCourse("OTHER", 132, 1);	
		assertEquals(1,course.taCapacity());
	    assertEquals(false, course.hireUndergraduateTA(null, "Zebra", 13.25));
	    assertEquals(false, course.hireUndergraduateTA("Zebra", null, 13.25));
	    assertEquals(false, course.hireUndergraduateTA("ZE", "Zebra", 0));
	    assertEquals(true, course.hireUndergraduateTA("ZE", "Zebra", 1));
	    assertEquals(false, course.hireUndergraduateTA("ZE", "Zebra", 1));
	    assertEquals(false, course.hireUndergraduateTA("ZEb", "Zebrdsa", 1));
	    course.increaseTACapacity(1);
	    assertEquals(true, course.hireUndergraduateTA("ZEb", "Zebrdsa", 1));
	    assertEquals(false, course.hireUndergraduateTA("ZEsdb", "Zebrdsasdf", 1));
	    
	    Course courseb= University.createCourse("CMSC", 132, 1);	
		assertEquals(1,courseb.taCapacity());
	    assertEquals(true, courseb.hireUndergraduateTA("ZE", "Zebra", 1));   
	    assertEquals(true, courseb.hireUndergraduateTA("ZEb", "Zebrdsa", 1));
	    
	    

	}
	
	//Tests that numTAs returns correctly
	@Test	
	public void TestNumTAs()
	{
		Course course= University.createCourse("CMSC", 132, 3);
		assertEquals(0,course.numTAs());
	    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
	    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
	    course.hireGraduateTA("Horace", "Horse", 19215.0);
	    assertEquals(3,course.numTAs());
	}
	
	//Tests that numTAs of a specific type return correctly
	@Test	
	public void TestNumTypeTAs()
	{
		Course course= University.createCourse("CMSC", 132, 3);
		assertEquals(0,course.numTAs((TAType.GRADUATE)));
	    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
	    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
	    course.hireGraduateTA("Horace", "Horse", 19215.0);
	    assertEquals(1,course.numTAs((TAType.UNDERGRADUATE)));
	    assertEquals(2,course.numTAs((TAType.GRADUATE)));
	}
	
	
	//Tests that names are returns correctly in alphabetical order
	@Test	
	public void TestGetNames()
	{
		Course course= University.createCourse("CMSC", 132, 3);

	    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
	    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
	    course.hireGraduateTA("Horace", "Horse", 19215.0);
	    assertEquals("Horace Horse, Oscar Ostrich, Zena Zebra",course.getTANames());
	}
	
	//Tests that UTAs can hold max 20 hours and that there is no limit for GTAs
	@Test	
	public void TestOfficeHours()
	{
		Course course= University.createCourse("CMSC", 132, 3);
	    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
	    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
	    course.hireGraduateTA("Horace", "Horse", 19215.0);
	    assertEquals(false,course.holdOfficeHours("Oscard", "Ostrich",1000 ));
	    assertEquals(true,course.holdOfficeHours("Oscar", "Ostrich",1000 ));
	    assertEquals(true,course.holdOfficeHours("Zena","Zebra",19));
	    assertEquals(true,course.holdOfficeHours("Zena","Zebra",1));
	    assertEquals(false,course.holdOfficeHours("Zena","Zebra",1));
	    
	}
	
	//Tests that UTAs can have at most 40 projects, and that GTAs can have at most 150
	@Test
	public void TestProjects()
	{
		Course course= University.createCourse("CMSC", 132, 3);
	    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
	    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
	    
	    assertEquals(false,course.gradeProjects("Oscar", "Ostrich",1000 ));
	    assertEquals(true,course.gradeProjects("Oscar", "Ostrich",149));
	    assertEquals(true,course.gradeProjects("Oscar", "Ostrich",1));
	    assertEquals(false,course.gradeProjects("Oscar", "Ostrich",1));
	    
	    assertEquals(false,course.gradeProjects("Zena","Zebra",41));
	    assertEquals(true,course.gradeProjects("Zena","Zebra",39));
	    assertEquals(true,course.gradeProjects("Zena","Zebra",1));
	    assertEquals(false,course.gradeProjects("Zena","Zebra",1));
	    
	}
	
	//Tests that pay is being calculated correctly between the two types of TAs
	@Test
	public void TestPay()
	{
		Course course= University.createCourse("CMSC", 132, 3);
	    course.hireGraduateTA("Oscar", "Ostrich", 20475.0);
	    course.hireUndergraduateTA("Zena", "Zebra", 13.25);
	    
	    assertTrue(course.getPay("Oscar","Ostrich")==(20475.0/21));
	    
	    assertTrue(course.getPay("Zena","Zebra")==0);
	    course.holdOfficeHours("Zena","Zebra",1);
	    assertTrue(course.getPay("Zena","Zebra")==13.25);
	    
	    
	}

  // write your student tests in this class

}
