package b;

import java.util.Comparator;
import java.util.Scanner;

public class ObjectOrder{

	public static void main(String[] args){
		
		int a, b;
		
		Scanner scan = new Scanner(System.in);
		
		//this setup ensures input is nonnegative int
		int input = -1;
		while (!(input >= 0)){
			System.out.println("Enter first integer: ");
			try {
			input = Integer.parseInt(scan.nextLine());
			}
			catch(Exception E) {}
		}
		a = input;
		
		input = -1;
		while (!(input >= 0)){
			System.out.println("Enter second integer: ");
			try {
			input = Integer.parseInt(scan.nextLine());
			}
			catch(Exception E) {}
		}
		b = input;
		
		//send clean inputs to comparator
		CompareBinary c = new CompareBinary(a, b);
		//print comparator results
		System.out.println(c);
		
	}	

}
