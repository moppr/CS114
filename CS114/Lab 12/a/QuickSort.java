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



public class QuickSort {

	static int THRESHOLD = 0;

	static int ARRAYSIZE = 0;

	public static <E extends Comparable<? super E>> void Sort(E[] A) {
		qsort(A, 0, A.length - 1);
	}

	static int MAXSTACKSIZE = 1000;

	static <E extends Comparable<? super E>> void qsort(E[] A, int i, int j) { // Quicksort
		int pivotindex = findpivot(A, i, j); // Pick a pivot
		DSutil.swap(A, pivotindex, j); // Stick pivot at end
		// k will be the first position in the right subarray
		int k = partition(A, i - 1, j, A[j]);
		DSutil.swap(A, k, j); // Put pivot in place
		if ((k - i) > 1)
			qsort(A, i, k - 1); // Sort left partition
		if ((j - k) > 1)
			qsort(A, k + 1, j); // Sort right partition
	}

	static <E extends Comparable<? super E>> int partition(E[] A, int l, int r, E pivot) {
		do { // Move bounds inward until they meet
			while (A[++l].compareTo(pivot) < 0)
				;
			while ((r != 0) && (A[--r].compareTo(pivot) > 0))
				;
			DSutil.swap(A, l, r); // Swap out-of-place values
		} while (l < r); // Stop when they cross
		DSutil.swap(A, l, r); // Reverse last, wasted swap
		return l; // Return first position in right partition
	}

	static <E extends Comparable<? super E>> int findpivot(E[] A, int i, int j) {
		return (i + j) / 2;
	}

}
