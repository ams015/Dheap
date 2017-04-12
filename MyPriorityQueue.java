package hw6;


/**
 * class for priority queue
 * is a 2-min heap
 * @author Aman Singh
 *
 * @param <T>
 */
public class MyPriorityQueue<T extends Comparable <? super T>>{
	private dHeap<T>  priorityqueue ;
	 
	
	/**
	 * Constructor priority queue, used 2-min heap
	 * @param size
	 */
	public MyPriorityQueue(int size){
		priorityqueue = new dHeap<T>(size,false );
	}
	
	/**
	 * poll removes element from the priorityqueue
	 * @return the value of the removed node
	 */
	public T poll(){
		T tmp;

		//if the priority queue is empty,return null
		if(priorityqueue.size()==0){
			return null;
		}

		tmp =(T)priorityqueue.remove();

		return tmp;
		 
		
	}
	
	
	
	/**
	 * add adds an element to priority queue
	 * @param data
	 */
	public void  add(T data){
	
	    //if the data is null, return a nullpointer
		if(data==null){
			throw new NullPointerException();
		}
		
		
		priorityqueue.add(data);
		
	}
	

	/**
	 *gets the size of the priorityqueue
	 *
	 */
	public int getSize(){
		return  priorityqueue.size();
	}
	
}
