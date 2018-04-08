import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Quick{
       	
    public static int partition(int[] data,int start, int end){
	int lo = start;
	int hi = end; 
	int rando = start + (int)(Math.random() * (((end) - start) + 1));
	int v1 = data[rando];

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
	int rando = start + (int)(Math.random()*(((end) - start)+ 1 ));
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
	
	/*
	int[] v2 = partitionD(data,start,end);
	
	if(v2[1] == k){
	    return data[k];
	}
	else if(v2[1] < k){
	    return quickselect(data,k,v2[1],end);
	}
	else  (v2[0] < k){
	    return quickselect(data,k,start,v2[0]);
    }
}
*/	

	quicksort(data,start,end);
	return data[k];
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

	    if(start < end){
	    int[] v1 = partitionD(ary,start,end);
	    
	    //Sort both left and right to partition
	     
	    quicksort(ary,start,v1[0] - 1);
	    
	    quicksort(ary,v1[1] + 1, end);
	    
	   
	}
    }
}


 


    /*
    //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static final int EMPTY = 4;

  private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    if(type == EMPTY){
      ans = new int[0];
    }
    return ans;
  }

  public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    
     * Test your sort here!
     
    quicksort(start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
    }else{
      System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
  }
}

/*
    public static void main(String[] args){
	int[] tester = new int[] {2,10,15,23,0,0,5,99,5352,1,1,1,1,2,2};
	//	System.out.println(quickselect(tester,5));
	//	System.out.println(quickselect(tester,0));
	//	System.out.println(quickselect(tester,1));
	//	System.out.println(quickselect(tester,2));
	//  	System.out.println(quickselect(tester,3));
					//	System.out.println(quickselect(tester,4));
			System.out.println(quickselect(tester,2));
	//	quicksort(tester);
					//	System.out.println(toString(tester));
		

}
}
    */



 