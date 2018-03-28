package a;

import java.io.*;
import java.util.*;

public class ScoreKeeper{

	static LList<GameEntry> list = new LList<GameEntry>();

	public static void main(String[] args){

		try{ // read and store input
			File gamescore = new File("C:\\Users\\Matt\\eclipse-workspace\\CS114\\Lab 4\\a\\gamescore.txt");
			Scanner fileScan = new Scanner(gamescore);

			while (fileScan.hasNextLine()){
				String nextline = fileScan.nextLine().toLowerCase();
				add(stringToEntry(nextline));
			}

		} catch (Exception E){
			E.printStackTrace();
		}

		System.out.println(list.toString());
		
		
		// ask for user input - add, remove, exit, print

		Scanner scan = new Scanner(System.in);
		System.out.println("Exit to exit, or any key to continue: ");
		String input = scan.nextLine().toLowerCase().trim();

		while (!input.equals("exit")){
			System.out.println("Add, remove, print, reverse or exit? ");
			input = scan.nextLine().toLowerCase().trim();

			if (input.equals("add")){
				System.out.println("Enter a user in the format of Name,Score: ");
				input = scan.nextLine().toLowerCase().trim();
				add(stringToEntry(input));
			}

			else if (input.equals("remove")){
				System.out.println("Enter name of user to remove: ");
				input = scan.nextLine().toLowerCase().trim();
				remove(input);
			}

			else if (input.equals("print")){
				System.out.println(list.toString());
			}
			
			else if (input.equals("reverse")) {
				list.reverseList();
			}

		}

	}

	private static GameEntry stringToEntry(String s){ // convert string of format Name,Score to GameEntry
		int comma = s.indexOf(',');
		String name = s.substring(0, comma);
		int score = Integer.parseInt(s.substring(comma + 1));

		return new GameEntry(name, score);
	}

	private static void add(GameEntry entry){
		list.moveToStart();
		boolean canAppend = true;
		for (int i = 0; i < list.length(); i++){
			if (list.getValue().getName().equals(entry.getName()))
				canAppend = false;
			list.next();
		}
		if (canAppend)
			list.append(entry);
		else
			System.out.println("Unable to add user that already exists (" + entry.getName() + ")");
	}

	private static void remove(String name){
		
		list.moveToStart();
		
		try {
			while (!list.getValue().getName().equals(name)){ // while list not yet at name
				list.next();
			}
		}
		catch(NullPointerException E) {
			//System.out.println("Unable to remove user that does not exist (" + name + ")");
		}

		if (list.currPos() == list.length() /*&& (!list.getValue().getName().equals(name))*/){
			System.out.println("Unable to remove user that does not exist (" + name + ")");
		} 
		else{
			list.remove();
			System.out.println(name + " successfully removed");
		}
	}

}
