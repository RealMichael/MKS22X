public class Recursion{
   

    public int fact (int n){
	if( n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return n * fact(n - 1);
    }

    public int fib(int n){
	if( n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelp(n, 0 , 1);

    }
	
    public static int fibHelp(int n, int firstChan, int secondChan){
	if(n == 1) {
	    return secondChan;
	}
	if(n == 0){
	    return firstChan;
	}
	return fibHelp(n - 1, secondChan, firstChan + secondChan);
    }
	


    public double sqrt(double n){
	if( n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n, 5.0);
    }
    
    public static double sqrtHelper(double n , double guess){
	double margin = 0.0000001;
	if(Math.abs((guess * guess) - n) < margin){
	    return guess;
	}
	
	guess = ((n / guess) + guess) / 2;
	    return sqrtHelper(n,guess);
	
    }




	
	
    
}