
// ***********************
// NAME: Aman Singh
// ID: A11012283
// LOGIN: cs12sgb
// ***********************

package hw6;

import static org.junit.Assert.assertEquals;



import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests dHeap class
 * @author Aman Singh
 *
 */
public class dHeapTester {

	private dHeap<Integer> minempty ;
	private dHeap<Integer> minone ;
	private dHeap<Integer> minseveral ;

	private dHeap<Integer> minseveral2 ;
	private dHeap<Integer> minseveral3 ;
	private dHeap<String>  minslist ;

	private dHeap<Integer> maxempty ;
	private dHeap<Integer> maxone ;
	private dHeap<Integer> maxseveral ;

	private dHeap<Integer> maxseveral2 ;
	private dHeap<Integer> maxseveral3 ;
	private dHeap<String>  maxslist ;
	private dHeap<Integer> empty ;
	private dHeap<Integer> one ;
	private dHeap<Integer> several ;
	private dHeap<String>  slist ;

	private dHeap<Integer> minempty_3 ;
	private dHeap<Integer> minone_3 ;
	private dHeap<Integer> minseveral_3 ;

	private dHeap<Integer> minseveral2_3 ;
	private dHeap<Integer> minseveral3_3 ;
	private dHeap<String>  minslist_3 ;

	private dHeap<Integer> m1;
	private dHeap<Integer> m2;
	private dHeap<Integer> m3;
	private dHeap<Integer> m4;

	@Before
	/**
	 * sets up before each test
	 */
	public void setUp()
	{ 

		Integer[] array01= {new Integer(10),new Integer(20),new Integer(40),new Integer(60),new Integer(80)};
		Integer[] array02= {new Integer(5),new Integer(2),new Integer(100),new Integer(20),new Integer(10)};

		m1= new dHeap<Integer>(10,false);
		m2= new dHeap<Integer>(10,false);
		m3= new dHeap<Integer>(10,true);
		m4= new dHeap<Integer>(10,true);


		minempty= new dHeap<Integer>() ;
		minone =new dHeap<Integer>();
		minseveral= new dHeap<Integer>();
		minseveral2= new dHeap<Integer>();
		minslist =new dHeap<String>() ;
		minseveral3= new dHeap<Integer>();

		minempty_3= new dHeap<Integer>(10,false,3) ;
		minone_3 =new dHeap<Integer>(10,false,3);
		minseveral_3= new dHeap<Integer>(10,false,3);
		minseveral2_3= new dHeap<Integer>(10,false,3);
		minslist_3 =new dHeap<String>(10,false,3) ;
		minseveral3_3= new dHeap<Integer>(10,false,3);

		maxempty= new dHeap<Integer>(3,true) ;
		maxone =new dHeap<Integer>(120,true);
		maxseveral= new dHeap<Integer>(100,true);
		maxseveral2= new dHeap<Integer>(100,true);
		maxslist =new dHeap<String>(100,true) ;
		maxseveral3= new dHeap<Integer>(100,true);
		int array1[] ={10,50,20,5};
		//int array2[] ={10,50,20,5,25, 30,60,100,600,30};

		minone.add( new Integer(5));
		maxone.add( new Integer(5));
		minone_3.add(new Integer(5));
		for (int i = 0; i<5; i++){
			minseveral.add(i);
			maxseveral.add(i);
			minseveral_3.add(i);
		}


		for (int i = 0; i<array01.length;i++){
			m1.add(array01[i]);
			m2.add(array02[i]);
			m3.add(array01[i]);
			m4.add(array02[i]);

		}

		for (int i = 10; i>0; i--){
			minseveral2.add(i);
			maxseveral2.add(i);;
			minseveral2_3.add(i);
		}
		for(int i=0;i>array1.length;i++){
			minseveral3.add(array1[i]);
			maxseveral3.add(array1[i]);
			minseveral3_3.add(array1[i]);
		}
	}

