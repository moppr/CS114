package b;

public class SportsAnnouncer implements Speaker{

	public SportsAnnouncer(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public void speak(){
		System.out.println("Goal!");
	}

	@Override
	public void announce(String team){
		System.out.println("The " + team + " have scored a goal!");
	}

}
