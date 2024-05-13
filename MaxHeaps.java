public class MaxHeaps {
	private int[] Heap;
	private int size;
	private int maxsize;

	// Constructor
	// capacity
	public MaxHeaps(int limit)
	{
		maxsize = limit;
		size = 0;
		Heap = new int[maxsize];
	}

	// Functional methods

	// Returning the  position of parent
	private int parent(int pos) { return (pos - 1) / 2; }

	// Returning the left child
	private int leftChild(int pos) { return (2 * pos) + 1; }

	// Returning the right child
	private int rightChild(int pos)
	{
		return (2 * pos) + 2;
	}

	// Returning true if given node is leaf
	private boolean isLeaf(int pos)
	{
		
		return (pos > (size / 2) && pos <= size);
	}

	// Swapping nodes
	private void swap(int first, int second)
	{
		int temp;
		temp = Heap[first];
		Heap[first] = Heap[second];
		Heap[second] = temp;
	}

	// Recursive function to max heapify given subtree
	private void maxHeapify(int pos)
	{
		if (isLeaf(pos))
			return;

		if (Heap[pos] < Heap[leftChild(pos)]
			|| Heap[pos] < Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)]
				> Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	// Inserts a new element to max heap
	public void insert(int element)
	{
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		while (Heap[current] > Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}


	// Removing the max alement
	public int extractMax()
	{
		int popped = Heap[0];
		Heap[0] = Heap[--size];
		maxHeapify(0);
		return popped;
	}
	
	// print the array
	public void printArray(){
		for (int i = 0; i < size; i++) {
			System.out.print(Heap[i]+ ", ");
			
		}
		// Printing a new line
		System.out.println();
	} 

	public void display() {
		if (size == 0) {
			System.out.println("Heap is empty");
			return;
		}
	
		displayRecursive(0, 0);
	}
	
	private void displayRecursive(int index, int level) {
		if (index >= size)
			return;
	
		// Print right child
		displayRecursive(rightChild(index), level + 1);
	
		// Print current node
		for (int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println(Heap[index]);
	
		// Print left child
		displayRecursive(leftChild(index), level + 1);
	}


}