	@Test
	/**
	 * tests the size() method which gets the size of the queue.
	 */
	public void testSize(){

		assertEquals("Check Empty Size",0,minempty.size());

		assertEquals("Check minone",1,minone.size());

		assertEquals("Check size",5,minseveral.size());

		assertEquals("Check  Size",10,minseveral2.size());
		assertEquals("Check Empty Size",0,maxempty.size());

		assertEquals("Check minone",1,maxone.size());

		assertEquals("Check size",5,maxseveral.size());

		assertEquals("Check  Size",10,maxseveral2.size());


		assertEquals("Check Empty Size",0,minempty_3.size());

		assertEquals("Check minone",1,minone_3.size());

		assertEquals("Check size",5,minseveral_3.size());
	}
	
	
	@Test
	/**
	 * tests the add() method which adds an element
	 * 
	 */
	public void testAdd(){
		
		
		int x;
		int array3[] ={10,50,20,5,25, 30,60};
		for(int i = 0;i<array3.length;i++){
			x = array3[i];
			maxempty.add(x);
			minempty.add(x);
		}


		assertEquals("Check inside",new Integer(60),maxempty.get(0));
		assertEquals("Check inside",new Integer(25),maxempty.get(1));
		assertEquals("Check inside",new Integer(50),maxempty.get(2));
		assertEquals("Check inside",new Integer(5),maxempty.get(3));
		assertEquals("Check inside",new Integer(10),maxempty.get(4));
		assertEquals("Check inside",new Integer(20),maxempty.get(5));
		assertEquals("Check inside",new Integer(30),maxempty.get(6));


		assertEquals("Check inside",new Integer(5),minempty.get(0));
		assertEquals("Check inside",new Integer(10),minempty.get(1));
		assertEquals("Check inside",new Integer(20),minempty.get(2));
		assertEquals("Check inside",new Integer(50),minempty.get(3));
		assertEquals("Check inside",new Integer(25),minempty.get(4));
		assertEquals("Check inside",new Integer(30),minempty.get(5));
		assertEquals("Check inside",new Integer(60),minempty.get(6));


		minslist.add("zobb");
		minslist.add("abba");
		minslist.add("bobb");

		assertEquals("Check inside","abba",minslist.get(0));
		assertEquals("Check inside","zobb",minslist.get(1));
		assertEquals("Check inside","bobb",minslist.get(2));


	}
 
	@Test
	/**
	 * tests the remove method, which removes the root
	 */
	public void testRemove(){

		try{
			minempty.remove();
		}
		catch(NoSuchElementException e){

		}
		//test min heap with one element
		assertEquals("remove root" ,new Integer(5),minone.remove());

		//test min heap
		assertEquals("remove root" ,new Integer(0),minseveral.remove());
		assertEquals("remove root" ,new Integer(1),minseveral.remove());
		assertEquals("remove root" ,new Integer(2),minseveral.remove());
		assertEquals("remove root" ,new Integer(3),minseveral.remove());
		assertEquals("remove root" ,new Integer(4),minseveral.remove());

		//test max heap

		assertEquals("remove root" ,new Integer(4),maxseveral.remove());
		assertEquals("remove root" ,new Integer(3),maxseveral.remove());
		assertEquals("remove root" ,new Integer(2),maxseveral.remove());
		assertEquals("remove root" ,new Integer(1),maxseveral.remove());
		assertEquals("remove root" ,new Integer(0),maxseveral.remove());

		//test 3-min heap
		assertEquals("remove root" ,new Integer(0),minseveral_3.remove());
		assertEquals("remove root" ,new Integer(1),minseveral_3.remove());
		assertEquals("remove root" ,new Integer(2),minseveral_3.remove());
		assertEquals("remove root" ,new Integer(3),minseveral_3.remove());
		assertEquals("remove root" ,new Integer(4),minseveral_3.remove());










	}

	@Test
	/**
	 * tests the remove method, which removes the root
	 */
	public void testMerge(){




		//	System.out.println(m1);
		//merge 2 min heaps
		dHeap<Integer> three=  m1.merge(m2, false);

		//merge 2 max heaps
		dHeap<Integer> m5=  m3.merge(m4, true);


		assertEquals("Check inside",new Integer(2),three.get(0));
		assertEquals("Check inside",new Integer(10),three.get(1));
		assertEquals("Check inside",new Integer(5),three.get(2));
		assertEquals("Check inside",new Integer(20),three.get(3));
		assertEquals("Check inside",new Integer(20),three.get(4));
		assertEquals("Check inside",new Integer(40),three.get(5));
		assertEquals("Check inside",new Integer(10),three.get(6));
		assertEquals("Check inside",new Integer(100),three.get(7));
		assertEquals("Check inside",new Integer(60),three.get(8));
		assertEquals("Check inside",new Integer(80),three.get(9));

		


		assertEquals("Check inside",new Integer(100),m5.get(0));
		assertEquals("Check inside",new Integer(60),m5.get(1));
		assertEquals("Check inside",new Integer(80),m5.get(2));
		assertEquals("Check inside",new Integer(10),m5.get(3));
		assertEquals("Check inside",new Integer(40),m5.get(4));
		assertEquals("Check inside",new Integer(20),m5.get(5));
		assertEquals("Check inside",new Integer(20),m5.get(6));
		assertEquals("Check inside",new Integer(5),m5.get(7));
		assertEquals("Check inside",new Integer(2),m5.get(8));
		assertEquals("Check inside",new Integer(10),m5.get(9));
		



	}




}
