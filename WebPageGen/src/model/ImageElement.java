package model;

public class ImageElement extends TagElement {
	String url;

	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, new TextElement(""), "src=\""+imageURL+"\" "+ "width=\""+width+"\" "+"height=\""+height+"\" "+"alt=\""+alt+"\"");
		// TODO Auto-generated constructor stub
		url=imageURL;
	}
	public String getImageURL() 
	{
		return url;
	}

}
