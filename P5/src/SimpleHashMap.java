///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MapBenchmark.java
// File:             SimpleHashMap.java
// Semester:         CS367 Fall 2014
//
// Author:           Songzi Wen
// CS Login:         songzi
// Lecturer's Name:  Jim Skrentny
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
// Pair Partner:     Xiaojian Nie
// CS Login:         xiaojian
// Lecturer's Name:  Jim Skrentny
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * A map is a data structure that creates a key-value mapping. Keys are unique
 * in the map. That is, there cannot be more than one value associated with a
 * same key. However, two keys can map to a same value.
 *
 * The SimpleHashMap takes two generic parameters, K and V, standing for the
 * types of keys and values respectively.
 *@author Songzi Wen
 *@author Xiaojian Nie
 * <p>Bugs:unknown
 */
public class SimpleHashMap<K extends Comparable<K>, V> implements
		SimpleMapADT<K, V> {

	private int[] tableSizes = { 11, 23, 47, 97, 197, 397, 797, 1597, 3203,
			6421, 12853, 25717, 51437, 102877, 205759, 411527, 823117, 1646237,
			3292489, 6584983, 13169977, 26339969, 52679969, 105359939,
			210719881, 421439783, 842879579, 1685759167 };

	private double lf = 0.75;

	private LinkedList<Entry<K,V>>[] table;//hash table array
	private int tableSize;
	private int tableSizeIndex;//the index of tableSize in array tableSizes
	
	/**
	 * Constructs an empty SimpleHashMap with initial size 
	 */
	public SimpleHashMap() {
		this.tableSizeIndex = 0;
		this.tableSize = tableSizes[tableSizeIndex];
		table = new LinkedList[tableSize];
	}

	/**
	 * Calculate the hash index for Key k
	 *
	 * @param k
	 *            Key 
	 * @return hash index for key k
	 */
	private int hash(K k) {
		//check if the hashCode is valid
    if(k.hashCode() >= 0){
    return k.hashCode() % this.tableSize;
    }
    else{
    	//fix when hashCode is not valid
    	return k.hashCode() % this.tableSize + this.tableSize;
    }	
    }	
	
	/**
	 *Check if the current HashMap is too full(lf >= 0.75)
	 *
	 * @return true if the current HashMap is too full
	 * @return false if the current HashMap is not too full
	 */
	private boolean isToofull(){
	    //compute total number of indexes that are not null in hash table
		double numLoaded = 0;
		for(int i = 0; i < tableSize; i++){
			if(table[i] != null){
				numLoaded++;
			}
		}
		//compute the load factor and determine if the Hash Map is too full
	if(numLoaded / tableSize >= this.lf){
		return true;
	}
	else{
		return false;
	}
		
	}
	 
	
	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 *
	 * @param key
	 *            the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this
	 *         map contains no mapping for the key
	 * @throws NullPointerException
	 *             if the specified key is null
	 */
	public V get(K key) throws NullPointerException {
	    //handle when key is null
		if(key == null){
			throw new NullPointerException();
		}
		//compute the hash index for key 
		int myHashIndex =  hash(key);
		//handle if no items in the hash index
		if(table[myHashIndex] == null){
			return null;
		}
		//handle when there are already items in hash index(collisions occur)
		else{
		LinkedList<Entry<K, V>> myList =  table[myHashIndex];
		//go through linkedList and find the entry for given key
		Iterator<Entry<K, V>> myItr = myList.listIterator();
		while(myItr.hasNext()){
			Entry<K, V> temp = myItr.next();
			//get the value of given key
			if(key.equals(temp.getKey())){
				return (V)temp.getValue();
			}
		}
		//return null when map contains no mapping for the key
		return null;
		}
		
		
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * Neither the key nor the value can be null. If the map previously
	 * contained a mapping for the key, the old value is replaced.
	 *
	 * @param key
	 *            key with which the specified value is to be associated
	 * @param value
	 *            value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 * @throws NullPointerException
	 *             if the key or value is null
	 */
	public V put(K key, V value) throws NullPointerException {
		//handle when key or value is null
		if(key == null || value == null){
			throw new NullPointerException();
		}
		//handle if the map is too full
		if(isToofull()){
			//resize the hash table
			tableSizeIndex++;
			tableSize = tableSizes[tableSizeIndex];
			//construct new hash table
			LinkedList<Entry<K, V>>[] expandedArray = new LinkedList[tableSize];
			//copy old table to new table
			for(int i = 0; i <  tableSizes[tableSizeIndex - 1]; i++){
				expandedArray[i] = this.table[i];
			}
			//update the table reference
			this.table = expandedArray;
		    //compute the hash index
			int myHashIndex =  hash(key);
			//handle when there are already items in hash index for given key
			if(table[myHashIndex] != null){
				//go through linkedList
				Iterator<Entry<K, V>> myItr = table[myHashIndex].listIterator();
				while(myItr.hasNext()){
					Entry<K,V> temp = myItr.next();
	   //change the value for given key if the entry for given key is found
					if(key.equals(temp.getKey())){
						return (V) temp.setValue(value);
					}
				}
				//return null if there was no mapping for the key
				Entry<K,V> newEntry = new Entry<K, V>(key, value);
				table[myHashIndex].addFirst(newEntry);
				return null;
			}
			else{
				//handle when there are no items in hash index for given key
				Entry<K,V> newEntry = new Entry<K, V>(key, value);
				//construct new linkedList
				LinkedList<Entry<K, V>> myList = new LinkedList<Entry<K,V>>();
				myList.addFirst(newEntry);
				table[myHashIndex] = myList;
				//return null if there was no mapping for the key
				return null;		
			}
		}
		
		//handle when the hash map is not too full
		else{
        //compute hash index for given key
		int myHashIndex =  hash(key);
		//handle when there are already items in hash index
		if(table[myHashIndex] != null){
			//go through linkedList in give hash index
			Iterator<Entry<K, V>> myItr = table[myHashIndex].listIterator();
			while(myItr.hasNext()){
				Entry<K,V> temp = myItr.next();
		//change the value for given key if the entry for given key is found
				if(key.equals(temp.getKey())){
					return (V) temp.setValue(value);
				}
		     }
			//return null if there was no mapping for the key
			Entry<K,V> newEntry = new Entry<K, V>(key, value);
			table[myHashIndex].addFirst(newEntry);
			return null;
			
			
		}
		else{
			//handle when there are no items in hash index
			Entry<K,V> newEntry = new Entry<K, V>(key, value);
			LinkedList<Entry<K, V>> myList = new LinkedList<Entry<K,V>>();
			myList.addFirst(newEntry);
			table[myHashIndex] = myList;
			//return null if there was no mapping for the key
			return null;		
		}
		}
	}

	/**
	 * Removes the mapping for the specified key from this map if present. This
	 * method does nothing if the key is not in the map.
	 *
	 * @param key
	 *            key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 * @throws NullPointerException
	 *             if key is null
	 */

	public V remove(K key) throws NullPointerException {
		//handle when key is null
		if(key ==  null){
			throw new NullPointerException();
		}
		//compute the hash index for given key
		int myHashIndex =  hash(key);
	 //handle when there are already items in hash index 
		if(table[myHashIndex] !=  null){
			//go through the linkedList
			Iterator<Entry<K, V>> myItr = table[myHashIndex].listIterator();
			while(myItr.hasNext()){
			   Entry<K, V> temp = myItr.next();
			   //remove the Entry when the mapping of given key is found
				if(key.equals(temp.getKey())){
				   V myValue = (V) temp.getValue();
				   table[myHashIndex].remove(temp);
			       return myValue;
				}
			}
			//return null if there was no mapping for key
			return null;
		}
		else{
			//handle when there are no items in hash index
			//return null if there was no mapping for key
			return null;
		}
			
	}

	/**
	 * Returns the greatest key less than or equal to the given key, or null if
	 * there is no such key. Throws NullPointerException if key is null.
	 * 
	 * @param key
	 *            key whose floor should be found
	 * @return the largest key smaller than the one passed to it
	 * @throws NullPointerException
	 *             if key is null
	 */
	public K floorKey(K key) throws NullPointerException {
		//handle when key is null
		if(key ==  null){
			throw new NullPointerException();
		}
		boolean firstTime = true;
		K floorKey = null;
		//traverse the hash table
		for(int i = 0; i < tableSize; i++){
			//handle when there are already items in current index i 
			if(table[i] != null){
			LinkedList<Entry<K, V>> myList = table[i];
			//go through the linkedList
			Iterator<Entry<K, V>> myItr = myList.listIterator();
			while(myItr.hasNext()){
				
				   Entry<K, V> temp = myItr.next();
                  //return floor key if found some key is equal to given key
				   if(key.compareTo((K) temp.getKey()) == 0){
					   floorKey = temp.getKey();
						   return floorKey;
				   }
				   //check if current key  is smaller than the given key
				   else if(key.compareTo((K) temp.getKey()) > 0){
					   //handle firstTime issue
					   if(firstTime){
						   floorKey = temp.getKey();
						   firstTime = false;
					   }
					   //check if current key is larger than current floor key
					   else if(temp.getKey().compareTo(floorKey) > 0 ){
						   //update the floorkey 
						   floorKey = (K) temp.getKey();
					   }
				   }   
			
		}
		}
		}
	    //return result
		return floorKey;
	}
	

}
