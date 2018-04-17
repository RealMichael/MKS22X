import java.lang.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] sor = new MyLinkedListImproved[10];
	
		for(int i = 0;i < 10; i ++){
		    sor[i] = new MyLinkedListImproved<Integer>();
		}
		//	sor[0] = new MyLinkedListImproved<Integer>();
		//	sor[1] = new MyLinkedListImproved<Integer>();
		//	sor[0].add(2);
		//  	sor[0].add(4);
		//	sor[1].add(1);
		MyLinkedListImproved<Integer>  neg = new MyLinkedListImproved<>();
		int counter = 0;
		int counter2 = 0;
		for(Integer i : data){
		    if(i < 0){
			counter ++;
		    }
		    if(i >= 0){
			counter2 ++;
		    }
		}
		if(counter > 0 && counter2 == 0){
		    for(Integer i : data){
			neg.add(i);
			data.clear();
		    }
		}
		else{
		for(Integer i : data){
		    if(i < 0){
			neg.add(i);
			data.remove(i);
		    }
		}
		}
		//	System.out.println(data);
		//	System.out.println(neg);

		//Negative part
		if(neg.size() > 0){
		int div2 = 0;
		int ind2 = neg.min();
		Integer minn = neg.get(ind2);
		int numDigit2 = 0;
		while(minn % 10 < 0 || minn <= -10){
		    minn = minn / 10;
		    numDigit2 ++;
		}
		
		//	System.out.println(numDigit2);
		MyLinkedListImproved<Integer> temp2 = new MyLinkedListImproved<>();
		MyLinkedListImproved<Integer> temp2Other = new MyLinkedListImproved<>();
	
				       
			while(numDigit2 > 0){
			    
			    for(Integer i : neg){
			temp2Other.add(i / (int) Math.pow(10, div2));
		    }
			
			    for(int i = 0; i < temp2Other.size() ; i ++){
				sor[(temp2Other.get(i) % 10) * -1].add(neg.get(i));
			}
			   //	System.out.println(temp.toString());
			   for(int i = 0; i < 10; i ++){
			       for(Integer z : sor[i]){
				   temp2.add(z);
			       }
			   }
			   for(MyLinkedListImproved<Integer> i : sor){
			       i.clear();
			   }
			   neg.clear();
			   for(Integer i : temp2){
			       neg.add(i);
			   }
			   temp2.clear();
			   temp2Other.clear();
			   div2 ++;
			   numDigit2 --;
    }
			//	System.out.println(neg);

			for(int i = neg.size() - 1; i >= 0; i --){
			    temp2.add(neg.get(i));
			}
			neg = temp2;
			//	System.out.println(neg);

		}
		//Positive part
		if(data.size() > 0){
		for(Integer i : data){
		    sor[i % 10].add(i);
		}
		    
		/*	String res = "";
	for(int i = 0;i < sor.length; i ++){
	    res += sor[i] + ",";
	}
	System.out.println(res);
		*/
		int div = 1;
		int ind = data.max();
		Integer maxx = (data.get(ind));
		int numDigit = 0;
		while(maxx % 10 > 0 || maxx >= 10){
		    maxx = maxx / 10;
		    // System.out.println(maxx);
		    numDigit ++;
		    // System.out.println(numDigit);
		}
		//	System.out.println(maxx);
		// 	System.out.println(numDigit);
		MyLinkedListImproved<Integer> temp = new MyLinkedListImproved<>();
		MyLinkedListImproved<Integer> tempOther = new MyLinkedListImproved<>();
		for(int i = 0; i < 10; i ++){
		    for(Integer z : sor[i]){
			temp.add(z);
		    }
		}
		for(MyLinkedListImproved<Integer> i : sor){
		    i.clear();
		}
		data.clear();
		for(Integer i : temp){
		    data.add(i);
		}
	       	temp.clear();
		//	System.out.println(data.toString());	

		numDigit = numDigit - 1;
		//	numDigit = 1;
		//	System.out.println(data);
			while(numDigit > 0){
			    for(Integer i : data){
				tempOther.add(i / (int) Math.pow(10,div));
			    }
			    for(int i = 0; i < tempOther.size() ; i ++){
			   //  System.out.println(1021 / (int)Math.pow(10,div) % (int)(Math.pow(10,div)));
			    sor[(tempOther.get(i) % 10)].add(data.get(i));
			    //  System.out.println(tempOther.indexOf(i));
			    // System.out.println(i);
			    // System.out.println(tempOther.toString());
			   
			   
		       }
			   //	System.out.println(temp.toString());
			   for(int i = 0; i < 10; i ++){
			       for(Integer z : sor[i]){
				   temp.add(z);
			       }
			   }
			   //  System.out.println(temp);
			   for(MyLinkedListImproved<Integer> i : sor){
			       i.clear();
			   }
			   data.clear();
			   for(Integer i : temp){
			       data.add(i);
			   }
			   temp.clear();
			   tempOther.clear();
			   div ++;
			   numDigit --;
			}
		}
			// 	System.out.println(data.toString());
		if(neg.size() > 0 && data.size() > 0){
			neg.extend(data);
		}
			//	data = neg;

			for(int i = 0; i < neg.size(); i ++){
			    data.add(neg.get(i));
			}
			//	System.out.println(data);
		
    }
    
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	radixsort(data);
    }
}


    /*
    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
		a.add(-1);
		a.add(-25);
	 	a.add(-8);
	a.add(16);
	a.add(22);
	a.add(20);
	a.add(13);
	a.add(32);
	a.add(61);
	a.add(7);
	a.add(21);
	a.add(210);
 	a.add(46);
	//	a.add(984);
	a.add(1021);
		a.add(-9876);
		a.add(-10000);
	radixsortIncludingNegatives(a);
	//	System.out.println((-405 % 10) * -1);
	System.out.println(a.toString());
    }
}
    */