package c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeSet;

public class ManageDicts{
	
	private static TreeSet<String> nameSet = new TreeSet<String>();
	private static Hashtable<String, StaffMember> members = new Hashtable<String, StaffMember>();

	public static void main(String[] args) throws FileNotFoundException{
		
		File f = new File("C:\\Users\\Matt\\Documents\\git-cs114\\CS114\\Lab 7\\c\\employee.txt");
		populateFromFile(f);

		Scanner scan = new Scanner(System.in);
		String input = "";
		
		while (!input.equals("exit")){
			System.out.println("Enter name, or 'exit' to quit: ");
			input = scan.nextLine().toLowerCase();
			
			if (!(input.equals("exit"))){
				if (nameSet.contains(input)){
					System.out.println(members.get(input));
				}
				else {
					System.out.println("Employee " + input + " not found");
				}
			}//hhhhh
		}
		
	}
	
	private static void populateFromFile(File f) throws FileNotFoundException{
		
		Scanner scan = new Scanner(f);
		
		while (scan.hasNextLine()){
			String line = scan.nextLine();
			
			if (line.length() > 0){
				String[] memberData = line.split(",");
				//Array order is Name, Address, Phone, SSN, Rate, same as StaffMember.java
				StaffMember member = new StaffMember(memberData[0], memberData[1], memberData[2], 
						memberData[3], Double.parseDouble(memberData[4]));
				nameSet.add(memberData[0].toLowerCase()); //add just name as key
				members.put(memberData[0].toLowerCase(), member);
			}
		}
		
	}

}
