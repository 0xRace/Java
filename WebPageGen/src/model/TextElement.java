package model;

public class TextElement implements Element {
	
	private String str;
	public TextElement(String text) 
	{
		str=text;
	}

	@Override
	public String genHTML(int indentation) {
		// TODO Auto-generated method stub
		String gen="";
		for(int i=0;i<indentation;i++) 
		{
			gen+=" ";
		}
		return gen+str;
	}

}
