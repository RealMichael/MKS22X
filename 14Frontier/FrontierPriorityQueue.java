public class FrontierPriorityQueue implements Frontier{
	private MyHeap<Location> store;
	
	public FrontierPriorityQueue(){
		store = new MyHeap<>(false);
	}
	public void add(Location ab){
		store.add(ab);
	}
	
	public Location next(){
		return store.remove();
	}
	
	public boolean hasNext(){
		if(store.size() == 0){
				return false;
		}
		else{
			return true;
		}
	}
}