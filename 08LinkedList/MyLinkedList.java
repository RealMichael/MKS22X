 import java.util.LinkedList;


public class MyLinkedList{
    private Node first, last;
    private int length;
    
    public MyLinkedList(){
	
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
    


	    
    public Integer get(int index){
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
    
    
    public Integer set(int index, Integer value){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Integer old = getNode(index).getValue();
	getNode(index).setValue(value);
	return old;
    }
   
    public int indexOf(Integer value){
	int i = 0;
	Node res = first;
	while(i < length){
	    if(res.getValue() == value){
		return i;
	    }
	    res = res.getNext();
	    i ++;
	}
	return -1;
    }
    
    public boolean add(Integer value){
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
    public void add(int index, Integer value){
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

    public Integer remove(int index){
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

	
    public boolean remove(Integer value){
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

	    

   
    private class Node{
	private Node next, prev;
	private Integer data;

	public Node(Integer data){
	    this.data = data;
	    
	}

	public Node getNext(){
	    return next;
	}

	public Node getPrev(){
	    return prev;
	}

	public int getValue(){
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

	public void setValue(Integer val3){
	    data = val3;
	}
    }
    


    /*
 public static void main(String[]args){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<Integer> nums2 = new LinkedList<>();
      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,Integer.valueOf(i));
      }
      if(nums.remove(Integer.valueOf(0)) && nums.remove(Integer.valueOf(1)) &&
      nums.remove(Integer.valueOf(5)) && nums.remove(Integer.valueOf(3)) &&
      nums.remove(Integer.valueOf(8))&& nums.remove(Integer.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i).intValue()){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (Integer, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
        nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      }
    }
    
    
    
}

    */
}
 