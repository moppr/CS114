package a;

public class Progression{

	public int first;
	public int cur;

	public Progression(int first, int cur){
		this.first = first;
		this.cur = cur;
	}

	public int firstValue(){
		cur = first; //set current value to initial value and return that
		return first;
	}

	public int nextValue(){
		return cur++; //increment arithmetically by 1, as a default
	}

	public void printProgression(int n){
		cur = first; //reset progression
		String result = "";
		for (int i = 0; i < n; i++){ 
			result += String.valueOf(cur) + " ";
			nextValue(); //note down the current value and run nextValue() n times to get the first n numbers
		}
		
		System.out.println(result);
	}

}
