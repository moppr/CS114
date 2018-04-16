package a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;


public class IteratorDriver {
	
	public static void readData(LinkedList<Course> aList) { //Reads Data from input file
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 11\\a\\CourseForProgram.txt"));
			
			while ((line = in.readLine()) != null) {
				//example line: CS 101: Introduction to Programming  [A-]
				
				String[] colon = line.split(": "); 
				//colon[0] = "CS 101", colon[1] = "Introduction to Programming  [A-]"
				
				String[] CN = colon[0].split(" "); 
				//CN[0] = "CS", CN[1] = "101"
				
				String[] info = colon[1].split("  "); 
				//info[0] = "Introduction to Programming", info[1] = "[A-]"
				
				
				Course temp;
				if(info.length == 2) { //checks if grade exists
					temp = new Course(CN[0], Integer.parseInt(CN[1]), info[0], info[1]);
				}
				else {
					temp = new Course(CN[0], Integer.parseInt(CN[1]), info[0]);
				}
				System.out.println("Adding - " + temp);
				aList.add(temp);
				
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Course> aList = new LinkedList<Course>();
		readData(aList);
		
		Iterator<Course> anIter = aList.iterator(); 
		
		System.out.println("\nInitial Iterator :");
		while(anIter.hasNext()) {
			System.out.println(anIter.next());
		}
		
		System.out.println();
		
		anIter = aList.iterator(); //reset iterator
		
		while(anIter.hasNext()) {
		    Course temp = anIter.next();
		    if (!temp.taken()) {
		    	System.out.println("Deleting - " + temp);
		        anIter.remove();
		    }
		}
		
		
		anIter = aList.iterator(); //reset iterator
		
		System.out.println("\nUpdated Iterator :");
		while(anIter.hasNext()) {
			System.out.println(anIter.next());
		}
	}

}
