package Heap;

public class Heap {

	// We will assume a maximum heap dimension
	// You could easily change the code to re-size if the heap gets full
	// Here, we just throw an exception in this case
	private static int defaultDim = 1024;

	HeapNode[] h;
	int last;

	public Heap() {
		h = new HeapNode[defaultDim];
		last = -1;
	}

	// public Heap(Object[] o, int[] a) throws InvalidSizeException() {
	// if (a.length != o.length)
	// throw new InvalidSizeException();
	// h = new HeapNode[a.length];
	// for (int i = 0; i < h.length; i++)
	// h[] = new HeapNode(a[i], o[i]);
	// last = -1;
	// }

	public boolean isEmpty() {
		return (last < 0);
	}

	public void printHeap() {
		if (isEmpty()) {
			System.out.println("Heap is Empty");
			return;
		}
		printByLevel(0, 0);
	}

	private void printByLevel(int i, int level) {
		if (i > last)
			return;
		for (int j = 0; j < level; j++)
			System.out.print("   ");
		System.out.println("Priority: " + h[i].key + " Content: " + h[i].content);
		printByLevel(2 * i + 1, level + 1);
		printByLevel(2 * i + 2, level + 1);
	}

	public Object findMin() throws HeapEmptyException {
		if (isEmpty())
			throw new HeapEmptyException();
		return h[0].content;
	}

	private int getParent(int i) {
		if (i == 0)
			return -1;
		return ((i - 1) / 2);
	}

	private int getLeft(int i) {
		return (i * 2 + 1);
	}

	private int getRight(int i) {
		return (i * 2 + 2);
	}

	private void swap(int i, int j) {
		HeapNode tmp = h[i];
		h[i] = h[j];
		h[j] = tmp;
	}

	public void insert(Object o, int p) throws HeapFullException {
		// Find the right place to put this new node
		last++;

		if (last >= h.length)
			throw new HeapFullException();

		// Wrap the content in a node
		h[last] = new HeapNode(o, p);

		// Bubble up this node if need be
		int i = last;
		int parent;
		for (parent = getParent(i); i > 0 && h[i].key < h[parent].key; parent = getParent(i)) {
			swap(i, parent);
			i = parent;
		}
	}

	public Object removeMin() throws HeapEmptyException {
		if (last < 0)
			throw new HeapEmptyException();

		// Get the value to return
		Object value = h[0].content;

		// Now swap the last heap node for the root, and update the last index
		swap(0, last--);

		// Bubble down the root value if need be
		int i = 0;
		boolean swapped;
		do {
			swapped = false;
			int left = getLeft(i);
			int right = getRight(i);
			if (left > last && right > last) {
				// we got to the end of the heap, so nothing lese to do
				i = last + 1;
			} else if (left <= last && right <= last) {
				int min = (h[left].key < h[right].key) ? left : right;
				if (min <= last && h[min].key < h[i].key) {
					swap(i, min);
					i = min;
					swapped = true;
				}
			} else {
				// we have a child only on the left side
				if (h[left].key < h[i].key) {
					swap(i, left);
					i = left;
					swapped = true;
				}
			}
		} while (i <= last && swapped);
		return value;
	}

	// This method is O(n) because the maximum is located at leaves which means we must
	// visit every leaf. In the worst case we have to check every leaf node.
	public Object getMax() throws HeapEmptyException {
		int maxNode = 0;
		// if no root
		if (isEmpty())
			throw new HeapEmptyException();
		// if only root
		if (last == 0) {
			return h[0].content;
		}
		// look through the nodes comparing priority
		for (int i = 1; i <= last; i++) {
			// looks for highest priority
			if (h[i].key >= h[maxNode].key) {
				maxNode = i;
			}
			// if same priority look at content
			// if (h[i].key == h[maxNode].key) {
			// if (h[i].content > h[maxNode].content) {
			// maxNode = i;
			// }
			// }
		}
		return h[maxNode].content;
	}
}
