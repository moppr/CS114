package a;

public class AListGrow<E>extends AList<E>{

	public AListGrow(int size){
		super();
	}

	public void append(E it){
		if (listSize >= maxSize)
			grow();
		listArray[listSize++] = it;
	}

	public void insert(E it){
		if (listSize >= maxSize)
			grow();
		for (int i = listSize; i > curr; i--) // Shift elements up
			listArray[i] = listArray[i - 1]; // to make room
		listArray[curr] = it;
		listSize++; // Increment list size
	}

	public void grow(){
		maxSize *= 2; //allows for future growths
		E[] listArrayBig = (E[])new Object[maxSize]; //create new array with double length
		for (int i = 0; i < listArray.length; i++) { //copy over old elements
			listArrayBig[i] = listArray[i];
		}
		listArray = listArrayBig; //set old list to new
	}

}
