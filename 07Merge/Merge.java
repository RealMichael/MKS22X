 import java.util.Arrays;
public class Merge{

  
    
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];	
		for (int i = 0;i < data.length;i++){
	    temp[i] = data[i];
	}
	msort(data,temp,0,data.length - 1);
	
    }

    
    
    private static void msort(int[] data,int[] temp,int lo, int hi){
        
	if(lo >= hi){
	    return;
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
	
	if(sub <= hi){
	    determiner = false;
	}
	if(lo <= mid){
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
     

    mergesort(start);
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
	int[] tester = new int[] {3,2,1,853,7,54,11,76,865,999};
       	mergesort(tester);
	System.out.println(toString(tester));
    }
}
    	    
    */
