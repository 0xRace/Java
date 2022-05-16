package model;

public class ListElement extends TagElement {

	public ListElement(boolean ordered, String attributes) {
		super((ordered)?"ul":"ol",true,new TextElement(""),attributes);
		
		// TODO Auto-generated constructor stub
	}

	public void addItem(Element content) {
		// TODO Auto-generated method stub
		
	}

}
