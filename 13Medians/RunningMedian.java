import java.lang.*;
import java.util.*;
public class RunningMedian{
    private MyHeap<Double> min;
    private MyHeap<Double> max;
    private int length;

    public RunningMedian(){
	min = new MyHeap<>(true);
	max = new MyHeap<>(false);
    }

    public void rebalance(MyHeap<Double> remover, MyHeap<Double> adder){
	Double temp = remover.peek();
	remover.remove();
	adder.add(temp);
    }

    public int size(){
	return length;
    }
	
    public void addMin(Double ele){
	min.add(ele);
    }

    public void addMax(Double ele){
	max.add(ele);
    }
	
    public void removeMin(){
	min.remove();
    }
    
    public void removeMax(){
	max.remove();
    }
    public void add(Double ele){
// 	if(ele == 0.0){
// 	    if(ele > getMedian()){
// 		max.add(ele);
// 	    }
// 	    else{
// 		min.add(ele);
// 	    }
// 	    return;
// 	}
	if(min.size() == 0 && max.size() == 0){
	    max.add(ele);
	}
	else if(min.size() == 0 && max.size() > 0){
	    if(ele < max.peek()){
		min.add(ele);
	    }
	    else{
		max.add(ele);
	    }
	}
	else if(min.size() > 0 && max.size() == 0){
	    if(ele > min.peek()){
		max.add(ele);
	    }
	    else{
		min.add(ele);
	    }
	}
	

        else if(ele > getMedian()){
	    max.add(ele);
	}
	else{
	    min.add(ele);
	}
       	if(Math.abs(min.size() - max.size()) > 1){
	    if(min.size() > max.size()){
		    rebalance(min,max);
		}
		else{
		    rebalance(max,min);
		}
		    
	}
	length ++;
    }

    public Double getMedian(){
	if(min.size() == 0 && max.size() == 0){
	    throw new NoSuchElementException();
	}
	if(min.size() > 0 && max.size() == 0){
	    return min.peek();
	}
	else if(min.size() == 0 && max.size() > 0){
	    return max.peek();
	}
	if(min.size() == max.size()){
	    return ((min.peek() + max.peek())/2);
	}
	else{
	    if(min.size() > max.size()){
		return min.peek();
	    }
	    else{
		return max.peek();
	    }
	}
    }

    public String toString(){
	String res = "Min:";
	//	for(int i = 0; i < min.size(); i ++){
	res += min.toString();
		//	}
	res += "\n";
	res += "Max:";
	//	for(int i = 0; i < max.size(); i ++){
	res += max.toString();
	return res;
	    //	}
    }
}
    /*
    public static void main(String[] args){
	RunningMedian ab = new RunningMedian();
	//	ab.add(24.0);
		ab.add(0.0);
				ab.add(0.0);
		ab.add(0.0);
		ab.add(0.0);

       	ab.add(20.0);
	ab.add(19.0);
		ab.add(49.0);
	//	ab.add(21000.0);
	//	ab.add(21.0);
		ab.add(15.0);
			ab.add(13.0);
			ab.add(0.0);
			ab.add(0.0);
			ab.add(0.0);
			ab.add(21.0);
			ab.add(245.0);
			ab.add(21.5334);
			ab.add(0.0);
			ab.add(0.0);
			ab.add(0.0);
			ab.add(21.0);
			ab.add(21.0);
			ab.add(10.0);
			ab.add(5.0);

	//	ab.removeMax();
	System.out.println(ab.getMedian());
	System.out.println(ab.toString());
    }
}
    */  
	    
	
	
