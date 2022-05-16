/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the UndergradTA object, which extents TA, and differs from GraduateTA in projects, hours, and pay.  
 */
package taManager;

public class UndergradTA extends TA {
	// creates GraduateTA object with super call
	public UndergradTA(String firstName, String lastName, double sal) {

		super(firstName, lastName, sal);
	}

	// copy constructor for graduate TA
	public UndergradTA(UndergradTA t) {

		super(t);
	}

	// Overridden method to add projects for an UndergradTA that takes into
	// account the hour and project limit
	@Override
	public boolean addProjects(int num) {
		if (getHours() + (.5 * (getProjects() + num)) <= 20) {
			super.addProjects(num);
			return true;
		}
		return false;
	}

	// Overridden method to add hours for an UndergradTA that takes into
	// account the hour and project limit
	@Override
	public boolean addHours(int num) {

		if (getHours() + num + (.5 * getProjects()) <= 20) {
			super.addHours(num);
			return true;
		}
		return false;
	}

	// Overridden method to account for hourly wage pay
	@Override
	public double getPay() {
		return (getHours() + (.5 * getProjects())) * super.getPay();
	}

	// method to return type
	@Override
	public String getType() {
		return "UNDERGRADUATE";
	}

}
