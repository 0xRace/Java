/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create courses which have a variety of characteristics,
 *  primarily, they have a certain amount of TAs, of different types, with different pays. This class
 *  provides methods to interact with TAs and the courses themselves. 
 */
package taManager;

public class Course implements TAManager {
	private int courseNumber, numTas;
	private String name;
	private TA[] ta;

	// instantiates the course object given a department, course number, and
	// maxTa
	// instantiates a counter for the number of TAs that have been added as well
	public Course(String department, int courseNo, int maxTas) {
		name = department;
		numTas = 0;
		courseNumber = courseNo;
		ta = new TA[maxTas];
	}

	// returns the name of the course followed by its course number
	public String getCourseName() {

		return name + " " + courseNumber;
	}

	// hire an UndergraduateTA given that the right conditions are met
	public boolean hireUndergraduateTA(String firstName, String lastName, double hourlySalary) {

		// make sure neither name is null and salary is a possible value
		if (firstName == null || lastName == null || hourlySalary <= 0) {
			return false;
		}

		// checks to see that the TA hasn't already been added
		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return false;
			}
		}

		// Checks to see if the course is CMSC and at capacity, if so, increases
		// capacity
		if ((numTas == ta.length) && (name.equals("CMSC"))) {
			increaseTACapacity(1);
		}

		// if possible, creates the TA in the correct slot of the TA array
		if (numTas < ta.length) {
			ta[numTas] = new UndergradTA(firstName, lastName, hourlySalary);
			numTas++;
			return true;
		}

		return false;
	}

	// hire an GraduateTA given that the right conditions are met
	public boolean hireGraduateTA(String firstName, String lastName, double yearlySalary) {

		// make sure neither name is null and salary is a possible value
		if (firstName == null || lastName == null || yearlySalary <= 0) {
			return false;
		}

		// checks to see that the TA hasn't already been added
		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return false;
			}
		}

		// Checks to see if the course is CMSC and at capacity, if so, increases
		// capacity
		if ((numTas == ta.length) && (name.equals("CMSC"))) {
			increaseTACapacity(1);
		}

		// if possible, creates the TA in the correct slot of the TA array
		if (numTas < ta.length) {
			ta[numTas] = new GraduateTA(firstName, lastName, yearlySalary);
			numTas++;
			return true;
		}

		return false;
	}

	// returns the number of TAs that have been added to the current course
	public int numTAs() {

		return numTas;
	}

	// returns the number of TAs of a specific type that have been added to the
	// current course
	public int numTAs(TAType whichType) {

		int count = 0;
		if (whichType == TAType.GRADUATE) {
			for (int i = 0; i < numTas; i++) {
				if (ta[i].getType().equals("GRADUATE")) {
					count++;
				}
			}
			return count;
		} else if (whichType == TAType.UNDERGRADUATE) {
			for (int i = 0; i < numTas; i++) {
				if (ta[i].getType().equals("UNDERGRADUATE")) {
					count++;
				}
			}
			return count;

		}
		return count;
	}

	// returns the capacity of the course
	public int taCapacity() {

		return ta.length;
	}

	// increases the capacity of the course by an integer value
	public boolean increaseTACapacity(int numTAsToAdd) {

		// makes sure of valid integer
		if (numTAsToAdd <= 0) {
			return false;
		}
		// shallow copy with temporary array to increase capacity, keeps all old
		// TAs
		TA[] temp = new TA[numTAsToAdd + ta.length];
		for (int i = 0; i < numTas; i++) {
			temp[i] = ta[i];
		}
		ta = temp;
		return true;
	}

	// returns the full name of each TA, in alphabetical order
	public String getTANames() {
		String total = "";

		// outer for loop to make sure each TA is added
		for (int x = 0; x < numTas; x++) {

			// inner for loop to add TAs in correct order alphabetically
			TA temp = new GraduateTA("Zzz", "Zzz", 0);
			for (int i = 0; i < numTas; i++) {

				// if not already added and last name is equal to temporary last
				// name, checks first name, if valid, makes current TA new
				// temporary
				if ((!(total.contains(ta[i].getName()))) && ta[i].getL().compareTo(temp.getL()) == 0
						&& ta[i].getF().compareTo(temp.getF()) < 0) {

					temp = ta[i];
				}

				// if not already added and last name is correct order
				// alphabetically then it is new temporary
				else if ((!(total.contains(ta[i].getName()))) && ta[i].getL().compareTo(temp.getL()) < 0) {

					temp = ta[i];
				}

			}

			// adds the current temporary to the total string with the correct
			// format, and also to be kept track of
			if (!(total.contains(temp.getL() + temp.getF()))) {
				String a = (x == numTas - 1) ? "" : ", ";
				total += temp.getF() + " " + temp.getL() + a;
			}

		}
		return total;
	}

	// adds office hours to the correct TA, assuming they exist, and that they
	// can have more hours
	public boolean holdOfficeHours(String firstName, String lastName, int numHours) {

		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return ta[i].addHours(numHours);
			}
		}
		return false;
	}

	// returns the number of office hours of a particular TA
	public int numOfficeHours(String firstName, String lastName) {

		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return ta[i].getHours();
			}
		}
		return -1;
	}

	// adds projects to the correct TA, assuming they exist, and that they can
	// have more projects
	public boolean gradeProjects(String firstName, String lastName, int numProjects) {

		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return ta[i].addProjects(numProjects);
			}
		}
		return false;
	}

	// returns the number of projects of a particular TA
	public int numProjectsGraded(String firstName, String lastName) {

		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return ta[i].getProjects();
			}
		}
		return -1;
	}

	// returns the pay of a given TA
	public double getPay(String firstName, String lastName) {

		for (int i = 0; i < numTas; i++) {
			if (ta[i].getName().equals(firstName + " " + lastName)) {
				return ta[i].getPay();
			}
		}
		return 0;
	}

}
