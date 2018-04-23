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



public class InsertionSort {

	static int THRESHOLD = 0;

	static int ARRAYSIZE = 0;

	public static <E extends Comparable<? super E>> void Sort(E[] A, int l) {
		for (int i = 1; i < l; i++) // Insert i'th record
			for (int j = i; (j > 0) && (A[j].compareTo(A[j - 1]) < 0); j--)
				DSutil.swap(A, j, j - 1);
	}

}
