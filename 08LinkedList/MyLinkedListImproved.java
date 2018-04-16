import java.util.*;
import java.io.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
     private Node first, last;
    private int length;
    
    public MyLinkedListImproved(){
	
    }
    
    public int size(){
	return length;
    }
    
   
    
    public String toString(){
	String result = "[";
	Node res = first;
	int i = 0;
	while(i < length - 1){
	    result += res.getValue() + ",";
	    res = res.getNext();
	    i ++;
	}
	result += last.getValue();
	result += "]";
	return result;
    }
    


	    
    public T get(int index){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node res = first;
	int i = 0;
	while(i < index){
	    res = res.getNext();
	    i ++;
	}
	return res.getValue();
    }
    
    public Node getNode(int index){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node res = first;
	int i = 0;
	while(i < index){
	    res = res.getNext();
	    i ++;
	}
	return res;
    }
    




    public void clear(){
	last = null;
	first = null;
	length = 0;
    }
    
    
    public T set(int index, T value){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	T old = getNode(index).getValue();
	getNode(index).setValue(value);
	return old;
    }
   
    public int indexOf(T value){
	int i = 0;
	Node res = first;
	while(i < length){
	    if(res.getValue().equals(value)){
		return i;
	    }
	    res = res.getNext();
	    i ++;
	}
	return -1;
    }
    
    public boolean add(T value){
	Node res = new Node(value);
	if(length == 0){
	    last = new Node(value);
	    first = last;
	    length ++;
	}
	else{
	    last.setNext(res);
	    res.setPrev(last);
	    last = res;
	    length ++;
	}
	return true;
    }
    public void add(int index, T value){
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	
	if(index == length){
	    add(value);
	}



	else if(index == 0){
	    Node ab = new Node(value);
	    Node ab2 = getNode(0);
	    ab.setNext(ab2);
	    ab2.setPrev(ab);
	    first = ab;
	    length ++;
	}
	    
	    

	else{
    
	Node res = new Node(value);
	Node res2 = getNode(index);
	res2.setPrev(res);
	res.setNext(res2);
	res.setPrev(getNode(index - 1));
	getNode(index - 1).setNext(res);
	length ++;
	//	res2.setPrev(res);
	
    }
	
    }

    public T remove(int index){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node ba = getNode(index);
	if(index == 0){
	    first = getNode(index + 1);
	    first.setPrev(null);
	    length --;
	    
	}
	    
	else if(index == size() - 1){
	    last = getNode(index - 1);
	    last.setNext(null);
	    length --;
	    
	}
	
	else{
	     Node res = getNode(index - 1);
	     Node res2 = getNode(index + 1);
	     res.setNext(res2);
	     res2.setPrev(res);
	     length --;
	     
	}
	return ba.getValue();
    }

	
    public boolean remove(T value){
	int i = 0;
	Node res = getNode(0);
	while(i < size()){
	    if(res.getValue() == value){
		remove(i);
		return true;
	    }
		res = res.getNext();
		i ++;
	}
    
	return false;
    }
    
    public int min(){
	int res = 0;
	int i = 0;
	if(this.size() == 0){
	    return -1;
	}
	else{
	    T compar = first.getValue();
	    //   int res = 0;
	    //  int i = 0;
	    for(T eachNode: this){
		if(eachNode.compareTo(compar) < 0){
		    compar = eachNode;
		    res = i;
		}
		i ++;
	    }
	}
	    return res;
    }

    public int max(){
	int res = 0;
	int i = 0;
	if(this.size() == 0){
	    return -1;
	}
	else{
	    T compar = first.getValue();
	    // int res = 0;
	    //	  int  i = 0;
	    for(T eachNode : this){
		if(eachNode.compareTo(compar) > 0){
		    compar = eachNode;
		    res = i;
		}
		i ++;
	    }
	}
	return res;
    }

     public void extend(MyLinkedListImproved<T> other){
	 Node lastOther = other.last;
	 (other.first).setPrev(last);
	 last.setNext(other.first);
	 last = lastOther;
	 length += other.size();
	 other.clear();
     }
    
       

    public Iterator<T> iterator(){
	return new LLIterator(first);
    }

	    

   
    private class Node{
	private Node next, prev;
	private T data;

	public Node(T data){
	    this.data = data;
	    
	}

	public Node getNext(){
	    return next;
	}

	public Node getPrev(){
	    return prev;
	}

	public T getValue(){
	    return data;
	}

	public String toString(){
	    String result = "";
	    result += getValue();
	    return result;
	}
	
	public void setNext(Node val){
	    next = val;
	}

	public void setPrev(Node val2){
	    prev = val2;
	}

	public void setValue(T val3){
	    data = val3;
	}
    }
    
    public class LLIterator implements Iterator<T>{
	public Node curNode;

	public LLIterator(Node yab){
	    curNode = yab;
	}
	
	public boolean hasNext(){
	    if (curNode == null){
		return false;
	    }
	    return true;
	}

	public T next(){
	   
	    
	    if(hasNext() == true){
	    T res = curNode.getValue();
	    curNode = curNode.getNext();
	    return res;
	    }
	      else{
	    	throw new NoSuchElementException();
	    	    }
	}
	  
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
	a.add(1);
	a.add(2);
	a.add(5);
	b.add(6);
	b.add(4);
	b.add(3);
      	System.out.println(a.toString());
       	System.out.println(b.toString());
	a.extend(b);
	System.out.println(a.toString());
	//	System.out.println(b.toString());
}
}


    

    

     
