package Heap;

public class HeapFullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838861007586681468L;

	public HeapFullException() {
		super("Heap is full");
	}
}