package hw6;

public interface dHeapInterface<T> {
	/**
	 * Returns the number of elements stored in the heap
	 * @return Returns the number of elements stored in the heap
	 */
	public int size () ;
	
	/**
	 * Adds the specified element to the heap; o cannot be null. Resizes the storage if full.
	 * @param o-the element to add.
	 * @throws java.lang.NullPointerException - if null
	 */
	public void add (T o) ;

	/**
	 * Removes and returns the element stored on the heap. If the heap is empty, then this method throws a NoSuchElementException.
	 * @return the element stored in the heap.
	 * @throws java.util.NoSuchElementException - if the heap is empty
	 */
	public T remove ();

}
