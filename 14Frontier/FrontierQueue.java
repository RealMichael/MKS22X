import java.util.*;
import java.util.LinkedList;

public class FrontierQueue implements Frontier{
    private LinkedList<Location> store;
    
    @SuppressWarnings("unchecked")
	public FrontierQueue(){
	store = new LinkedList<>();
    }

    public void add(Location n){
	store.addLast(n);
    }
    
    public Location next(){
	return store.removeFirst();
    }
    
    public boolean hasNext(){
	if(store.size() == 0){
	    return false;
	}
	return true;
    }
}
	
	    

 