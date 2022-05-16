import static java.lang.System.*;

// this class is complete
public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		WordsCompare test = new WordsCompare("abe","ape");
		out.println(test);

		test.setWords("giraffe","gorilla");
		test.compare();
		out.println(test);

		test.setWords("one","two");
		test.compare();
		out.println(test);
		
		test.setWords("fun","funny");
		test.compare();
		out.println(test);
		
		test.setWords("123","19");
		test.compare();
		out.println(test);
		
		test.setWords("goofy","godfather");
		test.compare();
		out.println(test);
		
		test.setWords("funnel","fun");
		test.compare();
		out.println(test);
	}
}