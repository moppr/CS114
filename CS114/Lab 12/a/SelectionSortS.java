package a;


//********************************************************************
//  SelectionSortS.java       
//
//********************************************************************



public class SelectionSortS {
	private SortNode list;

	// -----------------------------------------------------------------
	// Creates an initially empty linked list.
	// -----------------------------------------------------------------
	public SelectionSortS() {
		list = null;
	}
	
	
	
	public SelectionSortS(String[] A) {
		for(String each : A) {
			add(each);
		}
	}

	// -----------------------------------------------------------------
	// Adds an integer to the linked list
	// -----------------------------------------------------------------
	public void add(String value) {
		SortNode node = new SortNode(value);
		SortNode current = null;

		if (list == null)
			list = node;
		else {
			current = list;
			while (current.next != null)
				current = current.next;
			current.next = node;
		}
	}

	// -----------------------------------------------------------------
	// Sorts the linked list using the selection sort.
	// -----------------------------------------------------------------
	public void sort() {
		SortNode current = list;
		SortNode min = list;
		SortNode swapPos = list;

		if (list == null)
			return;

		while (swapPos.next != null) {
			while (current.next != null) // find min value
			{
				current = current.next;
				if (current.value.compareTo(min.value) < 0)
					min = current;
			}

			// Swap the values
			if (min != swapPos) // a swap was found
			{
				String temp = min.value;
				min.value = swapPos.value;
				swapPos.value = temp;
			}
			swapPos = swapPos.next;
			current = swapPos;
			min = current;
		}
	}

	// -----------------------------------------------------------------
	// Returns a listing of the contents of the linked list.
	// -----------------------------------------------------------------
	public String toString() {
		String report = "";
		SortNode current = list;

		if (current != null) {
			report += String.valueOf(current.value) + " ";
			while (current.next != null) {
				current = current.next;
				report += String.valueOf(current.value) + " ";
			}
		}

		return report;
	}

	// *****************************************************************
	// An inner class that represents a node containing String.
	// The public variables are only visible in the outer class.
	// *****************************************************************
	private class SortNode {
		public String value;
		public SortNode next;

		// --------------------------------------------------------------
		// Sets up the node.
		// --------------------------------------------------------------
		public SortNode(String current) {
			value = current;
			next = null;
		}
	}
}
