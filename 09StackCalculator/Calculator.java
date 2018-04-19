import java.util.*;

public class Calculator{
 public static  double eval(String input){
        LinkedList<String> a = new LinkedList<>();
     
	String[] setup = input.split(" ");
	//	System.out.println(Arrays.toString(setup));
	for(int i = 0; i < setup.length; i ++){
	    if(isDig(setup[i])){
		push(setup[i],a);
	    }
	   
	    else{
		Double res1 = Double.parseDouble(pop(a));
		Double res2 = Double.parseDouble(pop(a));
		//	System.out.println(res1);
		//	System.out.println(res2);
		//	if(setup[i] == "-"){
		//	    System.out.println("sostewid");
		//	}
		//	System.out.println(setup[i]);
		
		//	pop();
		//	pop();
		
		if(setup[i].equals("+") ){
		    //  System.out.println(setup[i]);
		    push(Double.toString((res1 + res2)),a);
		    //	    System.out.println("yab" + res1 + res2);
		}
		if(setup[i].equals("-")){
		    push(Double.toString((res2 - res1)),a);
		}
		if(setup[i].equals( "*")){
		    push(Double.toString((res1 * res2)),a);
		}
		if(setup[i].equals("/")){
		    push(Double.toString((res2 / res1)),a);
		}
		if(setup[i].equals("%")){
		    push(Double.toString(res2 % res1),a);
		}
	    }
	}
       	return Double.parseDouble(a.get(0));
	//	return 1.0;
 }

    public static void push(String ele, LinkedList<String> ab){
	    ab.add(ele);
	}

    public static String pop(LinkedList<String> ac){
	String res = ac.get(ac.size() - 1);
	ac.remove(ac.size() - 1);
	return res;
    }

      public static boolean isDig(String al){
	try{
	    Double.parseDouble(al);
	    //  return true;
	}
	catch(NumberFormatException e){
	    return false;
	}
	return true;
    }
	
}
	

	
/*
public class Stack{
    private LinkedList<String> a;

    public Stack(){
	a = new LinkedList<>();
    }

    public void push(String ele){
	a.add(ele);
    }

    public String pop(){
	String res = a.get(a.size() - 1);
	a.remove(a.size() - 1);
	return res;
    }

    public boolean isDig(String al){
	try{
	    Double.parseDouble(al);
	    //  return true;
	}
	catch(NumberFormatException e){
	    return false;
	}
	return true;
    }
   

    public void clear(){
	a.clear();
    }
}
*/

/*
  public static void main(String[] args){
      //   Stack ab = new Stack();
      
      //    System.out.println(eval("11 194 -"));
      //   ab.clear();
     //  System.out.println("NEW FUNCTIONNNN");
//       // System.out.println("NEW FUNCTIONNNN");
      //    System.out.println(eval("11 2 -"));
//        // ab.clear();
// 	  System.out.println("NEW FUNCTIONNNN");
      // System.out.println(eval("11 2 /"));
//        ab.clear();
//        System.out.println("NEW FUNCTIONNNN");
      //   System.out.println(eval("11 2 %"));
// 	ab.clear();
// 	System.out.println("NEW FUNCTIONNNN");
	 System.out.println(eval("11 2 *"));
  }
}
*/