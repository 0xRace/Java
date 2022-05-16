package setsAndMaps;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;


public class CourseList {

	Map<String, Collection<String>> courses = new HashMap<String, Collection<String>>();

	public void takeCourse(String student, String course) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (student == null || course == null) {
			throw new IllegalArgumentException();
		}
		else if (courses.containsKey(student)) {
			if (!courses.get(student).contains(course)) {
				courses.get(student).add(course);
			}
		}
		else{
			Set <String> s = new <String> HashSet();
			s.add(course);
			courses.put(student, s);
		}
	}

	public boolean isTakingCourse(String student, String course) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (student == null || course == null) {
			throw new IllegalArgumentException();
		}
		
		else if (courses.containsKey(student)) {
			if (courses.get(student).contains(course)) {
				return true;
			}
		}
		return false;
	}

	public int numCoursesTaking(String student) {
		//throw new UnsupportedOperationException("You must write this method.");
		if (student == null ) {
			throw new IllegalArgumentException();
		}
		return (courses.containsKey(student))?courses.get(student).size():0;
	}

	public int numEnrolled(String course) {
		//throw new UnsupportedOperationException("You must write this method.");
		if (course == null) {
			throw new IllegalArgumentException();
		}
		
		Set<String> names=courses.keySet();
		int count=0;
		  for(String i:names)
		  {
			 count+=(courses.get(i).contains(course))?1:0;
		  }
		  return count;
	}

	public String mostPopularCourse() {
		if(courses.isEmpty() || courses.values().isEmpty()){
			return null;
		}
		String largest="";
		int l=0;
		
		
		  for(String str:courses.keySet())
		  {
			  for (int i = 0; i < courses.get(str).toArray().length; i++) {
					
					if (l < numEnrolled((String) courses.get(str).toArray()[i])) {
						l = numEnrolled((String) courses.get(str).toArray()[i]);
						 largest= (String) courses.get(str).toArray()[i];
					}
					
				}
		  }
		  return largest;
	}

	public boolean dropCourse(String student, String course) {
		//throw new UnsupportedOperationException("You must write this method.");
		if (student == null || course == null) {
			throw new IllegalArgumentException();
		} 
		else if(!courses.containsKey(student)){
			return false;
		}
		else if (courses.get(student).contains(course)) {
			courses.get(student).remove(course);
			return true;

		} else {
			return false;
		}
	}

}
