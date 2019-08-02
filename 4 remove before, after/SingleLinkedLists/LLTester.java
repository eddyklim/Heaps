package SingleLinkedLists;

public class LLTester {

	public static void main(String[] args) throws EmptyListException {

		SingleLinkedList list = new SingleLinkedList();
		for (int i = 0; i < 10; i++) {
			list.insertLast(i);
		}
		
		list.insertFirst("x");
		list.removeAfter("x");
		list.removeBefore(1);
		list.print();
	}
}
