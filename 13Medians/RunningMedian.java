public class RunningMedian{
    private MyHeap<Double> min;
    private MyHeap<Double> max;
    private int length;

    public RunningMedian(){
	min = new MyHeap<>(false);
	max = new MyHeap<>();
    }

    public void rebalance(MyHeap<Double> remover, MyHeap<Double> adder){
	Double temp = remover.peek();
	remover.remove();
	adder.add(temp);
    }

    public int size(){
	return length;
    }
	
    
    public void add(Double ele){
	if(min.size() == 0 && max.size() == 0){
	    max.add(ele);
	}
	
	
