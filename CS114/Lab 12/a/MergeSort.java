package a;

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

// Sorting main function for testing correctness of sort algorithm.
// To use: <sortname> [+/-] <size_of_array> <threshold>
//  + means increasing values, - means decreasing value and no
//    parameter means random values;
// where <size_of_array> controls the number of objects to be sorted;
// and <threshold> controls the threshold parameter for certain sorts, e.g.,
//   cutoff point for quicksort sublists.



public class MergeSort {

	static int THRESHOLD = 0;

	static int ARRAYSIZE = 0;

	@SuppressWarnings("unchecked") // Generic array allocation
	public
	static <E extends Comparable<? super E>> void Sort(E[] A) {
		E[] temp = (E[]) new Comparable[A.length];
		mergesort(A, temp, 0, A.length - 1);
	}

	static <E extends Comparable<? super E>> void mergesort(E[] A, E[] temp, int l, int r) {
		int mid = (l + r) / 2; // Select midpoint
		if (l == r)
			return; // List has one element
		mergesort(A, temp, l, mid); // Mergesort first half
		mergesort(A, temp, mid + 1, r); // Mergesort second half
		for (int i = l; i <= r; i++) // Copy subarray to temp
			temp[i] = A[i];
		// Do the merge operation back to A
		int i1 = l;
		int i2 = mid + 1;
		for (int curr = l; curr <= r; curr++) {
			if (i1 == mid + 1) // Left sublist exhausted
				A[curr] = temp[i2++];
			else if (i2 > r) // Right sublist exhausted
				A[curr] = temp[i1++];
			else if (temp[i1].compareTo(temp[i2]) < 0) // Get smaller
				A[curr] = temp[i1++];
			else
				A[curr] = temp[i2++];
		}
	}

}
