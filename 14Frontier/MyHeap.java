import java.util.*;
public class MyHeap<T extends Comparable<T>>{
    private int length;
    public T[] heap;
    public boolean isMax;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (T[]) new Comparable[10];
	isMax = true;
    }
    
    @SuppressWarnings("unchecked")
    public MyHeap(boolean ya){
	if(ya == true){
	    isMax = true;
	}
	else{
	    isMax = false;
	}
	heap = (T[])new Comparable[10];
    }
    
    public void add(T s){
	if(length == heap.length){
	    resize();
	}
	
	heap[length] = s;
	int ind = length;
	if(isMax){
	    while(((ind - 1) / 2 >= 0) && heap[(ind - 1)/2].compareTo(heap[ind]) < 0){
		T temp = heap[ind];
		heap[ind] = heap[(ind - 1) / 2];
		heap[(ind - 1) / 2] = temp;
		ind = (ind - 1) / 2;
		//	length ++;
	    }
	}
	else{
	     while(((ind - 1) / 2 >= 0) && heap[(ind - 1)/2].compareTo(heap[ind]) > 0){
		T temp = heap[ind];
		heap[ind] = heap[(ind - 1) / 2];
		heap[(ind - 1) / 2] = temp;
		ind = (ind - 1) / 2;
	     }
	}
	length ++;
    }

    public T remove(){
	T res = heap[0];
	heap[0] = heap[length - 1];
	heap[length - 1] = null;
	int ind = 0;
	length = length - 1;
	if(isMax){
	    
	    while(((ind * 2) + 1 < length) && (ind * 2) + 2 < length){
		 if((heap[ind].compareTo(heap[(ind * 2) + 1]) >= 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) >= 0)){
		     return res;
		 }
		 if((heap[ind].compareTo(heap[(ind * 2) + 1]) < 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 1];
		    heap[(ind * 2) + 1] = temp;
		    ind = (ind * 2) + 1;
		}
		 else if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 2];
		    heap[(ind * 2) + 2] = temp;
		    ind = (ind * 2) + 2;
		 }
		 else{
		     //	if((heap[ind].compareTo(heap[(ind * 2) + 1]) < 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    if(heap[(ind * 2) + 1].compareTo(heap[(ind * 2) + 2]) >= 0){
			T temp = heap[ind];
			heap[ind] = heap[(ind * 2) + 1];
			heap[(ind * 2) + 1] = temp;
			ind = (ind * 2) + 1;
		    }
		    else{
			 T temp = heap[ind];
			 heap[ind] = heap[(ind * 2) + 2];
			 heap[(ind * 2) + 2] = temp;
			 ind = (ind * 2) + 2;
		    }
		}
	    }
	
	    while(((ind * 2) + 1 < length) && (ind * 2) + 2 >= length){
	       	if((heap[ind].compareTo(heap[(ind * 2) + 1])) < 0){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 1];
		    heap[(ind * 2) + 1] = temp;
		    ind = (ind * 2) + 1;
		}
		else{
		    return res;
		}
	    }
	     while(((ind * 2) + 1 >= length) && (ind * 2) + 2 < length){
		 if((heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 2];
		    heap[(ind * 2) + 2] = temp;
		    ind = (ind * 2) + 2;
		    
		 }
		 else{
		     return res;
		 }
	     }
	}


	else{
	     while(((ind * 2) + 1 < length) && (ind * 2) + 2 < length){
		 if((heap[ind].compareTo(heap[(ind * 2) + 1]) <= 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) <= 0)){
		     return res;
		 }
		 if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 1];
		    heap[(ind * 2) + 1] = temp;
		    ind = (ind * 2) + 1;
		    //  System.out.println(heap);
		}
		 
		 else  if((heap[ind].compareTo(heap[(ind * 2) + 1]) < 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 2];
		    heap[(ind * 2) + 2] = temp;
		    ind = (ind * 2) + 2;
		    //  System.out.println(heap);
		 }
		 
		 //	  if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		 else{
		     
		    if(heap[(ind * 2) + 1].compareTo(heap[(ind * 2) + 2]) <= 0){
			T temp = heap[ind];
			heap[ind] = heap[(ind * 2) + 1];
			heap[(ind * 2) + 1] = temp;
			ind = (ind * 2) + 1;
		    }
		    else{
			 T temp = heap[ind];
			 heap[ind] = heap[(ind * 2) + 2];
			 heap[(ind * 2) + 2] = temp;
			 ind = (ind * 2) + 2;
		    }
		 }
		 
		 //	 System.out.println("ihae");
	     }
	     // ind = 0;
	      while(((ind * 2) + 1 >= length) && (ind * 2) + 2 < length){
 		  if((heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 2];
 		    heap[(ind * 2) + 2] = temp;
 		    ind = (ind * 2) + 2;
		  
		  }
		  else{
		      return res;
		  }
		  
		  //  System.out.println("yabb");
	      }
	      //   ind = 0;
 	       while(((ind * 2) + 1 < length) && (ind * 2) + 2 >= length){
		   if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0)){
		    T temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 1];
		    heap[(ind * 2) + 1] = temp;
		    ind = (ind * 2) + 1;
		   }
		   else{
		       return res;

		   
		   }
	       }
	
	}
    

	return res;
	}
			



	
    public String toString(){
	String ans = "";
	for(int i = 0; i < heap.length - 1; i ++){
	    ans += heap[i] + " ";
	}
	return ans + heap[heap.length - 1];
}

    @SuppressWarnings("unchecked")
    public void resize(){
	T[] heap2 = (T[]) new Comparable[heap.length * 2];
	for(int i = 0; i < length; i ++){
	    heap2[i] = heap[i];
	}
	heap = heap2;
    }
    
    public int size(){
	return length;
    }
    
    public T peek(){
	return heap[0];
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
	MyHeap<String> ab = new MyHeap<>(true);
		/* ab.add(1);
		ab.add(5);
		ab.add(21);
	       	ab.add(21);
	//	ab.add("bc");
	//  ab.add("ac");
	//	  ab.remove();
	  ab.add(25);
	    ab.add(27);
	 	  ab.add(28);
		  ab.add(27);
		 ab.add(27);
		  ab.add(27);
		//  ab.remove();
	    ab.add(29);
	    ab.add(21);
	    ab.add(24);
	    ab.add(23);
	    ab.add(1);
	    ab.add(0);
	    ab.add(0);
	    ab.add(0);
	    //  System.out.println(ab);
	       ab.remove();
	   // System.out.println(ab);
	     ab.remove();
	    	ab.remove();
	      ab.remove();
	    	  ab.remove();
		  	  ab.remove();
		    ab.remove();
		  	  ab.remove();
		   ab.remove(); */
	System.out.println(ab.toString());
}
}

    

    
