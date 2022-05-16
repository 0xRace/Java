/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the GraduateTA object, which extents TA, and differs from UndergraduateTA in projects, hours, and pay.  
 */
package taManager;

public class GraduateTA extends TA {

	// creates GraduateTA object with super call
	public GraduateTA(String firstName, String lastName, double sal) {

		super(firstName, lastName, sal);
	}

	// copy constructor for graduate TA
	public GraduateTA(GraduateTA t) {

		super(t);
	}

	// Overridden method for GradTA's that accounts for the limit of 150
	// projects
	@Override
	public boolean addProjects(int num) {
		if (super.getProjects() + num <= 150) {
			super.addProjects(num);
			return true;
		}
		return false;
	}

	// Overridden method to return the GraduateTA pay divided correctly
	@Override
	public double getPay() {
		return super.getPay() / 21;
	}

	// Method to return the type
	@Override
	public String getType() {
		return "GRADUATE";
	}

}
