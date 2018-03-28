package b;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTester{

	public static void main(String[] args){
		
		ArrayList<StaffMember> a = new ArrayList<StaffMember>(); //arraylist to use
		
		Staff staff = new Staff();
		for (int i = 0; i < staff.getSize(); i++) {
			a.add(staff.getStaff(i)); //transfer contents of staff file to arraylist
		}
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		while (!input.equals("display") && !input.equals("delete") && !input.equals("modify")) {
			System.out.println("What would you like to do, display, delete or modify? "); 
			input = scan.nextLine().toLowerCase(); //repeatedly ask for input until something valid given
		}
		
		System.out.println("Enter an employee to work with: "); //prompt any name
		String employeeName = scan.nextLine().toLowerCase();
		
		boolean invalid = true; //checks later on if staff member actually exists
		
		if (input.equals("display")) {
			for (StaffMember sm : a)
				if (sm.name.toLowerCase().equals(employeeName)) { //if someone from the list has a name matching the input name
					System.out.println(sm);
					System.out.println("Employee Type: " + sm.getClass()); //display basic details + employee type & pay
					System.out.println("Pay: " + sm.pay() + "\n");
					invalid = false; //set a flag to note that the employee was successfully found and therefore exists
				}
		}
		else if (input.equals("delete")){
			for (int i = a.size()-1; i >= 0; i--) { //have to use normal for loop and go backwards when removing elements
				StaffMember sm = a.get(i);			
				if (sm.name.toLowerCase().equals(employeeName)) {
					a.remove(i); //similar idea, but removing
					invalid = false;
				}
			}
		}
		else { //modify address
			for (StaffMember sm : a)
				if (sm.name.toLowerCase().equals(employeeName)) {
					System.out.println("Enter a new address for staff member: ");
					sm.address = scan.nextLine(); //similar idea, but changing the address
					invalid = false;
				}
		}
		
		if (invalid) System.out.println("Error: Member not found\n"); //only prints error if failed to detect existing user
		
		
		System.out.println("UPDATED EMPLOYEE LIST\n");
		for (StaffMember sm : a) {
			System.out.println(sm + "\n"); //print new contents of list
		}

	}

}
