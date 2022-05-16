/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the TA object, which will be used to populate the courses 
 */
package taManager;

public abstract class TA {
	private String name, f, l;
	private int officeHours, projects;
	private double salary;

	// instantiates a TA object with the given values
	// and instantiates all other values
	public TA(String firstName, String lastName, double sal) {
		name = firstName + " " + lastName;
		f = firstName;
		l = lastName;
		officeHours = 0;
		projects = 0;
		salary = sal;
	}

	// copy constructor for TA
	public TA(TA t) {
		name = t.getName();
		f = t.getF();
		l = t.getL();
		officeHours = t.getHours();
		projects = t.getProjects();
		salary = t.getSal();
	}

	public String getName() {
		return name;
	}

	private double getSal() {
		return salary;
	}

	// returns the first name
	public String getF() {
		return f;
	}

	// returns the last name
	public String getL() {
		return l;
	}

	public int getHours() {
		return officeHours;
	}

	public int getProjects() {
		return projects;
	}

	public double getPay() {
		return salary;
	}

	public boolean addProjects(int num) {
		projects += num;
		return true;
	}

	public boolean addHours(int num) {
		officeHours += num;
		return true;
	}

	public abstract String getType();

}
