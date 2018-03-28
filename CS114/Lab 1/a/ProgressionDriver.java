package a;

public class ProgressionDriver{

	public static void main(String[] args){
		
		ArithProgression ap = new ArithProgression(0, 0); //initial vals of 0
		GeomProgression gp = new GeomProgression(1, 1); //initial vals of 1
		
		ap.printProgression(10); //first 10 by 1
		ap.setinc(5);
		
		//Instructions were unclear here
		//They ask to set increment to 5 using constructor,
		//however constructor was only ever asked to set the default
		//Were we supposed to overload the constructor, or is using setinc again fine?
		
		ap.printProgression(10); //first 10 by 5
		ap.setinc(10);
		ap.printProgression(10); //etc
		
		gp.printProgression(10); //first 10 by 2
		gp.setbase(3);
		gp.printProgression(10); //etc
		gp.setbase(5);
		gp.printProgression(10);

	}

}
