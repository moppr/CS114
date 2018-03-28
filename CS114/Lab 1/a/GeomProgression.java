package a;

public class GeomProgression extends Progression{

	int base;

	public GeomProgression(int first, int cur){
		super(first, cur);
		base = 2;
	}

	public void setbase(int base){
		this.base = base;
	}

	public int nextValue(){
		return cur *= base; //replace increment of 1 in superclass with increment of *base
	}

}
