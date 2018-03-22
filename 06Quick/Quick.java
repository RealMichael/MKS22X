public class Quick{
       	
    public static int partition(int[] data,int start, int end){
	int lo = start + 1;
	int hi = end; 
	int rando = start + (int)(Math.random() * (((end) - start) + 1));
	int v1 = data[rando];
	data[rando] = data[start];
	data[start] = v1;
	while(lo <= hi){
	    if(data[lo] < v1){
		lo ++;
	    }
	    else{
		int swapper = data[hi];
		data[hi] = data[lo];
		data[lo] = swapper;
		hi --;
	    }
	    
	}
	
	int pivotSwap = data[hi];
	data[hi] = data[start];
	data[start] = pivotSwap;

	String result = "";
	for(int i = 0; i < data.length; i ++){
	    result += data[i] + " ";
	}
	//	System.out.print(result);
	//	System.out.print(rando);


	return hi;


    }

    public static int[] partitionD(int[] data,int start, int end){
	int lo = start;
	int hi = end;
	int i = start;
	int rando = start + (int)(Math.random()*(((end) - start) + 1));
	int piv = data[rando];
	while(i <= hi){
	    if(data[i] == piv){
		i ++;
	    }
	    else if(data[i] > piv){
		int te = data[i];
		data[i] = data[hi];
		data[hi] = te;
		hi --;
	    }
	    else{
		int pe = data[i];
		data[i] = data[lo];
		data[lo] = pe;
		lo ++;
		i ++;
	    }
	}
	int[] values = new int[2];
	values[0] = lo;
	values[1] = hi;
	return values;
    }
	       


    
    public static int quickselect(int[] data, int k){
	return quickselect(data,k,0,data.length - 1);
    }

    public static int quickselect(int[] data, int k, int start,int end){
	
	int[] v2 = partitionD(data,start,end);
	try{
	if(v2[0] == k){
	    return data[v2[1]];
	}
	if(v2[0] > k){
	    return quickselect(data,k,start,v2[0]);
	}
	if(v2[0] < k){
	    return quickselect(data,k,v2[1],end);
	}
	}
	catch(ArrayIndexOutOfBoundsException e){}
	//	System.out.println(toString(data));
	return 1;
    }
    

    public static String toString(int[] data){
	String result = "";
	for(int i = 0; i < data.length; i ++){
	    result += data[i] + " ";
	}
	return result;
    }
    
    public static void quicksort(int[] ary){
	quicksort(ary,0,ary.length - 1);
    }
    
    public static void quicksort(int[] ary, int start, int end){

	    while(start < end){
	    int[] v1 = partitionD(ary,start,end);
	    
	    //Sort both left and right to partition
	     
	    quicksort(ary,start,v1[0] - 1);
	    start ++;
	    quicksort(ary,v1[1] + 1, end);
        	end --;
	   
	}
    }
	    


    
    public static void main(String[] args){
	int[] tester = new int[] {2,10,15,23,0,0,5,99,5352,1,1,1,1,2,2};
	//	System.out.println(quickselect(tester,5));
	//	System.out.println(quickselect(tester,0));
	//	System.out.println(quickselect(tester,1));
	//	System.out.println(quickselect(tester,2));
	//	System.out.println(quickselect(tester,3));
	//	System.out.println(quickselect(tester,4));
	//	System.out.println(quickselect(tester,2));
		quicksort(tester);
	System.out.println(toString(tester));
		

}
}
    
