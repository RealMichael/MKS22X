import java.util.*;
public class MyHeap{
    private int length;
    public String[] heap;
    public boolean isMax;
    public MyHeap(){
	heap = new String[10];
	isMax = true;
    }

    public MyHeap(boolean ya){
	if(ya == true){
	    isMax = true;
	}
	else{
	    isMax = false;
	}
	heap = new String[10];
    }
    
    public void add(String s){
	if(length == heap.length){
	    resize();
	}
	
	heap[length] = s;
	int ind = length;
	if(isMax){
	    while(((ind - 1) / 2 >= 0) && heap[(ind - 1)/2].compareTo(heap[ind]) < 0){
		String temp = heap[ind];
		heap[ind] = heap[(ind - 1) / 2];
		heap[(ind - 1) / 2] = temp;
		ind = (ind - 1) / 2;
		//	length ++;
	    }
	}
	else{
	     while(((ind - 1) / 2 >= 0) && heap[(ind - 1)/2].compareTo(heap[ind]) > 0){
		String temp = heap[ind];
		heap[ind] = heap[(ind - 1) / 2];
		heap[(ind - 1) / 2] = temp;
		ind = (ind - 1) / 2;
	     }
	}
	length ++;
    }

    public String remove(){
	String res = heap[0];
	heap[0] = heap[length - 1];
	heap[length - 1] = null;
	int ind = 0;
	length = length - 1;
	if(isMax){
	    while(((ind * 2) + 1 < length) && (ind * 2) + 2 < length){
		if((heap[ind].compareTo(heap[(ind * 2) + 1]) < 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		    String temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 1];
		    heap[(ind * 2) + 1] = temp;
		    ind = (ind * 2) + 1;
		}
	       	if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    String temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 2];
		    heap[(ind * 2) + 2] = temp;
		    ind = (ind * 2) + 2;
		}
	       	if((heap[ind].compareTo(heap[(ind * 2) + 1]) < 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    if(heap[(ind * 2) + 1].compareTo(heap[(ind * 2) + 2]) >= 0){
			String temp = heap[ind];
			heap[ind] = heap[(ind * 2) + 1];
			heap[(ind * 2) + 1] = temp;
			ind = (ind * 2) + 1;
		    }
		    else{
			 String temp = heap[ind];
			 heap[ind] = heap[(ind * 2) + 2];
			 heap[(ind * 2) + 2] = temp;
			 ind = (ind * 2) + 2;
		    }
		}
	    }
	   //  while(((ind * 2) + 1 < length) && (ind * 2) + 2 >= length){
// 	       	if((heap[ind].compareTo(heap[(ind * 2) + 1])) < 0){
// 		    String temp = heap[ind];
// 		    heap[ind] = heap[(ind * 2) + 1];
// 		    heap[(ind * 2) + 1] = temp;
// 		    ind = (ind * 2) + 1;
// 		}
// 	    }
// 	     while(((ind * 2) + 1 >= length) && (ind * 2) + 2 < length){
// 		 if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0)){
// 		    String temp = heap[ind];
// 		    heap[ind] = heap[(ind * 2) + 2];
// 		    heap[(ind * 2) + 2] = temp;
// 		    ind = (ind * 2) + 2;
		    
// 		 }
// 	     }
	}
	else{
	     while(((ind * 2) + 1 < length) && (ind * 2) + 2 < length){
		 if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) < 0)){
		    String temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 1];
		    heap[(ind * 2) + 1] = temp;
		    ind = (ind * 2) + 1;
		}
		 
		 else  if((heap[ind].compareTo(heap[(ind * 2) + 1]) < 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		    String temp = heap[ind];
		    heap[ind] = heap[(ind * 2) + 2];
		    heap[(ind * 2) + 2] = temp;
		    ind = (ind * 2) + 2;
		 }
		 
		 //	  if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0) && (heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
		 else{
		    if(heap[(ind * 2) + 1].compareTo(heap[(ind * 2) + 2]) <= 0){
			String temp = heap[ind];
			heap[ind] = heap[(ind * 2) + 1];
			heap[(ind * 2) + 1] = temp;
			ind = (ind * 2) + 1;
		    }
		    else{
			 String temp = heap[ind];
			 heap[ind] = heap[(ind * 2) + 2];
			 heap[(ind * 2) + 2] = temp;
			 ind = (ind * 2) + 2;
		    }
		 }
	     }
	     //  while(((ind * 2) + 1 >= length) && (ind * 2) + 2 < length){
// 		  if((heap[ind].compareTo(heap[(ind * 2) + 2]) > 0)){
// 		    String temp = heap[ind];
// 		    heap[ind] = heap[(ind * 2) + 2];
// 		    heap[(ind * 2) + 2] = temp;
// 		    ind = (ind * 2) + 2;
		  
// 		   }
// 	      }
// 	       while(((ind * 2) + 1 < length) && (ind * 2) + 2 >= length){
// 		   if((heap[ind].compareTo(heap[(ind * 2) + 1]) > 0)){
// 		    String temp = heap[ind];
// 		    heap[ind] = heap[(ind * 2) + 1];
// 		    heap[(ind * 2) + 1] = temp;
// 		    ind = (ind * 2) + 1;
// 		   }
// 	       }
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
    public void resize(){
	String[] heap2 = new String[heap.length * 2];
	for(int i = 0; i < length; i ++){
	    heap2[i] = heap[i];
	}
	heap = heap2;
    }
    
    public int size(){
	return length;
    }
    
    public String peek(){
	return heap[0];
    }
	
    /*
    public static void main(String[] args){
	MyHeap ab = new MyHeap(true);
	ab.add("ab");
	//	ab.add("bc");
	//  ab.add("ac");
	  ab.remove();
	  ab.add("zdgsh");
	System.out.println(ab.toString());
}
}
    */
}