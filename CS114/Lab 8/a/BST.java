package a;

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Comparable;
import java.util.LinkedList;
import java.util.Queue;

/** Binary Search Tree implementation for Dictionary ADT */
class BST<Key extends Comparable<? super Key>, E> implements Dictionary<Key, E>{
	private BSTNode<Key, E> root; // Root of the BST
	int nodecount; // Number of nodes in the BST
	private StringBuffer output;

	/** Constructor */
	BST(){
		root = null;
		nodecount = 0;
	}

	/** Reinitialize tree */
	public void clear(){
		root = null;
		nodecount = 0;
	}

	/**
	 * Insert a record into the tree.
	 * 
	 * @param k
	 *            Key value of the record.
	 * @param e
	 *            The record to insert.
	 */
	public void insert(Key k, E e){
		root = inserthelp(root, k, e);
		nodecount++;
	}

	/**
	 * @return The current subtree, modified to contain the new item
	 */
	private BSTNode<Key, E> inserthelp(BSTNode<Key, E> rt, Key k, E e){
		if (rt == null)
			return new BSTNode<Key, E>(k, e);
		if (rt.key().compareTo(k) > 0)
			rt.setLeft(inserthelp(rt.left(), k, e));
		else
			rt.setRight(inserthelp(rt.right(), k, e));
		return rt;
	}

	// Return root
	public BSTNode<Key, E> getRoot(){
		return root;
	}

	/**
	 * Remove a record from the tree.
	 * 
	 * @param k
	 *            Key value of record to remove.
	 * @return The record removed, null if there is none.
	 */
	public E remove(Key k){
		E temp = findhelp(root, k); // First find it
		if (temp != null){
			root = removehelp(root, k); // Now remove it
			nodecount--;
		}
		return temp;
	}

	/**
	 * Remove a node with key value k
	 * 
	 * @return The tree with the node removed
	 */
	private BSTNode<Key, E> removehelp(BSTNode<Key, E> rt, Key k){
		if (rt == null)
			return null;
		if (rt.key().compareTo(k) > 0)
			rt.setLeft(removehelp(rt.left(), k));
		else if (rt.key().compareTo(k) < 0)
			rt.setRight(removehelp(rt.right(), k));
		else{ // Found it
			if (rt.left() == null)
				return rt.right();
			else if (rt.right() == null)
				return rt.left();
			else{ // Two children
				BSTNode<Key, E> temp = getmin(rt.right());
				rt.setElement(temp.element());
				rt.setKey(temp.key());
				rt.setRight(deletemin(rt.right()));
			}
		}
		return rt;
	}

	private BSTNode<Key, E> getmin(BSTNode<Key, E> rt){
		if (rt.left() == null)
			return rt;
		return getmin(rt.left());
	}

	private BSTNode<Key, E> deletemin(BSTNode<Key, E> rt){
		if (rt.left() == null)
			return rt.right();
		rt.setLeft(deletemin(rt.left()));
		return rt;
	}

	/**
	 * Remove and return the root node from the dictionary.
	 * 
	 * @return The record removed, null if tree is empty.
	 */
	public E removeAny(){
		if (root == null)
			return null;
		E temp = root.element();
		root = removehelp(root, root.key());
		nodecount--;
		return temp;
	}

	/**
	 * @return Record with key value k, null if none exist.
	 * @param k
	 *            The key value to find.
	 */
	public E find(Key k){
		return findhelp(root, k);
	}

	/** @return The number of records in the dictionary. */
	public int size(){
		return nodecount;
	}

	private E findhelp(BSTNode<Key, E> rt, Key k){
		if (rt == null)	return null;
		
		if (rt.key().compareTo(k) > 0)
			return findhelp(rt.left(), k);
		else if (rt.key().compareTo(k) == 0)
			return rt.element();
		else
			return findhelp(rt.right(), k);
	}

	private void printhelp(BSTNode<Key, E> rt){
		if (rt == null)	return;
		
		printhelp(rt.left());
		printVisit(rt.element());
		printhelp(rt.right());
	}

	public String toString(){
		output = new StringBuffer(400);
		printhelp(root);
		return output.toString();
	}

	private void printVisit(E it){
		output.append(it + "\n");
	}

	private void postOrder(BSTNode<Key, E> rt){
		if (rt == null)	return;
		//postorder: Left, Right, Node
		postOrder(rt.left());
		postOrder(rt.right());
		printVisit(rt.element());
	}

	public String printPostOrder(){
		output = new StringBuffer(400);
		postOrder(root);
		return output.toString();
	}

	private void preOrder(BSTNode<Key, E> rt){
		if (rt == null)	return;
		
		//preorder: Node, Left, Right
		printVisit(rt.element());
		preOrder(rt.left());
		preOrder(rt.right());
	}

	public String printPreOrder(){
		output = new StringBuffer(400);
		preOrder(root);
		return output.toString();
	}

	public String rangeSearch(Key k1, Key k2){
		output = new StringBuffer(400);
		if (k1.compareTo(k2) > 0){
			Key temp = k1;
			k1 = k2;
			k2 = temp;
		}

		range(root, k1, k2);
		return output.toString();
	}

	private void range(BSTNode<Key, E> rt, Key k1, Key k2){
		if (rt == null)	return;

		//go left when search key is smaller than node
		if (rt.key().compareTo(k1) > 0){
			range(rt.left(), k1, k2);
		}
		//found
		if (rt.key().compareTo(k1) >= 0 && rt.key().compareTo(k2) <= 0){
			printVisit(rt.element());
		}
		//go right if search key is larger
		if (rt.key().compareTo(k2) < 0){
			range(rt.right(), k1, k2);
		}
	}

	public void readData(){
		String line;
		try{
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 8\\a\\inventory.txt"));

			while ((line = br.readLine()) != null){
				Queue<String> inputQueue = new LinkedList<String>();

				while (line.indexOf(",") != -1){
					inputQueue.offer(line.substring(0, line.indexOf(",")));
					line = line.substring(line.indexOf(",") + 1);
				}

				String partNumber = inputQueue.poll();
				String model = inputQueue.poll();
				String part = inputQueue.poll();
				double cost = Double.parseDouble(line);

				insert((Key) partNumber, (E) new InventoryItem(partNumber, model, part, cost));

			}

			br.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
