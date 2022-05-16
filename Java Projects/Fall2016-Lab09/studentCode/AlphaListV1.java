package studentCode;

import java.util.ArrayList;

public class AlphaListV1 {

	public ArrayList<ArrayList<String>> list;  // keep this public for easier testing 
	
	public AlphaListV1() {
		//throw new RuntimeException("Implement this...");
		list= new ArrayList<ArrayList<String>>();
		
		for(int i=0;i<26;i++)
		list.add(new ArrayList<String>());
	}
	
	public void insert(String value) {
		//throw new RuntimeException("Implement this...");
		int row= (int)(value.charAt(0))-(int)('A');
		list.get(row).add(value);
	}
	
	public void remove(String value) {
		//throw new RuntimeException("Implement this...");
		
		for(int row=0;row<list.size();row++)
		{
			for(int i=0;i<list.get(row).size();i++)
			{
				if(value.equals(list.get(row).get(i)))
				{
					list.get(row).remove(i);
					i--;
				}
			}
			
		}
	}
	
	public int count() {
		//throw new RuntimeException("Implement this...");
		int count=0;
		for(ArrayList<String> s: list)
		{
			for(String str: s)
			{
				count++;
			}
			
		}
		return count;
	}

}
