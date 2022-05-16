package model;

public class AnchorElement extends TagElement{
	private String text,link;

	public AnchorElement(String url, String linkText, String attributes) {
		
		super("a", true, new TextElement(linkText), "href=\""+url+"\"");
		if(attributes!=null){this.setAttributes("href=\""+url+"\" "+attributes);}
		text=linkText;
		link=url;
		
	}
	public String getLinkText() 
	{
		return text;
	}
	
	public String getUrlText() 
	{
		return link;
	}
	
	@Override
	public String genHTML(int indentation) {
		// TODO Auto-generated method stub
		return super.genHTML(indentation);
	}

}
