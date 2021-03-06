///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MapBenchmark.java
// File:             SimpleTreeMap.java
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
import java.util.TreeMap;
/**
 *
 * A map is a data structure that creates a key-value mapping. Keys are
 * unique in the map. That is, there cannot be more than one value associated
 * with a same key. However, two keys can map to a same value.
 *
 * The SimpleTreeMap takes two generic parameters, K
 * and V, standing for the types of keys and values respectively.
 * 
 * <p>Bugs:unknown
 * 
 * @author Songzi Wen
 * @author Xiaojian Nie
 *
 */
public class SimpleTreeMap<K extends Comparable<K> ,V> implements 
SimpleMapADT<K, V> {

    private TreeMap<K,V> map; 
    

    SimpleTreeMap(){
		 map = new TreeMap<K,V>();
	}

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null
     * if this map contains no mapping for the key
     * @throws NullPointerException if the specified key is null
     */
    public V get(K key) throws NullPointerException{
    	if(key == null){
    		throw new NullPointerException();
    	}
    	return map.get(key);
    }

    /**
     * Associates the specified value with the specified key in this map.
     * Neither the key nor the value can be null. If the map
     * previously contained a mapping for the key, the old value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or
     * null if there was no mapping for key.
     * @throws NullPointerException if the key or value is null
     */
    public V put(K key, V value) throws NullPointerException{
    	if(key == null || value == null){
    		throw new NullPointerException();
    	}
    	return map.put(key,value);
}
    /**
     * Removes the mapping for the specified key from this map if present. This
     * method does nothing if the key is not in the map.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null
     * if there was no mapping for key.
     * @throws NullPointerException if key is null
     */
    public V remove(K key) throws NullPointerException{
    	if(key == null){
    		throw new NullPointerException();
    	}
    	return map.remove(key);
    	
}
   /**
     * Returns the greatest key less than or equal to the given key, or null 
     * if there is no such key. 
	 * Throws NullPointerException if key is null. 
     * @param key key whose floor should be found
     * @return the largest key smaller than the one passed to it
     * @throws NullPointerException if key is null
     */
    public K floorKey(K key) throws NullPointerException {
    	if(key == null){
    		throw new NullPointerException();
    	}
    	return map.floorKey(key);
    }
}