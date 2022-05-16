package model;

public class TagElement implements Element {

	private String name, attribute;
	private int id;
	private boolean end;
	private Element cont;
	private static int idCounter = 1;
	private static boolean ID;

	public TagElement(String tagName, boolean endTag, Element content, String attributes) {
		name = tagName;
		end = endTag;
		cont = content;
		attribute = attributes;
		id = idCounter;
		idCounter++;

	}

	public int getId() {
		return id;
	}

	public String getStringId() {

		if(ID)
		return "id=\"" + name + id+"\"";
		return "";
	}

	// id will be left out if ID is turned off
	public String getStartTag() {

		if (attribute != null) {
			return "<" + name +" "+getStringId()+ " " + attribute + ">";
		} else {
			return "<" + name + ">";
		}

	}

	public String getEndTag() {
		if(end)
		return "</" + name + ">";
		return "";
	}

	public void setAttributes(String attributes) {
		attribute = attributes;
	}

	public static void enableId(boolean choice) {
		ID = choice;
	}

	public static void resetIds() {
		// TODO Auto-generated method stub
		idCounter = 1;

	}

	@Override
	public String genHTML(int indentation) {
		// TODO Auto-generated method stub
		String gen = "";
		for (int i = 0; i < indentation; i++) {
			gen += " ";
		}
		return gen + getStartTag() + cont.genHTML(0) + getEndTag();
	}

}
