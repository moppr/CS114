package b;

import java.util.Comparator;

public class CompareBinary implements Comparator<Integer>{
	
	private int a;
	private int b;
	//stored variables a and b represent values of numbers (e.g. 14, 300)
	
	public CompareBinary(){
		
	}
	
	public CompareBinary(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int compare(Integer o1, Integer o2){
		//a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.	
		
		//first value to binary string, then counted 1s of binary string
		int aCount = countBinaryOnes(Integer.toBinaryString(o1));
		int bCount = countBinaryOnes(Integer.toBinaryString(o2));
		
		return aCount - bCount;
	}
	
	public String toString(){
		if (compare(a, b) < 0){
			return a + " (" + Integer.toBinaryString(a) + ") contains " + -1*compare(a, b) + " fewer 1's than " + 
					b + " (" + Integer.toBinaryString(b) + ")";
		}
		else if (compare(a, b) == 0){
			return a + " (" + Integer.toBinaryString(a) + ") and " + 
					b + " (" + Integer.toBinaryString(b) + ") contain the same number, " + compare(a, b) + ", of 1's";
		}
		else{
			return a + " (" + Integer.toBinaryString(a) + ") contains " + compare(a, b) + " more 1's than " + 
					b + " (" + Integer.toBinaryString(b) + ")";
		}
	}
	
	private int countBinaryOnes(String input){
		int count = 0;
		
		//break up an input string, count how many chars are 1s, no error detection needed
		for (char c : input.toCharArray()){
			if (c == '1') count++;
		}
		
		return count;
	}

}
