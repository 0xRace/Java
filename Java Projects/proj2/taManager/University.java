/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create and return course objects
 */
package taManager;

public class University {

	// provided it meets the requirements, this method returns the course
	public static Course createCourse(String department, int courseNumber, int maxNumTAs) {
		if (department == null || department == "" || courseNumber <= 0 || maxNumTAs <= 0) {
			return null;
		}
		Course newCourse = new Course(department, courseNumber, maxNumTAs);
		return newCourse;
	}

}
