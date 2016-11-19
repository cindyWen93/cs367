///////////////////////////////////////////////////////////////////////////////
//Main Class File:  GuessingGame.java
//File:             IllegalBinaryTreeOpExceptionjava
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
 * Create an IllegalBinaryTreeOpException to handle exception situation for 
 * BinaryTree class
 *
 * <p>Bugs: unknown
 *
 * @author Songzi Wen
 * @author Xiaojian Nie
 */
class IllegalBinaryTreeOpException extends Exception{

	/**
	 * Constructs an IllgealBinaryTreeOpException with specific error message
	 * 
	 * @param msg 
	 *        a message that corresponds to a specific exception situation
	 */
	public  IllegalBinaryTreeOpException(String msg){
		super(msg);
	}
	
	
}
