package b;

import java.util.Scanner;

public class SpeakerDriver{

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		//bill, team, movie
		System.out.println("Enter a bill name: ");
		String bill = scan.nextLine();
		System.out.println("Enter a team name: ");
		String team = scan.nextLine();
		System.out.println("Enter a movie name: ");
		String movie = scan.nextLine();
		System.out.println("");
		
		SpeakerOfTheHouse soth = new SpeakerOfTheHouse();
		SportsAnnouncer sa = new SportsAnnouncer();
		Actor a = new Actor();
		
		soth.speak();
		sa.speak();
		a.speak();
		soth.announce(bill);
		sa.announce(team);
		a.announce(movie);

	}

}
