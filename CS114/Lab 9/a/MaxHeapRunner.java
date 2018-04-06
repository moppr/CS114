package a;

import java.io.*;

public class MaxHeapRunner{

	public static final int size = 9;

	public static void main(String[] args) throws IOException{
		String[] inventory = new String[size];
		populate(inventory);

		MaxHeap<String> heap = new MaxHeap<String>(inventory, size, size);
		int currSize = heap.heapsize();

		System.out.println("Initial, size " + currSize);
		for (int i = 0; i < currSize; i++){
			System.out.println(i + ": " + heap.removemax()); //initial list
		}

		System.out.println();
		heap = new MaxHeap<String>(inventory, size, size); //kevin is cute tbh
		heap.removemax();
		currSize = heap.heapsize();

		System.out.println("Max Removed, size " + currSize);
		for (int i = 0; i < currSize; i++){
			System.out.println(i + ": " + heap.removemax()); //remove max, spit it out
		}

	}
	
	public static void populate(String[] stringArr) throws IOException{
		String line;
		BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 9\\a\\inventory.txt"));
		int count = 0;
		
		while ((line = in.readLine()) != null){
			stringArr[count] = line;
			count++;
		}
	}

}
