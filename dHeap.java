package hw6;

import java.util.*;

// ***********************
// NAME: Aman Singh
// ID: A11012283
// LOGIN: cs12sgb
// ***********************


/**
 * Class for the dHeap data structure
 * supports min and max dHeaps
 * @author p
 *
 * @param <T>
 */

class dHeap <T extends Comparable <? super T>> implements dHeapInterface<T> {


	private T[] array;

	//size of array
	private int arraySize;

	//number of elements in heap
	private int nelems;

	//number of children each node can have
	private int childrenNum;

	//whether tree is max or min
	private boolean isitMax;

	private static final int DEFAULT =5;

	private static final int TWO =2;


	/** O-argument constructor. Creates and empty dHeap with 
	 *  initial capacity = 5, and is a 2-min-heap 
	 */ 

	@SuppressWarnings("unchecked")
		public dHeap()
		{
			nelems=0;
			arraySize=DEFAULT;
			childrenNum=TWO;
			isitMax= false;
			array = (T[ ]) new Comparable[DEFAULT];
		}

	/** 
	 * Constructor to build a min or max dheap
	 * @param isMaxHeap  if true, this is a 2-max-heap, else a 2-min-heap 
	 * with initial size = 'capacity'
	 */ 
	@SuppressWarnings("unchecked")
		public dHeap(int capacity, boolean isMaxHeap){
			nelems=0;
			arraySize=capacity;
			childrenNum=TWO;
			isitMax=isMaxHeap;

			array = (T[ ]) new Comparable[capacity];


		}



	/** 
	 * Constructor to build a with specified initial capacity and
	 * given number of children d. 
	 * @param capacity initial capacity of the heap.	
	 * @param isMaxHeap if true, this is a max-heap, else a min-heap 
	 * @param d number of children, 
	 * @exception if d is less than one, throw IllegalArgumentException();
	 */ 
	@SuppressWarnings("unchecked")
		public dHeap(int capacity, boolean isMaxHeap, int d)
		{
			childrenNum=d;
			arraySize=capacity;
			isitMax=isMaxHeap;

			array = (T[ ]) new Comparable[capacity];


		}

	/**
	 * Returns the number of elements stored in the heap
	 * @return Returns the number of elements stored in the heap
	 */
	public  int size() {
		// maintain a variable numElems and return this value in size()

		return this.nelems;


	}

	/**
	 * Adds the specified element to the heap; data cannot be null. Resizes the storage if full.
	 * @param data-the element to add.
	 * @throws java.lang.NullPointerException - if null
	 */
	public void add (T data) {
		int temp = size();
		int position=size();


		//if element added is null
		if(data == null){

			throw new NullPointerException();
		}


		//Add an element to the first empty slot.. Then call bubbleUp() to bubble the added element up to the right position
		// Make sure you resize your heap when you are out of memory

		//if array has reached it capacity, resize it
		if(size() >= arraySize-1){
			resizeIt();
		}

		array[position]= data;
		nelems++;
   
   //bubbleup
		if(temp!=0){
			bubbleUp(position);
		}


	}

	/**
	 * Removes and returns the element stored on the heap. If the heap is empty, then this method throws a NoSuchElementException.
	 * @return the element stored in the heap.
	 * @throws java.util.NoSuchElementException - if the heap is empty
	 */
	public T remove () { 

		//removeSmallest(): remove smallest and replace with last element. Then call trickleDown to adjust the heap.
		int tmp=size();

		//if heap is already empty
		if(isEmpty()){

			throw new NoSuchElementException();
		}

		T temp = array[0];

		if(nelems==1){
			nelems--;
			return (T) temp;
		}

		swap(array,0,--nelems);
   
    //trickle dwn
		if(tmp!=0){
			trickleDown(0);
		}
		return (T) temp;

	}




	/**
	 * Corrects the heap property after you remove node
	 * @param indx the index of the node inputted
	 */
	private void trickleDown(int indx){
		int curr=indx;
		assert (indx>=0 && indx <nelems):"this is illegal position";
			//trickleDown: If smallest child is smaller than the parent, trickle it down. Kee doing until parent is smallest or you reached end of the heap.


			while(!isaLeaf(curr)){
				int j=leftChildPosition(curr);
				int max= j;
				int min = j;


        //for max heap
				if(isitMax){
					for(int i=1;i<childrenNum;i++){
						if(  (max<(nelems-1))&& (array[max].compareTo(array[j+i])<0)){
							max=j+i;
						}


					}

					if (array[curr].compareTo(array[max]) >= 0) break;
					swap(array,max,curr);
					curr=max;
				}
        //for min heap
				else{

					for(int i=1;i<childrenNum;i++){
						if(  (min<(nelems-1))&& (array[min].compareTo(array[j+i])>0)){
							min=j+i;
						}
					}

					if (array[curr].compareTo(array[min]) <= 0) break;

					swap(array,min,curr);
					curr=min;
				}

			}






	}

