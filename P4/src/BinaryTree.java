///////////////////////////////////////////////////////////////////////////////
//Main Class File:  GuessingGame.java
//File:             BinaryTree.java
//Semester:         CS367 Fall 2014
//
//Author:           Songzi Wen swen9@wisc.edu
//CS Login:         songzi
//Lecturer's Name:  Jim Skrentny
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//Pair Partner:     Xiaojian Nie nie5@wisc.edu
//CS Login:         xiaojian
//Lecturer's Name:  Jim Skrentny
////////////////////////////80 columns wide //////////////////////////////////

/**
 * Create a binary tree data structure 
 *
 * <p>Bugs: unknown
 *
 * @author Songzi Wen
 * @author Xiaojian Nie
 */
public class BinaryTree<E> {

	private BinaryTreenode<E> root;
	private BinaryTreenode<E> current;// a reference for use navigating the tree

	/**
	 * Constructs an empty BinaryTree with a null root.
	 */
	public BinaryTree() {
		this.root = new BinaryTreenode();
		this.current = null;
	}

	/**
	 * Constructs a BinaryTree with data stored in its root.
	 *
	 * @param data
	 *            information need to add in root node
	 */
	public BinaryTree(E data) {
		this.root = new BinaryTreenode(data);
		this.current = null;
	}

	/**
	 * Starts the current reference at the root of the tree to begin navigation
	 * of the tree.
	 */
	public void start() {
		this.current = this.root;
	}

	/**
	 * Returns the data stored in the current node in navigation. Throws an
	 * IllegalBinaryTreeOpException if there is no current node in navigation.
	 * 
	 * 
	 * @return Returns the data stored in the current node in navigation.
	 * @throws IllegalBinaryTreeOpException
	 *             if current node is null
	 * 
	 */
	public E getCurrent() throws IllegalBinaryTreeOpException {

		if (this.current.getData() == null) {
			throw new IllegalBinaryTreeOpException(
					"Cannot get current; current node is null");
		} else {
			return this.current.getData();
		}

	}

	/**
	 * Moves the current reference to the left child of the current node in
	 * navigation. Throws an IllegalBinaryTreeOpException if the current node
	 * does not have a left child.
	 *
	 * @throws IllegalBinaryTreeOpException
	 *             if current node's left child is null
	 */
	public void goLeft() throws IllegalBinaryTreeOpException {

		if (this.current.getLeft() == null) {
			throw new IllegalBinaryTreeOpException(
					"Cannot go left; there is no left child of this node");
		} else {
			this.current = this.current.getLeft();
		}
	}

	/**
	 * Moves the current reference to the right child of the current node in
	 * navigation. Throws an IllegalBinaryTreeOpException if the current node
	 * does not have a right child.
	 *
	 * @throws IllegalBinaryTreeOpException
	 *             if current node's right child is null
	 */
	public void goRight() throws IllegalBinaryTreeOpException {
		if (this.current.getRight() == null) {
			throw new IllegalBinaryTreeOpException(
					"Cannot go right; there is no right child of this node");
		} else {
			this.current = this.current.getRight();
		}

	}

	/**
	 * Returns true if the current node in navigation is a leaf .
	 *
	 * @return true if the current node is a leaf
	 * @return false if the current node is not a leaf
	 */
	public boolean isLeaf() {

		if (this.current.getLeft() == null && this.current.getRight() == null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Changes the data held by the current node in navigation to the specified
	 * data.
	 *
	 * @param data
	 *            the data need to be stored in current node
	 */
	public void changeCurrent(E data) {
		this.current.setData(data);
	}

	/**
	 * Adds a node with the specified child as the right child of the current
	 * node in navigation. Throws an IllegalBinaryTreeOpException if the current
	 * node already has a right child.
	 *
	 * @param data
	 *            the data need to be stored in right child
	 * @throws IllegalBinaryTreeOpException
	 *             if current node's right child is already exist
	 */
	public void addRightChild(E data) throws IllegalBinaryTreeOpException {
		if (this.current.getRight() != null) {
			throw new IllegalBinaryTreeOpException(
		"Cannot add right child; there is already a right child of this node");
		} else {
			this.current.setRight(data);
		}
	}

	/**
	 * Adds a node with the specified child as the left child of the current
	 * node in navigation. Throws an IllegalBinaryTreeOpException if the current
	 * node already has a left child.
	 *
	 * @param data
	 *            the data need to be stored in left child
	 * @throws IllegalBinaryTreeOpException
	 *             if current node's left child is already exist
	 */
	public void addLeftChild(E data) throws IllegalBinaryTreeOpException {
		if (this.current.getLeft() != null) {
			throw new IllegalBinaryTreeOpException(
		"Cannot add left child; there is already a left child of this node");
		} else {
			this.current.setLeft(data);
		}
	}

	/**
	 * Pre-order prints the tree, starting at the root.
	 */
	public void print() {
		//handle when the binary tree's root is null
		if (this.root.getData() == null) {
			System.out.println("Empty Tree");
		} 
		//call helper method when binary tree's root is not null
		else {
			print(this.root, 0);
			System.out.println();
		}
	}

	/**
	 * Print-Helper method
	 * 
	 * @param myNode
	 *            the root node of the tree or subtree
	 * @param startLevel
	 *            the height of myNode in original binary tree
	 */
	private void print(BinaryTreenode<E> myNode, int startLevel) {
        //first base case
		if (myNode == null) {
			return;
		}
		//second base case, when there are no children for the node
		if (myNode.getLeft() == null && myNode.getRight() == null) {
			System.out.print(myNode.getData());
			return;
		}
		//handle when node's left child is not null but right child is null
		if (myNode.getLeft() != null && myNode.getRight() == null) {
			System.out.print(myNode.getData());
			startLevel++;
			System.out.print("\n");
			//print space
			for (int i = 0; i < startLevel; i++) {
				System.out.print("   ");
			}
			//recursion call
			print(myNode.getLeft(), startLevel);
		}
		//handle when node's right child is not null but left child is null
		if (this.root.getLeft() == null && this.root.getRight() != null) {
			System.out.print(myNode.getData());
			startLevel++;
			System.out.print("\n");
			//print space
			for (int i = 0; i < startLevel; i++) {
				System.out.print("   ");
			}
			//recursion call
			print(myNode.getRight(), startLevel);
		}
		//handle when node's left and right child are not null
		if (this.root.getLeft() != null && this.root.getRight() != null) {
			System.out.print(myNode.getData());
			startLevel++;
			System.out.print("\n");
			//print space
			for (int i = 0; i < startLevel; i++) {
				System.out.print("   ");
			}
			//recursion call
			print(myNode.getLeft(), startLevel);
			System.out.print("\n");
			//print space
			for (int i = 0; i < startLevel; i++) {
				System.out.print("   ");
			}
			//recursion call 
			print(myNode.getRight(), startLevel);
		}
	}
	

}
