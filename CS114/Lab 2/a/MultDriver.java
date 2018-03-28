package a;

public class MultDriver{

	public static void main(String[] args){
		
		MultIntegers mi = new MultIntegers();
		int a = 87765, b = 12543; //pick two numbers
		long start1 = System.nanoTime(); //record the starting time
		System.out.println(a + " times " + b + " in a loop gives " + mi.multiplyLoop(a, b));
		long end1 = System.nanoTime(); //record end time and calculate difference
		System.out.println("Run time: " + (end1 - start1) + "n (" + (end1 - start1)/1000000 + " ms)");
		long start2 = System.nanoTime(); //repeat
		System.out.println(a + " times " + b + " with recursion gives " + mi.multiplyRecursive(a, b));
		long end2 = System.nanoTime();
		System.out.println("Run time: " + (end2 - start2) + "n (" + (end2 - start2)/1000000 + " ms)");

	}

}
