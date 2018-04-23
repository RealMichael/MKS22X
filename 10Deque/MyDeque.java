import java.util.*;
public class MyDeque<E>{
    private E[] store;
    private int first,last,len;
    
    
    @SuppressWarnings("unchecked")
	public MyDeque(){
		   store = (E[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
	public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	store = (E[]) new Object[(initialCapacity)];
    }

    public int size(){
	return len;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] store2 = (E[]) new Object[(size() * 2)];
	if(last >= first){
	for(int i = 0; i < store.length; i ++){
	    store2[i] = store[i];
	}
	}
	if(!(last >= first)){
		int i = first;
		int z = 0;
		int ind = 0;
		while(i < store.length){
		    store2[ind] = store[i];
		    i ++;
		    ind ++;
		}
		while(z <= last){
		    store2[ind] = store[z];
		    z ++;
		    ind ++;
		}
	    }
	store = store2;
	first = 0;
	last = size() - 1;
	    }


    
    public void addFirst(E ele){
	if(ele == null){
	    throw new NullPointerException();
	}
	if(len == store.length){
	    resize();
	}
	if(len == 0){
	    store[first] = ele;
	}
	else if(first == 0){
	    first = store.length - 1;
	    store[first] = ele;
	}
	else{
	    first = first - 1;
	    store[first] = ele;
	}
	len ++;
    }
	
    public void addLast(E ele){
	if(ele == null){
	    throw new NullPointerException();
	}
	if(len == store.length){
	    resize();
	}
	if(len == 0){
	    store[last] = ele;
	}
	else if(last == store.length - 1){
	    last = 0;
	    store[last] = ele;
	}
	else{
	    last = last + 1;
	    store[last] = ele;
	}
	len ++;
    }

    public E removeFirst(){
	if(len == 0){
	    throw new NoSuchElementException();
	}
	E res = store[first];
	store[first] = null;
	if(first == store.length - 1){
	    first = 0;
	}
	else{
	    first ++;
	}
	len = len - 1;
	return res;
    }

    public E removeLast(){
	if(len == 0){
	    throw new NoSuchElementException();
	}
	E res = store[last];
	store[last] = null;
	if(last == 0){
	    last = store.length - 1;
	}
	else{
	    last = last - 1;
	}
	len = len - 1;
	return res;
    }
    public E getFirst(){
	if(len == 0){
	    throw new NoSuchElementException();
	}
	return store[first];
    }

    public E getLast(){
	if(len == 0){
	    throw new NoSuchElementException();
	}
	return store[last];
    }
}

