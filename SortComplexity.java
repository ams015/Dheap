package hw6;
import java.util.Random;



/**
 * compares the complexity of heapsort,mergesort
 * and quicksort
 * @author Aman Singh
 *
 */
public class SortComplexity {


	protected static    int     comparisons;
	protected static    int     movements;
	protected   long    time;
	protected static   Boolean    sorted;
	protected static    int    count;

	private static int HUNDRED =100;

	private static int NINE=9;

	private static int TEN=10;

	private dHeap<Integer> heap;


	/**
	 * does heapsort method
	 * @param list
	 * @param listSize
	 */
	private void heapSort(int list[],int listSize){
		//build heap from array
		dHeap<Integer> heap =  buildHeap(list, listSize);

		//remove from heap and sort
		for(int i=0;i<list.length;i++){


			heap.remove();
		}


	}

	/**
	 * builds a heap given array
	 * @param marray
	 * @param size
	 * @return
	 */
	private static dHeap<Integer> buildHeap(int[] marray,int size){




		dHeap<Integer> newHeap = new dHeap<Integer>(size,true);

		//add elements to heap
		for(int i = 0; i< marray.length;i++){

			newHeap.add(marray[i]);
		}

		return newHeap;

	}

	/**
	 * does quicksort on array
	 * @param list
	 * @param low
	 * @param high
	 */
	private void quickSort(int list[], int low, int high) 
	{
		if (low<high)
		{        
			int pivot = partition(list, low, high);
			quickSort(list, low, pivot);
			quickSort(list, pivot+1, high); 
		}
	}


	/**
	 * does partition for quicksort
	 * @param list
	 * @param low
	 * @param high
	 * @return
	 */
	private int partition(int list[], int low, int high)
	{
		int temp = list[low];
		int i = low-1;
		int j = high+1;
		while(true)
		{
			do {
				j--;
			} while (list[j] > temp);
			do {
				i++;
			} while (list[i] < temp);
			if (i < j)
			{

				int swapTemp = list[i];
				list[i] = list[j];
				list[j] = swapTemp;
			}
			else
			{
				return j;
			}
		}
	};


