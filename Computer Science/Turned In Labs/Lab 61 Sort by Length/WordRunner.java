import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

// this class is complete
public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("words.dat"));

		int size = file.nextInt();
		file.nextLine();
		
		Word[] words = new Word[size];
		for(int i=0; i<words.length; i++)
		{
			words[i]=new Word(file.nextLine());
		}

		Arrays.sort(words);

		for(Word word : words)
		{
			out.println(word);
		}
	}
}