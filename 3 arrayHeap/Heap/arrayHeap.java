package Heap;

class arrayHeap {

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {
		int[] arr = { 9, 10, 6, 7, 4, 12 };
		System.out.print("Input array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");

		System.out.print("Heap array: ");
		buildHeap(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");

		System.out.print("Sorted array: ");
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");

		System.out.println("Kth largest: " + findK(arr, 2));
	}

	public static int[] buildHeap(int[] arr) throws HeapEmptyException {
		if (arr.length == 0) {
			throw new HeapEmptyException();
		}
		for (int i = arr.length / 2 - 1; i >= 0; i--)
			heapify(arr, arr.length, i);
		return arr;
	}

	public static int findK(int[] arr, int kth) throws HeapFullException, HeapEmptyException {
		if (kth > arr.length - 1) {
			throw new HeapFullException();
		}
		sort(arr);
		return arr[(arr.length - 1) - kth];
	}

	public static void sort(int arr[]) throws HeapEmptyException {
		buildHeap(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	public static void heapify(int arr[], int n, int i) {
		int max = i;
		// left
		if ((2 * i + 1) < n && arr[(2 * i + 1)] > arr[max]) {
			max = (2 * i + 1);
		}
		// right
		if ((2 * i + 2) < n && arr[(2 * i + 2)] > arr[max]) {
			max = (2 * i + 2);
		}
		// root
		if (max != i) {
			int swap = arr[i];
			arr[i] = arr[max];
			arr[max] = swap;
			heapify(arr, n, max);
		}
	}
}