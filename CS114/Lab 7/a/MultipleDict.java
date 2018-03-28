package a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleDict{
	
	private static UALDictionary<String, StaffMember> SSNDict = new UALDictionary<String, StaffMember>();
	private static UALDictionary<String, StaffMember> NameDict = new UALDictionary<String, StaffMember>();
	private static ArrayList<StaffMember> members = new ArrayList<StaffMember>();

	public static void main(String[] args) throws FileNotFoundException{		
		
		//read inputs from file into dictionaries
		File f = new File("C:\\Users\\Matt\\Documents\\git-cs114\\CS114\\Lab 7\\a\\employee.txt");
		populateFromFile(f);
		
		//prompt user to enter
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		while (!input.equals("exit")){
			System.out.println("Which Key do you want to use: SSN, or Name? (ssn/name/exit)");
			input = scan.nextLine().toLowerCase();

			//cleanly re-prompts in event of unexpected input
			switch(input){
			case "ssn":
				System.out.println("What is your key? ");
				String ssn = scan.nextLine().toLowerCase();
				//looking for matching key, null if not found, gives StaffMember object if found
				StaffMember current = SSNDict.find(ssn);
				if (current != null){
					System.out.println(current); //spit out entire StaffMember toString if match
				}
				else{
					System.out.println("Employee with SSN " + ssn + " was not found");
				}
				break;
				
			case "name": //similar process
				System.out.println("What is your key? ");
				String name = scan.nextLine().toLowerCase();
				current = NameDict.find(name);
				if (current != null){
					System.out.println(current);
				}
				else{
					System.out.println("Employee with name " + name + " was not found");
				}
				break;
				
			default:
				break;
			}
			
		System.out.println();
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
				members.add(member);
			}
		}
		
		//too lazy to rewrite code that already works fine
		//for reference, this was originally done with the arraylist
		//until i realized that doing it that way never utilized dictionary
		for (StaffMember sm : members){
			SSNDict.insert(sm.ssn, sm);
			NameDict.insert(sm.name.toLowerCase(), sm);
			//dictionary will contain lowercase'd name but not original SM obj
		}
		
	}

}
