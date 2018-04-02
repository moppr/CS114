package b;

public class StringTreeRunner {

	public static void main(String[] args) {
		StringTree a = new StringTree();
		a.readData();
		System.out.println("Recursion: ");
		a.traverseWithRecursion();
		System.out.println("\nStack: ");
		a.traverseWithStack(); //hello
	}

}
