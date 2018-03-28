package b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

//********************************************************************
//  StringTree.java       
//
//********************************************************************

public class StringTree{
	private Node root;

	// ----------------------------------------------------------------
	// Creates an initially empty tree.
	// ----------------------------------------------------------------
	public StringTree(){
		root = null;
	}

	// ----------------------------------------------------------------
	// Adds a string to the tree.
	// ----------------------------------------------------------------
	public void addString(String str){
		root = addStringToSubTree(str, root);
	}

	// ----------------------------------------------------------------
	// Adds a string to the subtree with the given root node
	// ----------------------------------------------------------------
	private Node addStringToSubTree(String str, Node node){
		Node result = node;
		if (node == null)
			result = new Node(str);

		// If the new string comes before the string in the node, add
		// the new string to the left child. Otherwise, add it to the
		// right child.
		else if (str.compareTo(node.value) < 0)
			node.left = addStringToSubTree(str, node.left);
		else
			node.right = addStringToSubTree(str, node.right);

		return result;
	}

	// ----------------------------------------------------------------
	// Prints the result of a depth-first traversal of the tree using
	// recursion.
	// ----------------------------------------------------------------
	public void traverseWithRecursion(){
		traverseWithRecursion(root);
		System.out.println();
	}

	// ----------------------------------------------------------------
	// Prints the elements in the specified tree using recursion.
	// ----------------------------------------------------------------
	private void traverseWithRecursion(Node node){
		if (node != null){
			traverseWithRecursion(node.left);

			System.out.print(node.value + " ");

			traverseWithRecursion(node.right);
		}
	}

	public void traverseWithStack(){
		traverseWithStack(root);
		System.out.println();
	}

	private void traverseWithStack(Node node){
		if (node != null){
			Stack<Node> treeStack = new Stack<Node>();
			Node curr = node;

			while (curr != null){
				treeStack.push(curr);
				curr = curr.left;
			}
			while (!treeStack.isEmpty()){
				curr = treeStack.pop();
				System.out.print(curr.value + " ");

				if (curr.right != null){
					curr = curr.right;
					while (curr != null){
						treeStack.push(curr);
						curr = curr.left;
					}
				}
			}
		}
	}

	public void readData(){
		String line;

		try{
			BufferedReader br = new BufferedReader(
					new FileReader(System.getProperty("user.dir") + "\\Lab 8\\b\\stringFile.txt"));

			while ((line = br.readLine()) != null){
				addString(line);
			}

			br.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}

// ********************************************************************
// Node for a binary tree of Strings.
// ********************************************************************
class Node{
	public String value;
	public Node left;
	public Node right;

	public Node(String value){
		this.value = value;
	}
}
