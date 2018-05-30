import java.util.*;

public class Sorts{
    public static void heapsort(int[] data){
	int[] result = new int[data.length];
	MyHeap<Integer> store = new MyHeap<>(false);
	for(int i = 0; i < data.length; i ++){
	    store.add(data[i]);
	}
	
	//	System.out.println(store);

	for(int i = 0; i < data.length; i ++){
	    data[i] = store.remove();
	}
    }
	/*	int counter = data.length;
	while(counter > 0){
	    int remover = store.remove();
	    data[counter - 1] = remover;
	    counter --;
	}
	//	System.out.println(Arrays.toString(result));
	//	data = result;
	//	System.out.println(Arrays.toString(data));
    }
	*/
    /*
    public static void main(String[] args){
	int[] a = new int[]{1,5,21,21,25,27,28,27,27,27,29,21,24,23,1,0,0,0,5,2,2,6,845,225,22532};
	String b = "";
	heapsort(a);
	for(int i = 0; i < a.length; i ++){
	    b += a[i] + " ";
	}
	System.out.println(b);
	//	System.out.println(Arrays.toString(a));


}


}		
    */
}