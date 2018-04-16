package a;

import java.io.*;
import java.util.*;

public class IteratorRunner{

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		LinkedList<Course> list = new LinkedList<Course>();
		readData(list);

		Iterator<Course> iter = list.iterator();

		System.out.println("Before Removing:"); //print all
		while (iter.hasNext()){
			System.out.println(iter.next());
		}

		System.out.println();
		iter = list.iterator();

		while (iter.hasNext()){
			if (!iter.next().taken()){
				iter.remove();
			}
		}

		iter = list.iterator();

		System.out.println("After Removing:");
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public static void readData(LinkedList<Course> aList) throws NumberFormatException, IOException{
		String line;
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 11\\a\\CourseForProgram.txt"));

		while ((line = br.readLine()) != null){

			String[] colon = line.split(": ");
			String[] classLevel = colon[0].split(" "); //class & level
			String[] descGrade = colon[1].split("  "); //description & grade

			Course temp;
			if (descGrade.length > 1){ //if a grade is present
				aList.add(new Course(classLevel[0], Integer.parseInt(classLevel[1]), descGrade[0], descGrade[1]));
			}
			else{
				aList.add(new Course(classLevel[0], Integer.parseInt(classLevel[1]), descGrade[0], null));
			}
		}
	}
}
