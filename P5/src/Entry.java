///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  MapBenchmark.java
// File:             Entry.java
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
/**
     * A map entry (key-value pair).
     * 
     * <p>Bugs: unknown
     * @author Songzi Wen
     * @author Xiaojian Nie
     */
public class Entry<K, V> {
    private K key;
    private V value;

    /**
     * Constructs the map entry with the specified key and value.
     */
    public Entry(K k, V v) { 
    	this.key = k;
    	this.value = v;
    }

    /**
     * Returns the key corresponding to this entry.
     *
     * @return the key corresponding to this entry
     */
    public K getKey() {
          return  this.key;   
    }

    /**
     * Returns the value corresponding to this entry.
     *
     * @return the value corresponding to this entry
     */
    public V getValue() {
        return this.value;
    }

    /**
     * Replaces the value corresponding to this entry with the specified
     * value.
     *
     * @param value new value to be stored in this entry
     * @return old value corresponding to the entry
     */
    public V setValue(V value) {
       V temp = this.value;
       this.value = value;
       return temp;
    }
    
}