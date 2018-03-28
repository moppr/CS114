package b;

import java.util.*;

public class BankSim{
	
	static int currentID = 0;
	static Line line = new Line();

	public static void main(String[] args){
		
		for (int i = 1; i <= 10; i++){ //throw 10 cycles of customers in for simulation
			//System.out.println("WAVE " + i); //testing
			simulate((int)(Math.random()*5+1), (int)(Math.random()*4+1)); //1-5 customers and 1-4 tellers
		}
		
		//System.out.println("No more customers entering after this point. " + line.size() + " customers remain"); //testing
		
		if (!line.isEmpty()){ //accounts for customers still waiting in line after all waves of new customers finishes
			int customersLeft = line.size();
			for (int i = 0; i < customersLeft; i++){
				System.out.println(line.nextCustomer().toString() + " is being served");
			}			
		}
		
		System.out.println("All customers served (" + line.size() + " in line). Bank close. Bye");

	}
	
	public static void simulate(int numCustomers, int numTellers){
		
		for (int i = 0; i < numCustomers; i++){ //increment ID and add to line for each new customer in this wave
			currentID++;
			line.addCustomer(new Customer(currentID));
			System.out.println("Customer " + currentID + " joins the line. There are " + line.size() + " customers waiting");
		}
		
		for (int i = 0; i < numTellers; i++){ //remove from line for each teller available in this wave; empty line = teller waiting message
			if (line.isEmpty()){
				System.out.println("Teller waiting");
			}
			else{
				System.out.println(line.nextCustomer().toString() + " is being served");
			}
		}		
		
	}

}
