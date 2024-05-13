public class Driver {
    public static void main(String[] arg)
	{
		System.out.println("The Max Heap is ");

		MaxHeaps maxHeap = new MaxHeaps(15);


		maxHeap.insert(10);
		maxHeap.insert(19);
		maxHeap.insert(300);
		maxHeap.insert(15);
		maxHeap.insert(60);
		maxHeap.insert(69);
		maxHeap.insert(1);
		maxHeap.insert(105);
		maxHeap.insert(20);
		maxHeap.display();
        System.out.println(maxHeap.extractMax());
        maxHeap.printArray();

	}
}