	/**
	 * does mergesort on array
	 * @param list
	 * @param low
	 * @param high
	 */
	private void mergeSort(int list[], int low, int high) 
	{
		if (low<high)
		{
			int mid = (low+high)/2;
			mergeSort(list, low, mid);
			mergeSort(list, mid+1, high);
			merge(list, low, mid, high);
		}
	}
	/**
	 * merges for mergesort
	 * @param list
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void merge(int list[], int low, int mid, int high)
	{
		int h = low;
		int i = 0;
		int j = mid+1;
		int otherList[] = new int[high-low+1];
		while ((h <= mid) && (j <= high))
		{
			comparisons++;
			if (list[h] <= list[j])
			{
				otherList[i] = list[h];
				h++;
			}
			else
			{
				otherList[i] = list[j];
				j++;
			}
			i++;
		}
		if (h>mid)
		{
			for (int k=j; k<=high; k++)
			{
				otherList[i] = list[k];
				i++;
			}
		}
		else
		{
			for (int k=h; k<=mid; k++)
			{
				otherList[i] = list[k];
				i++;
			}
		}

		for (int m=0; m<otherList.length; m++)
		{
			list[low+m] = otherList[m];
		}
	}

	/**
	 * creats and array given size
	 * either random or near sorted 
	 * @param size  size of array
	 * @param random whether its random or near sorted array
	 * @return an array
	 */
	private static int[] createArray(int size,boolean random){
		int[] array = new int[size];
		Random rand= new Random();
		int cutoff= (size*NINE)/TEN;
		//random array
		if(random){


			for(int i=0;i<size;i++){
				array[i]=rand.nextInt(size);
			}
		}


		//near sorted array
		else{
			for(int i=0;i<cutoff;i++){
				array[i]= i;

			}
			for(int i=cutoff;i<size;i++){
				array[i]= i;

			}


		}
		return  array;


	}
	/**
	 * main method, runs algorithms and gets runtime
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SortComplexity project = new SortComplexity();

		//array containing all input values
		int[] n_values = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 
			8000, 9000, 10000};

		//random array
		int[] arrayrandom;

		//near sorted array
		int[] arraynearsort;




		//each element in quick1 will add up the 1000 runtimes
		// per n value for quicksort on random list
		// same for heapsort and h1, mergesort and m1



		long[] quick1= new long[n_values.length];

		long[] merge1= new long[n_values.length];
		long[] heap1= new long[n_values.length];


		//each element in quick2 will add up the 1000 runtimes
		// per n value for quicksort on nearly sorted list
		// same for heapsort and h2, mergesort and m2

		long[] quick2= new long[n_values.length];

		long[] merge2= new long[n_values.length];
		long[] heap2= new long[n_values.length];

		//for each input
		for(int i=0;i<n_values.length;i++){
			int number = n_values[i];
			arrayrandom = createArray(number, true);
			arraynearsort = createArray(number,false);

			//run 100 times
			for(int j=0;j<HUNDRED;j++){

				//for near random lists


				//quicksort on random list
				long currentTime11 = System.nanoTime();

				project.quickSort(arrayrandom,0,arrayrandom.length -1);
				long currentTime12 = System.nanoTime();

				long runTime1 = currentTime12- currentTime11;
				quick1[i]= quick1[i]+ runTime1 ;


				//mergesort on random list
				long currentTime21 = System.nanoTime();

				project.mergeSort(arrayrandom,0,arrayrandom.length -1);
				long currentTime22 = System.nanoTime();


				long runTime2 = currentTime22- currentTime21;
				merge1[i]= merge1[i]+ runTime2;


				//heapsort on random list
				long currentTime31 = System.nanoTime();
				project.heapSort(arrayrandom,number);

				long currentTime32 = System.nanoTime();


				long runTime3 = currentTime32- currentTime31;
				heap1[i]= heap1[i]+ runTime3;

				//quicksort on near sorted list
				currentTime11 = System.nanoTime();

				project.quickSort(arraynearsort,0,arraynearsort.length -1);


				currentTime12 = System.nanoTime();

				runTime1 = currentTime12- currentTime11;
				quick2[i]= quick2[i]+ runTime1 ;


				//mergesort on near sorted list
				currentTime21 = System.nanoTime();

				project.mergeSort(arrayrandom,0,arraynearsort.length -1);
				currentTime22 = System.nanoTime();

				//calculate runtime of method2
				runTime2 = currentTime22- currentTime21;
				merge2[i]= merge2[i]+ runTime2;



				//heap sort on near sorted list
				currentTime31 = System.nanoTime();
				project.heapSort(arraynearsort,number);

				currentTime32 = System.nanoTime();
				//calculate runtime of method3
				runTime3 = currentTime32- currentTime31;
				heap2[i]= heap2[i]+ runTime3;

			}

		}

		//array for each sort and each list;
		// will contain average runtime of each n value.

		//average array for quicksort on random list
		long[] averagequick1= new long[n_values.length];


		//average array for mergesort on random list
		long[] averagemerge1= new long[n_values.length];

		//average array for heapsort on random list
		long[] averageheap1= new long[n_values.length];


		//average array for quicksort on nearly sorted list
		long[] averagequick2= new long[n_values.length];


		//average array for mergesort on nearly sorted list
		long[] averagemerge2= new long[n_values.length];


		//average array for heapsort on nearly sorted list
		long[] averageheap2= new long[n_values.length];

		//Calculating average runtimes for each method 
		//for each n
		for(int i=0;i<n_values.length;i++){
			averagequick1[i]= quick1[i]/HUNDRED;
			averagemerge1[i]= merge1[i]/HUNDRED;

			averageheap1[i]= heap1[i]/HUNDRED;
			averagequick2[i]= quick2[i]/HUNDRED;

			averagemerge2[i]= merge2[i]/HUNDRED;
			averageheap2[i]= heap2[i]/HUNDRED;
			System.out.println("For random list");
			System.out.println("averagemerge1 at "+n_values[i] + " : " +averagemerge1[i] +
					"  averagequick1 at"+n_values[i] + " : " +averagequick1[i]+"  averageheap1 at "
					+n_values[i] + " : " +averageheap1[i]);


			System.out.println("For near sorted list");
			System.out.println("averagemerge2 at "+n_values[i] + " : " +averagemerge2[i] +
					"  averagequick2 at"+n_values[i] + " : " +averagequick2[i]+"  averageheap2 at "
					+n_values[i] + " : " +averageheap2[i]);

		}

	}





}
