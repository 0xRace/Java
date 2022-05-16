package studentCode;

import java.util.ArrayList;

public class AlphaListV2 {

	public String[][] list;  // keep this public for easier testing 
	
	public AlphaListV2() {
		//throw new RuntimeException("Implement this...");
		list= new String[26][0];
		
	}
	
	public void insert(String value) {
		//throw new RuntimeException("Implement this...");
		int row= (int)(value.charAt(0))-(int)('A');
		int size=list[row].length;
		String replace[]=new String[size+1];
		for(int i=0;i<size;i++)
			replace[i]=list[row][i];
		replace[size]=value;
				
		list[row]=replace;
	}
	
	public void remove(String value) {
		//throw new RuntimeException("Implement this...");
		int row= (int)(value.charAt(0))-(int)('A');
		int count=0;
		for(int iter=0;iter<list[row].length;iter++)
		{
			if(list[row][iter].equals(value))
				count++;
			
		}
		
		
		int size=list[row].length-count;		
		String[] replace=new String[size];
		
		
		
		int it=0;
		for(int i=0;i<list[row].length;i++)
		{
			if(!list[row][i].equals(value))
			{
				replace[it]=list[row][i];
				it++;
			}

		}	
		
		list[row]=replace;
	}
	
	public int count() {
		//throw new RuntimeException("Implement this...");
		int count=0;
		
		for(String[] s: list)
		{
			for(String str: s)
			{
				count++;
			}
			
		}
		return count;
	}
	

}
