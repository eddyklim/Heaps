package Heap;

public class HeapTester {

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		// TODO Auto-generated method stub
		Heap hp = new Heap();
		for (int i = 0; i <= 5; i++) {
			hp.insert("hi " + i, i);
		}
		hp.insert("hi " + 6, 5);
		hp.printHeap();
		System.out.println(hp.getMax());

	}

}
