package c;

import java.io.*;
import java.util.*;

public class InventoryRunner{

	public static final int size = 10;

	public static void main(String[] args) throws NumberFormatException, IOException{
		PriorityQueue<Inventory> inventory = new PriorityQueue<Inventory>(size);
		readData(inventory);

		System.out.println("Creating PQueue");
		for (Inventory i : inventory){
			System.out.println(i);
		}

		System.out.println();
		System.out.println("Ordered PQueue");
		while (!inventory.isEmpty()){
			System.out.println(inventory.poll());
		}
	}
	
	public static void readData(PriorityQueue<Inventory> inventory) throws NumberFormatException, IOException{
		
		String line;
		BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 9\\c\\inventoryNew.txt"));

		while ((line = in.readLine()) != null){
			Queue<String> queue = new LinkedList<String>();

			while (line.indexOf(",") != -1){
				queue.offer( line.substring(0, line.indexOf(",")) );
				line = line.substring(line.indexOf(",") + 1);
			}
			
			String partNum = queue.poll();
			String model = queue.poll();
			String part = queue.poll();
			double cost = Double.parseDouble(line);
			
			inventory.offer(new Inventory(partNum, model, part, cost));
		}		
	}	
}
