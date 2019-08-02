package SingleLinkedLists;

public class EmptyListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5534086521962825053L;

	public EmptyListException() {
		super("Illegal operation in an empty list");
	}
}