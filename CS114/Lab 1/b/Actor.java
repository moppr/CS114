package b;

public class Actor implements Speaker{

	public Actor(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public void speak(){
		System.out.println("I've been nominated for three Academy Awards.");
	}

	@Override
	public void announce(String movie){
		System.out.println("I'm currently starring in " + movie);
	}

}
