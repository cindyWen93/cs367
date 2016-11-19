///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            p4
// Files:            GuessingGame.java BinaryTreenode.java 
//                   IllegealBinaryTreeOpException.java BinaryTreenoe.java
// Semester:         CS367 Fall 2014
//
// Author:           Songzi Wen
// Email:            swen9@wisc.edu
// CS Login:         songzi
// Lecturer's Name:  Jim Skrentny
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Pair Partner:     Xiaojian Nie
// Email:            nie5@wisc.edu
// CS Login:         xiaojian
// Lecturer's Name:  Jim Skrentny
// Lab Section:      (your partner's lab section number)
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Create a gaming guessing game based on 20Q
 * 
 * <p>
 * Bugs: unknown
 * 
 * @author Songzi Wen
 * @author Xiaojian Nie
 */
public class GuessingGame {

	/**
	 * This is the main method for this program
	 * 
	 * @param args
	 *            the input file name
	 */
	public static void main(String[] args) {
		// handle the case when program have command line input and the length
		// of it is one
		if (args.length == 1) {
			// get access to the input file
			File myFile = new File(args[0]);
			try {
				// import scanner
				Scanner in = new Scanner(myFile);
				// create a new tree
				BinaryTree<String> myTree = new BinaryTree<String>();
				// initialize the current pointer to the top of the tree
				myTree.start();

				// read the content of input file
				while (in.hasNextLine()) {
					System.out.println("Please enter a command (o, p, q, r):");
					// handle different cases
					String option = in.nextLine();

					// "quit" function
					if (option.equals("q")) {
						break; // jump out of the big while loop
					}
					// "reset" function
					if (option.equals("r")) {

						// reset the tree to a blank tree
						myTree = new BinaryTree<String>();
						// initialize the current pointer to the top of the tree
						myTree.start();
						System.out.println("Please enter a question.");
						// read the content from the input file and store into
						// the new tree
						myTree.changeCurrent(in.nextLine());

 System.out.println("Please enter something that is true for that question.");
						try {
							// add true answer into the left side of current
							// position
							myTree.addLeftChild(in.nextLine());
						}
						// catch exception
						catch (IllegalBinaryTreeOpException e) {
						}

System.out.println("Please enter something that is false for that question.");
						try {
							// add false answer into the right side of current
							// position
							myTree.addRightChild(in.nextLine());
						}
						// catch exception
						catch (IllegalBinaryTreeOpException e) {

						}

					}
					// "output" function
					if (option.equals("o")) {
						// print out the tree
						myTree.print();

					}
					// "play" function
					if (option.equals("p")) {
					// initialize the current pointer to the root of the tree
						myTree.start();
						//handle when the tree is empty
						try {
							if(myTree.getCurrent() == null){
				
							}
						} 
						catch (IllegalBinaryTreeOpException e1) {
							// create a new tree
							myTree = new BinaryTree<String>();
						// initialize the current pointer to the top of the tree
							myTree.start();
							System.out.println("Please enter a question.");
							// store the question into the root
							myTree.changeCurrent(in.nextLine());

System.out.println("Please enter something that is true for that question.");
							try {
								// add true answer into the left side of current
								// position
								myTree.addLeftChild(in.nextLine());
							}
							// catch exception
							catch (IllegalBinaryTreeOpException e) {

							}

System.out.println("Please enter something that is false for that question.");
							try {
							// add false answer into the right side of current
								// position
								myTree.addRightChild(in.nextLine());
							}
							// catch exception
							catch (IllegalBinaryTreeOpException e) {

							}
						
						}

						try {
							// create a boolean to track whether the program
							// continues
							boolean ifContinue = true;
							while (ifContinue) {

								System.out.println(myTree.getCurrent());// print
																		// out
																		// the
																		// root
																		// data

								String choice = in.nextLine();
								// when user's answer is yes
								if (choice.equals("y")) {
									// go to the left side
									myTree.goLeft();
									// when current position is a leaf
									if (myTree.isLeaf()) {
										// compare the guessing from user and
										// the result from database
										System.out.println("I guess: "
												+ myTree.getCurrent()
												+ ". Was I right?");

										String userInput = in.nextLine();
										// if the two results are different
										if (userInput.equals("n")) {
											// revise the current tree
											String temp = myTree.getCurrent();
			System.out.println("Darn. Ok, tell "
	+ "me a question that is true for your answer, but false for my guess.");
											myTree.changeCurrent(in.nextLine());
											myTree.addRightChild(temp);
				System.out.println("Thanks! And what were you thinking of?");
											myTree.addLeftChild(in.nextLine());
										}
										// if the two results are the same
										else if (userInput.equals("y")) {
											System.out.println("I win!");
										}
										ifContinue = false;
									}

								}

								// when use's answer is no
								else if (choice.equals("n")) {
									// go to the right side
									myTree.goRight();
									// when current position is a leaf
									if (myTree.isLeaf()) {
										// compare the guessing from user and
										// the result from database
										System.out.println("I guess: "
												+ myTree.getCurrent()
												+ ". Was I right?");

										String userInput = in.nextLine();
										// if the two results are different
										if (userInput.equals("n")) {
											// revise the current tree
											String temp = myTree.getCurrent();
				System.out.println("Darn. Ok, "
+ "tell me a question that is true for your answer, but false for my guess.");
											myTree.changeCurrent(in.nextLine());
											myTree.addRightChild(temp);
				System.out.println("Thanks! And what were you thinking of?");
											myTree.addLeftChild(in.nextLine());
										}
										// if the two results are the same
										else if (userInput.equals("y")) {
											System.out.println("I win!");
										}
										// after the revision, stop the loop
										ifContinue = false;
									}

								}

							}
						}
						// catch exception
						catch (IllegalBinaryTreeOpException e) {

						}

					}
				}

			}
			// catch exception
			catch (FileNotFoundException e) {

			}

		}
		// if there is no input file
		else if (args.length == 0) {
			// import scanner
			Scanner in = new Scanner(System.in);
			BinaryTree<String> myTree = new BinaryTree<String>();
			// initialize the current pointer to the top of the tree
			myTree.start();
			boolean inputContinue = true;
			while (inputContinue) {
				System.out.println("Please enter a command (o, p, q, r):");
				// handle different cases
				String option = in.nextLine();
				// "quit" function
				if (option.equals("q")) {
					break;// jump out of the big while loop
				}
				// "reset" function
				if (option.equals("r")) {
					// create a new tree
					myTree = new BinaryTree<String>();
					// initialize the current pointer to the top of the tree
					myTree.start();
					System.out.println("Please enter a question.");
					// store the question into the root
					myTree.changeCurrent(in.nextLine());

System.out.println("Please enter something that is true for that question.");
					try {
						// add true answer into the left side of current
						// position
						myTree.addLeftChild(in.nextLine());
					}
					// catch exception
					catch (IllegalBinaryTreeOpException e) {

					}

System.out.println("Please enter something that is false for that question.");
					try {
						// add false answer into the right side of current
						// position
						myTree.addRightChild(in.nextLine());
					}
					// catch exception
					catch (IllegalBinaryTreeOpException e) {

					}

				}
				// "output" function
				if (option.equals("o")) {
					// print out the tree
					myTree.print();

				}
				// "play" function
				if (option.equals("p")) {
					//System.out.println(option);
					// initialize the current pointer to the top of the tree
					myTree.start();
					//handle when the tree is empty
					try {
						if(myTree.getCurrent() == null){
			
						}
					} 
					catch (IllegalBinaryTreeOpException e1) {
						// create a new tree
						myTree = new BinaryTree<String>();
						// initialize the current pointer to the top of the tree
						myTree.start();
						System.out.println("Please enter a question.");
						// store the question into the root
						myTree.changeCurrent(in.nextLine());

System.out.println("Please enter something that is true for that question.");
						try {
							// add true answer into the left side of current
							// position
							myTree.addLeftChild(in.nextLine());
						}
						// catch exception
						catch (IllegalBinaryTreeOpException e) {

						}

System.out.println("Please enter something that is false for that question.");
						try {
							// add false answer into the right side of current
							// position
							myTree.addRightChild(in.nextLine());
						}
						// catch exception
						catch (IllegalBinaryTreeOpException e) {

						}
					
					}

					try {
						// create a boolean to track whether the program
						// continues
						boolean ifContinue = true;
						while (ifContinue) {

						System.out.println(myTree.getCurrent());// print out
																	// the root
																	// data

							String choice = in.nextLine();
							// when user's answer is yes
							if (choice.equals("y")) {
								// go to the left side
								myTree.goLeft();

								// when current position is a leaf
								if (myTree.isLeaf()) {
									// compare the guessing from user and the
									// result from database
									System.out.println("I guess: "
											+ myTree.getCurrent()
											+ ". Was I right?");

									String userInput = in.nextLine();

									// if the two results are different
									if (userInput.equals("n")) {
										String temp = myTree.getCurrent();
				System.out.println("Darn. Ok, tell me a question that is true "
								+ "for your answer, but false for my guess.");
										myTree.changeCurrent(in.nextLine());
										myTree.addRightChild(temp);
				System.out.println("Thanks! And what were you thinking of?");
										myTree.addLeftChild(in.nextLine());
									}
									// if the two results are same
									else if (userInput.equals("y")) {
										System.out.println("I win!");
									}
									// after the revision, stop the loop
									ifContinue = false;
								}

							}

							// when user's answer is no
							else if (choice.equals("n")) {
								// go to the right side
								myTree.goRight();
								// when current position is a leaf
								if (myTree.isLeaf()) {
									// compare the guessing from user and the
									// result from database
									System.out.println("I guess: "
											+ myTree.getCurrent()
											+ ". Was I right?");

									String userInput = in.nextLine();
									// if the two results are different
									if (userInput.equals("n")) {
										String temp = myTree.getCurrent();
			System.out.println("Darn. Ok, tell me a question that is true "
								+ "for your answer, but false for my guess.");
										myTree.changeCurrent(in.nextLine());
										myTree.addRightChild(temp);
				System.out.println("Thanks! And what were you thinking of?");
										myTree.addLeftChild(in.nextLine());
									}
									// if the two results are same
									else if (userInput.equals("y")) {
										System.out.println("I win!");
									}
									// after the revision, stop the loop
									ifContinue = false;
								}

							}

						}
					}
					// catch exception
					catch (IllegalBinaryTreeOpException e) {

					}

				}
			}

		}
		// invalid command line input
		else {
			System.out.println("Wrong command argument line input.");
		}

	}
}
