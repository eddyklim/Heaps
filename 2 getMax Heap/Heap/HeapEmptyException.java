package Heap;

public class HeapEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8374336116298061993L;

	public HeapEmptyException() {
		super("Heap is empty");
	}
}