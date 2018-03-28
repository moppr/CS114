package a;

public class ArithProgression extends Progression{

	int inc;

	public ArithProgression(int first, int cur){
		super(first, cur);
		inc = 1;
	}

	public void setinc(int inc){
		this.inc = inc;
	}
	
	public int nextValue() {
		return cur += inc; //replace increment of 1 in superclass with increment of incs
	}

}
