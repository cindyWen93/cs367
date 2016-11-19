///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P5
// Files:            MapBenchMark.java SimpleHashMap.java 
//					 SimpleTreeMap.java Entry.java SimpleMapADT.java
// Semester:         CS367 Fall 2014
//
// Author:           Songzi Wen
// Email:            swen9@wisc.edu
// CS Login:         songzi
// Lecturer's Name:  Jim Skrentny
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
// Pair Partner:     Xiaojian Nie
// Email:            nie5@wisc.edu
// CS Login:         xiaojian
// Lecturer's Name:  Jim Skrentny
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * This is the main class of the program which is having the function of 
 * generating a table showing the time costed by each method
 * 
 * <p>Bugs:unknown
 * 
 * @author Songzi Wen
 * @author Xiaojian Nie
 * 
 */
public class MapBenchmark {

	public static void main(String[] args) {
		// when there are 2 command lines
		if (args.length == 2) {

			int numIter; // number of iterations to run
			numIter = Integer.parseInt(args[1]);
			// initialize a list to store key and a list to store value
			ArrayList<Integer> keyList = new ArrayList<Integer>();
			ArrayList<String> valueList = new ArrayList<String>();
			try {
				// read the input file
				File myFile = new File(args[0]);
				Scanner scnr = new Scanner(myFile);
				while (scnr.hasNextLine()) {
					String myString = scnr.nextLine();
					// store each line into a array which contains two elements
					String[] temp = myString.split(" ");
					// add key to the keyList
					keyList.add(Integer.valueOf(temp[0]));
					// add value to the valueList
					valueList.add(temp[1]);
				}
				// close the scanner
				scnr.close();
				// catch the FileNotFoundException
			} catch (FileNotFoundException e) {
				System.out.println("Sorry, cannot open the file, "
						+ "please check your input file name.");
			}
			// create a list for storing the time
			ArrayList<long[]> resultList = new ArrayList<long[]>();
			// run #ndx times
			for (int ndx = 0; ndx < numIter; ndx++) {
				// create the hashmap
				SimpleHashMap myHashMap = new SimpleHashMap();
				// create the treemap
				SimpleTreeMap myTreeMap = new SimpleTreeMap();
				// create a array to store the time of each run
				long[] result = new long[8];

				// for time 1

				long totalTime1 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// put the key and the corresponding value in hashmap
					myHashMap.put(keyList.get(i), valueList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime1 += elapsed;
				}
				// store the time
				result[0] = totalTime1;

				// for time 2

				long totalTime2 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// put the key and the corresponding value in treemap
					myTreeMap.put(keyList.get(i), valueList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;

					totalTime2 += elapsed;

				}
				// store the time
				result[1] = totalTime2;

				// for time 3

				long totalTime3 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// get the key's corresponding value in hashmap
					myHashMap.get(keyList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime3 += elapsed;
				}
				// store the time
				result[2] = totalTime3;

				// for time 4

				long totalTime4 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// get the key's corresponding value in treemap
					myTreeMap.get(keyList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime4 += elapsed;
				}
				// store the time
				result[3] = totalTime4;

				// for time 5

				long totalTime5 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// get the floorkey of the given key from hashmap
					myHashMap.floorKey(keyList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime5 += elapsed;
				}
				// store the time
				result[4] = totalTime5;

				// for time 6

				long totalTime6 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// get the floorkey of the given key from treemap
					myTreeMap.floorKey(keyList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime6 += elapsed;
				}
				// store the time
				result[5] = totalTime6;

				// for time 7

				long totalTime7 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// remove the given key in hashmap
					myHashMap.remove(keyList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime7 += elapsed;
				}
				// store the time
				result[6] = totalTime7;

				// for time 8

				long totalTime8 = 0;// put time hash
				for (int i = 0; i < keyList.size(); i++) {
					// record the startTime
					long startTime = System.currentTimeMillis();
					// remove the given key in treemap
					myTreeMap.remove(keyList.get(i));
					// calculate the cost-time by subtracting startTime
					long elapsed = System.currentTimeMillis() - startTime;
					totalTime8 += elapsed;
				}
				// store the time
				result[7] = totalTime8;
				// Store the result array into a resultList
				resultList.add(result);

				System.out.print(String.format("%.2f", 100 * ndx
						/ (float) numIter)
						+ "% done \r");

			}// end of iteration loop

			// build output format
			// time consumed of get method in hashmap
			System.out.println("HashMap: get");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(2, resultList));
			System.out.println("Max : " + getMax(2, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(2, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(2, resultList)));
			System.out.println();
			// time consumed of put method in hashmap
			System.out.println("HashMap: put");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(0, resultList));
			System.out.println("Max : " + getMax(0, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(0, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(0, resultList)));
			System.out.println();
			// time consumed of floorkey method in hashmap
			System.out.println("HashMap: floorKey");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(4, resultList));
			System.out.println("Max : " + getMax(4, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(4, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(4, resultList)));
			System.out.println();
			// time consumed of remove method in hashmap
			System.out.println("HashMap: remove");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(6, resultList));
			System.out.println("Max : " + getMax(6, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(6, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(6, resultList)));
			System.out.println();
			// time consumed of get method in treemap
			System.out.println("TreeMap: get");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(3, resultList));
			System.out.println("Max : " + getMax(3, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(3, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(3, resultList)));
			System.out.println();
			// time consumed of put method in treemap
			System.out.println("TreeMap: put");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(1, resultList));
			System.out.println("Max : " + getMax(1, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(1, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(1, resultList)));
			System.out.println();
			// time consumed of floorkey method in treemap
			System.out.println("TreeMap: floorKey");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(5, resultList));
			System.out.println("Max : " + getMax(5, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(5, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(5, resultList)));
			System.out.println();
			// time consumed of remove method in treemap
			System.out.println("TreeMap: remove");
			System.out.println("--------------------");
			System.out.println("Min : " + getMin(7, resultList));
			System.out.println("Max : " + getMax(7, resultList));
			System.out.println("Mean: "
					+ String.format("%.3f", getMean(7, resultList)));
			System.out.println("Std Dev : "
					+ String.format("%.3f", getSD(7, resultList)));

		}

		else {
			System.out.println("Sorry, the command line arguments are wrong.");
			System.out
					.println("There are should be two command line arguments:");
			System.out
				.println("1.The path to an input file containing int String" +
							" key-value pairs, one on each line");
			System.out.println("2.the number Iterations");
			System.out.println("Please try again.Bye.");
		}

	}