	/**
	 * corrects the heap property after you add an element to heap
	 * @param indx the index of the node being bubbled up
	 */
	private void bubbleUp(int indx){
		//get parent, compare
		int index=indx;

                // for min heap
		if(isitMax==false){
			while((index !=0) &&  (array[index].compareTo(array[parentPosition(index)])<0)){ 

				swap(array,index, parentPosition(index));
				index = parentPosition(index);
			}

		}
    //for max heap
		else{

			while((index !=0) &&  (array[index].compareTo(array[parentPosition(index)])>0)){ 
				swap(array,index, parentPosition(index));
				index = parentPosition(index);
			}
		}	
		//Bubble up the added element if necessary, to maintain the minHeap  property


	}
	/**
	 * doubles the size of the array
	 */
	private void resizeIt(){

		int newcapacity= arraySize*TWO;

		@SuppressWarnings("unchecked")
			//declare new array;
			T[] Temp = (T[])(new Comparable[newcapacity]);

		//copy array into new array
		for(int i=0;i<arraySize;i++){
			Temp[i]= array[i];
		}


		arraySize=newcapacity;
		//make array point to new array
		array = Temp;


	}
	/**
	 * returns whether the heap is empty
	 * @return
	 */
	private  boolean isEmpty(){
		if(size()==0){
			return true;
		}

		return false;
	}

	/**
	 * figures out whetehr a node is a leaf
	 * @param position -position of the leaf you are checking
	 * @return
	 */
	private boolean isaLeaf(int position){
		if(( position >= nelems/childrenNum) && (position < nelems)){
			return true;
		}
		return false;
	}

	/**
	 * finds the position of a node's parent
	 * @param position- position of node inputted
	 * @return
	 */
	private int parentPosition(int position){

		assert position >0 : "there's no parent of this node";
		return (position-1)/childrenNum;
	}

	/**
	 * finds the position of a node's left child
	 * @param position
	 * @return
	 */
	private int leftChildPosition(int position){

		assert position < nelems/childrenNum : "there's no leftchild of this node";
		return childrenNum*position + 1;

	}

	/*
	   private int rightChildposition(int position){
	   assert position>0 : "there is no right child of this node";
	   return childrenNum*(position)+childrenNum;
	   }
	   */

	/**
	 * swaps position of 2 places in array a
	 * @param a-array
	 * @param position1 -the 1st position
	 * @param position2 -the 2nd position
	 */
	private  void swap(T[] a,int position1, int position2){
		T temp= a[position1];
		a[position1]=a[position2];
		a[position2]=temp;

	}


	/**
	 * builds a heap given an array, its size, and whether
	 * it is min or max
	 * @param marray-array
	 * @param size -size of array
	 * @param isMaxHeap-whether it is a head
	 * @return a heap
	 */

	@SuppressWarnings("rawtypes")
	private dHeap<T> buildHeap(T[] marray,int size,boolean isMaxHeap){

	         //initialize heap
		@SuppressWarnings("unchecked")
		dHeap<T> newHeap = new dHeap(size,isMaxHeap);

                //add elements to heap
		for(int i = 0; i< marray.length;i++){
		
			newHeap.add(marray[i]);
		}

		return newHeap;

	}

	/**
	 * merges two heaps
	 * @param hp- heap to merge with
	 * @param isMaxHeap - whether it is a max heap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public dHeap<T> merge(dHeap<T> hp, boolean isMaxHeap){

		int size1,size2,newsize;
		T[] mergedarray;

	

		if(this.isEmpty() ){
			return hp;
		}
		if(hp.isEmpty()){
			return this;
		}
     
		size1= this.size();;
		size2= hp.size();
   
                //size of new array
		newsize= size1+size2;
   
                //array that merges arrays of both heaps
		mergedarray= (T[])(new Comparable[newsize]);
 
    
		System.arraycopy(this.array, 0, mergedarray, 0, size1);
		System.arraycopy(hp.array, 0, mergedarray, size1, size2);

		this.array= mergedarray;

		return buildHeap(mergedarray,newsize,this.isitMax);


	}








  /**
   * gets element of heap at certain index
   * @param index-gets element at this index
   */
	public T get(int index){
		T element= array[index];
		return element;



	}

}
