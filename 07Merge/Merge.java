
public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];		
	msort(data,temp,0,data.length - 1);
	
    }

    

    private static void msort(int[] data,int[] temp,int lo, int hi){
        
	if(lo >= hi){
	    return;
	}		
	for(int i = 0; i <= data.length - 1; i ++){
	    temp[i] = data[i];
	}
	
	int mid =  (lo + hi) / 2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid + 1,hi);
	merge(data,temp,lo,mid,hi);
	
    }
     		    
    public static void merge(int[] data,int[] temp, int lo, int mid,int hi){

	int i = lo;
	int sub = mid + 1;
       	boolean determiner = false;
	while(lo  <= mid && sub  <= hi)  {
	    if(temp[lo] <= temp[sub]){
		data[i] = temp[lo];
		lo ++;
	    }
	    else{
		data[i] = temp[sub];
		sub ++;
	    }
	    i ++;
	}
	
	if(mid - lo <= 0){
	    determiner = false;
	}
	if(hi - sub <= 0){
	    determiner = true;
	}
	

	
	if(determiner){
	    for(int x = lo; x <= mid; x ++){
		data[i] = temp[x];
		i ++;
	    }
	}
	else{
	    for(int y = sub; y <= hi ; y ++){
		data[i] = temp[y];
		i ++;
	    }
	}

    }

	
    
    public static String toString(int[] data){
	String result = "";
	for(int i = 0; i < data.length; i ++){
	    result += data[i] + " ";
	}
	return result;
    }
    /*  
    public static void main(String[] args){
	int[] tester = new int[] {3,2,1,853,7,54,11,76,865,999};
       	mergesort(tester);
	System.out.println(toString(tester));
    }
}
    	    
    */
}