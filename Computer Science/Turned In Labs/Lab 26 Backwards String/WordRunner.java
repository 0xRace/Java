import static java.lang.System.*;

public class WordRunner
{
	public static void main ( String[] args )
	{
		Word demo = new Word("Hello");
		out.println(demo.getFirstChar());
		out.println(demo.getLastChar());
		out.println(demo.getBackWards());
		out.println(demo+"\n\n");

		demo.setString("World");
		out.println(demo.getFirstChar());
		out.println(demo.getLastChar());
		out.println(demo.getBackWards());
		out.println(demo+"\n\n");
		
		//add three more test cases		
		demo.setString("JukeBox");
		out.println(demo.getFirstChar());
		out.println(demo.getLastChar());
		out.println(demo.getBackWards());
		out.println(demo+"\n\n");
		
		demo.setString("TCEA");
		out.println(demo.getFirstChar());
		out.println(demo.getLastChar());
		out.println(demo.getBackWards());
		out.println(demo+"\n\n");
		
		demo.setString("UIL");
		out.println(demo.getFirstChar());
		out.println(demo.getLastChar());
		out.println(demo.getBackWards());
		out.println(demo+"\n\n");
	}
}