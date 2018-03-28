package a;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		BST<String, InventoryItem> a = new BST<String, InventoryItem>();
		a.readData();
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("Choose Action: Retrieve, Delete, Search Range, View, or Exit: ");
			String input = scan.nextLine().toLowerCase();
			
			if(input.equals("exit"))
				break;
				
			switch(input){
				case "retrieve":
					System.out.print("Key to retrieve: ");
					input = scan.nextLine();
					InventoryItem found = a.find(input);
					if(found != null)
						System.out.println(found);
					else
						System.out.println("Key not found");
					break;
					
				case "delete":
					System.out.print("Key to delete: ");
					input = scan.nextLine();
					InventoryItem removed = a.remove(input);
					if(removed != null)
						System.out.println("Removed\n" + removed);
					else
						System.out.println("Key not found");
					break;

				case "search range":
					System.out.print("First Key: ");
					String k1 = scan.nextLine();
					System.out.print("Second Key: ");
					String k2 = scan.nextLine();
					System.out.println(a.rangeSearch(k1, k2));
					break;
				
				case "view":
					System.out.println(a);
					break;
				
				default:
					break;
			}			
		}
	
		scan.close();
		
		System.out.println("\n---INORDER---");
		System.out.println("\n" + a);
		System.out.println("\n|---POSTORDER---");
		System.out.println("\n" + a.printPostOrder());
		System.out.println("\n|---PREORDER---");
		System.out.println("\n" + a.printPreOrder());		
	}
}