	/**
	 * This method is used to calculate the minimum time that consumed by each
	 * method
	 * 
	 * @param index
	 *            a integer which represents for certain method
	 * @param myList
	 *            a list which stores all the times
	 * @return result the minimum time
	 */
	private static long getMin(int index, ArrayList<long[]> myList) {
		// initialize the result by assigning the first time to it
		long result = myList.get(0)[index];
		for (int i = 0; i < myList.size(); i++) {
			// replace the minimum time when found a smaller one
			if (myList.get(i)[index] < result) {
				result = myList.get(i)[index];
			}
		}
		return result;

	}

	/**
	 * This method is used to calculate the maximum time that consumed by each
	 * method
	 * 
	 * @param index
	 *            a integer which represents for certain method
	 * @param myList
	 *            a list which stores all the times
	 * @return result the maximum time
	 */
	private static long getMax(int index, ArrayList<long[]> myList) {
		// initialize the result by assigning the first time to it
		long result = myList.get(0)[index];
		for (int i = 0; i < myList.size(); i++) {
			// replace the maximum time when found a bigger one
			if (myList.get(i)[index] > result) {
				result = myList.get(i)[index];
			}
		}
		return result;

	}

	/**
	 * This method is used to calculate the mean time that consumed by each
	 * method
	 * 
	 * @param index
	 *            a integer which represents for certain method
	 * @param myList
	 *            a list which stores all the times
	 * @return result the mean time
	 */
	private static double getMean(int index, ArrayList<long[]> myList) {
		//initialize total by assigning zero to it
		double total = 0;
		for (int i = 0; i < myList.size(); i++) {
			//sum up all the time
			total += myList.get(i)[index];
		}
		//divide the total time by the running times
		double result = total / myList.size();
		return result;

	}

	/**
	 * This method is used to calculate the standard deviation of each method
	 * 
	 * @param index
	 *            a integer which represents for certain method
	 * @param myList
	 *            a list which stores all the times
	 * @return result the standard deviation
	 */
	private static double getSD(int index, ArrayList<long[]> myList) {
		double total = 0;
		double mean = getMean(index, myList);
		for (int i = 0; i < myList.size(); i++) {
			total += (myList.get(i)[index] - mean)
					* (myList.get(i)[index] - mean);
		}
		double result = (double) Math.sqrt(total / myList.size());
		return result;
	}

}