
public class HeapSort {

	public static void sort(int[] arr){
		// Build Heap
		int heapSize = arr.length;
		int[] heap = new int [heapSize+1];
		System.arraycopy(arr, 0, heap, 1, arr.length);
		for(int i = (heapSize)/2; i > 0; i--){
			heapifyDown(heap, i, heapSize);
		}
		//Remove Max from Heap
		while(heapSize > 1){
			swap(heap, 1, heapSize);
			heapSize--;
			heapifyDown(heap, 1, heapSize);
		}
		
		for(int i = 1; i < heap.length; i++)
			arr[i-1] = heap[i];		
	}
	
	private static void heapifyDown(int[] heap, int index, int heapSize){
		while(index <= heapSize/2){
			if (index*2+1 > heapSize && heap[index] > heap[index*2])  //if Parent has no right child
					return;
			else if (heap[index] > heap[index*2] && heap[index] > heap[index*2+1])  // if parent has two children
				return;  
			if ((index*2)+1 > heapSize || heap[index*2] > heap[(index*2)+1] ){ //if Left child is greater than right
				swap(heap, index,index*2);
				index *= 2;
			}
			else{ //swap with right child
				swap(heap, index, index*2+1);  
				index = (index * 2) +1;	
			}
		}
	}

	
	private static void swap(int[] heap, int posA, int posB){
		int temp = heap[posB];
		heap[posB] = heap[posA];
		heap[posA] = temp;
	}


	public static void main(String [] args){
		int [] myArray = {4,7,2,8,1,9,3,5,6};
		HeapSort.sort(myArray);
		for(int i:myArray)
			System.out.print(i+", ");
	
	}
}
