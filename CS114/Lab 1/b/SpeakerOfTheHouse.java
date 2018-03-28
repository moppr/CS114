package b;

public class SpeakerOfTheHouse implements Speaker{

	public SpeakerOfTheHouse(){
		
	}

	@Override
	public void speak(){
		System.out.println("I am the speaker of the house");
	}

	@Override
	public void announce(String bill){
		System.out.println("The " + bill + " has passed!");
	}

}
