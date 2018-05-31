import java.util.*;
import java.util.Stack;

public class FrontierStack implements Frontier{
    private Stack<Location> store;

    @SuppressWarnings("unchecked")
    public FrontierStack(){
	store = new Stack<>();
    }
    public void add(Location n){
	store.push(n);
    }

    public Location next(){
	return store.pop();
    }

    public boolean hasNext(){
	if(store.size() == 0){
	    return false;
	}
	return true;
    }
}