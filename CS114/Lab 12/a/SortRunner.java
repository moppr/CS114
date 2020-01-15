package a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class SortRunner{

	private static String[] fileContents;
	private static final double nanoMult = Math.pow(10, -9);

	public static void main(String[] args) throws IOException{
		
		fillData();
		insertion();
		selection(); //the document only asked for the other three but the output example had selection so ¯\_(:|)_/¯
		merge();	 //eclipse also got mad at me for trying to put the japanese character in that face so ¯\_(:|)_/¯
		quick();	 //whoops

	}

	private static void insertion(){
		System.out.println("Insertion Sort of " + fileContents.length + " items");
		long a = System.nanoTime();
		InsertionSort.Sort(fileContents, fileContents.length);
		long b = System.nanoTime();
		System.out.print("Time Elapsed: "); System.out.printf("%.9f", nanoMult*(b - a)); System.out.print(" seconds\n\n");
	}

	private static void merge(){
		System.out.println("Merge Sort of " + fileContents.length + " items");
		long a = System.nanoTime();
		MergeSort.Sort(fileContents);
		long b = System.nanoTime();
		System.out.print("Time Elapsed: "); System.out.printf("%.9f", nanoMult*(b - a)); System.out.print(" seconds\n\n");
	}

	private static void quick(){
		System.out.println("Quick Sort of " + fileContents.length + " items");
		long a = System.nanoTime();
		QuickSort.Sort(fileContents);
		long b = System.nanoTime();
		System.out.print("Time Elapsed: "); System.out.printf("%.9f", nanoMult*(b - a)); System.out.print(" seconds\n\n");
	}
	
	private static void selection(){
		System.out.println("Selection sort of " + fileContents.length + " items");
		long a = System.nanoTime();
		SelectionSortS sss = new SelectionSortS(fileContents);
		sss.sort();
		long b = System.nanoTime();
		System.out.print("Time Elapsed: "); System.out.printf("%.9f", nanoMult*(b - a)); System.out.print(" seconds\n\n");
	}

	public static void fillData() throws IOException{
		String line;
		LinkedList<String> list = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 12\\b\\inventory.txt"));

		while ((line = br.readLine()) != null){
			list.add(line);
		}

		fileContents = list.toArray(new String[list.size()]);
	}
}
