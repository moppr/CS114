package c;

import java.util.Arrays;

public class RandArray{

	int[][] arr;

	public RandArray(){
		this.arr = new int[2][10]; //2x10 array
	}

	private int genNum(){
		return (int) (Math.random() * 901 + 100); //random int from 100 to 1000
	}

	private void populate(){
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++){
				arr[i][j] = genNum(); //fill array with random int
			}
		}
	}
	
	private void flipArr() {
		int[][] arr2 = new int[2][10];
		arr2[0] = arr[1];
		arr2[1] = arr[0]; //flip array rows by creating new array with flipped rows and setting old arr to new
		arr = arr2;
	}

	public void printArr(){
		populate();
		System.out.println(Arrays.deepToString(arr));
		
		flipArr();
		System.out.println(Arrays.deepToString(arr));
	}

}
