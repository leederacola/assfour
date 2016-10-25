import java.util.*;
import java.io.*;

public class assfour
{
	public long dictCount = 0;
	public double wordsFound = 0;
	public double wordsNotFound = 0;
	public double compFound = 0;
	public double compNotFound = 0;
	public double avgcompswordsfound = 0.0;
	public double avgcompswordsnotfound = 0.0;
	MyLinkedList[] dict = new MyLinkedList[26];
	
	public static void main (String[] args)
	{
		long Start = System.nanoTime();
		assfour ryan = new assfour();
		ryan.makeDict();
		ryan.parseString();
		ryan.averages();
		long Stop = System.nanoTime();
		long time = (Stop - Start);
		System.out.println("time = " + time);

		
		//avgcompswordsfound =  compFound / wordsFound; // ( avg # of comps per word)
		//avgcompswordsnotfound = compNotFound / wordsNotFound; //(avg # of comps per word not found)
	}
	public void averages()
	{
		avgcompswordsfound =  compFound / wordsFound; // ( avg # of comps per word)
		avgcompswordsnotfound = compNotFound / wordsNotFound; //(avg # of comps per word not found)	
		System.out.println("average comps words found= " + avgcompswordsfound);
		System.out.println("average comps words notfound= " + avgcompswordsnotfound);
		System.out.println("words found = " + wordsFound);
		System.out.println("words not found = " + wordsNotFound);
	}
	public void makeDict(){
		// container array of linkedList
		//dictCount = 0;
		//MyLinkedList[] dict = new MyLinkedList[26];
		// initilizing each element with new empty MyLinkedList
		for(int i = 0 ; i < dict.length; i++)
			dict[i] = new MyLinkedList<String>(); 
		//reading, placing word according to ascII
		try{	
			File f = new File("random_dictionary.txt");
			Scanner scan = new Scanner(f);
			//int dictCount = 0;
			while (scan.hasNext())
			{	
			String word = scan.nextLine();
			String Lword = word.toLowerCase();
			//System.out.println(Lword);
			dict[Lword.charAt(0) - 97].add(Lword);
			dictCount ++;
			}	
			scan.close();
		}
		catch(IOException e)
		{
			System.out.println("Unable to read file");
		}
		System.out.println("There were " + dictCount + " words added to dictionary MyLinkedList");
	}	
//............................................................................................		
	/**
	isChar method
	split method
	replace all
	trim method
	regex - regualr expressions learn them......patter class
	//[^....]  matches not in
	//[.....] matches in
	//You need 4 counters 1) wordsFound, 2)wordsNotFound, 3)compsFound, 4)compsNotFound 
	//( don't forget to initialize them to 0 since these are sums, and they should be long type).
	*/
		
	public void parseString()
	{		
		
		try{	
				File f = new File("oliver.txt");
				Scanner scan = new Scanner(f);
				String word = "";
				while(scan.hasNext())
				{
					/**read in next line trim spaces before and after.....converts to lowercase.....
					replaces all undesiaables with spaces.....then splits on spaces
					*/
					String[] array = scan.nextLine().trim().toLowerCase().replaceAll("[^A-Za-z]", " ").split("\\s+");	
				   
					for(int i = 0; i < array.length; i++)
					{
						if(!array[i].isEmpty())
							{
								int find = array[i].charAt(0) - 97;
								if (dict[find].contains(array[i]))
								{
									compFound += dict[find].indexOf(array[i]) +1;
									wordsFound++;
								}
								else
								{
									wordsNotFound++;
									compNotFound += dict[find].size();
								}
							}		
					}
				
			}
			scan.close();
		}
		catch(IOException r)
		{
			System.out.println("Unable to read file");
		}
		
	
	}
}	
		

		
		
		
	
