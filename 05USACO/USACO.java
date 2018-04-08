import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	File file = new File(filename);
	Scanner in = new Scanner(file);
       	String word = in.nextLine();
	//	int row = Integer.parseInt(word.substring(0,1));
	//	int col = Integer.parseInt(word.substring(1,2));
	//	int elevation = Integer.parseInt(word.substring(2,3));
	//	System.out.println(word.length());
	//	return 1;

	String[] setup = word.split(" ");
	int row = Integer.parseInt(setup[0]);
	int col = Integer.parseInt(setup[1]);
	int finalEle = Integer.parseInt(setup[2]);
	int repetition = Integer.parseInt(setup[3]);
	int switch2 = 0;
	int switch3 = 0;
	int[][] lake = new int[row][col];
	for(int i = 0; i < row; i ++){
	    String value = in.nextLine();
	    String[] valueArray = value.split(" ");
	    for(int x = 0; x < col; x ++){
		lake[i][x] = Integer.parseInt(valueArray[x]);
	    }
	}
	for(int rep = repetition; rep > 0; rep --){
	    String stompInstructions = in.nextLine();
	    String[] stompArray = stompInstructions.split(" ");
	    int rowCorner = Integer.parseInt(stompArray[0]) - 1;
	    int colCorner = Integer.parseInt(stompArray[1]) - 1;
	    int stompAmount = Integer.parseInt(stompArray[2]);
	    int highest = 0;
	    for(int i = rowCorner; i < rowCorner + 3; i ++){
		for(int c = colCorner ; c < colCorner + 3; c ++){
		    if(lake[i][c] > highest){
			highest = lake[i][c];
		    
		    }
		}
	    }
	    for(int i = rowCorner; i < rowCorner + 3; i ++){
		for(int c = colCorner; c < colCorner + 3; c ++){
		    if(lake[i][c] == highest){
			switch2 = highest - stompAmount;
			lake[i][c] = switch2;
		    }
		    if(lake[i][c] + stompAmount > highest){
			
			switch3 = highest - stompAmount;
			lake[i][c] = switch3;
		    }
		}
	    }
	}
	int finalDepth = 0;
	for(int i = 0; i < lake.length; i ++){
	    for(int x = 0; x < lake[i].length; x ++){
		
		int currentDepth = finalEle - lake[i][x];
		if(currentDepth > 0){
		    finalDepth += currentDepth;
		}
		
	
	    }

	
	    
	}
	/* DEBUGGING
    	String result = "";
	for(int i = 0; i  < lake.length; i ++){
	    for(int c = 0; c < lake[i].length; c ++){
		if(c != lake[i].length - 1){
		    result += lake[i][c] +" " ;
		}
		if(c == lake[i].length - 1){
		    result += lake[i][c] + "\n";
		}
	    }
	}
		System.out.println(result);
		//	System.out.println(lake[3][5]);
		*/
	return finalDepth * 72 * 72;
    }

    /*
    public String toString(int[][] x){
	String result = " ";
	for(int i = 0; i < x.length; i ++){
	    for(int c = 0; c < x[i].length; c ++){
		if(c != x[i].length - 1){
		    result +=  x[i][c];
		}
		if(c == x[i].length - 1){
		    result += x[i][c] + "\n";
		}
	    }
	}
	return result;
    }
    */

    public static int silver(String filename)throws FileNotFoundException{
	File file = new File(filename);
	Scanner in = new Scanner(file);
	String word = in.nextLine();
	String[] setup  = word.split(" ");
        int row = Integer.parseInt(setup[0]);
	int col = Integer.parseInt(setup[1]);
	int seconds = Integer.parseInt(setup[2]);
		if(seconds == 0){
	   return 0;
		}
	char[][] field = new char[row][col];
	for(int r = 0; r < row; r ++){
	    String fieldValues = in.nextLine();
	    //  String[] fieldArray = fieldValues.split(" ");
	    for(int c = 0; c < col; c ++){
		//	field[r][c] = fieldArray[c].charAt(0);
		field[r][c] = fieldValues.charAt(c);
	    }
	}
	String startEnd = in.nextLine();
	String[] seValues = startEnd.split(" ");
	int r1 = Integer.parseInt(seValues[0]);
	int c1 = Integer.parseInt(seValues[1]);
	int r2 = Integer.parseInt(seValues[2]);
	int c2 = Integer.parseInt(seValues[3]);
	//	System.out.println(r1);
	// 	System.out.println(c1);
	    //	System.out.println(r2);
	    //	System.out.println(c2);
	int xMoves[] = new int[]{1,-1,0,0};
	int yMoves[] = new int[]{0,0,1,-1};
	int[][] moves = new int[row][col];
	int[][] movesDup = new int[row][col];
		int total = 0;
		moves[r1 - 1][c1 - 1] = 1;
		movesDup[r1 - 1][c1 - 1] = 1;
	for(int r = 0; r < row; r ++){
	    for(int c = 0; c < col; c ++){
		if(field[r][c] == '*'){
		    moves[r][c] = -1;
		    movesDup[r][c] = -1;
		}
	    }
	}
	
	for(int moveNum = 0; moveNum < seconds; moveNum ++){
	
	    
	    for(int r = 0; r < row; r ++){
		for(int c = 0; c < col; c++){
		    total = 0;
		        if(field[r][c] != '*'){
			    //  total = 0;
			    
			for(int i = 0; i < xMoves.length; i ++){
			    try{
				if(moves[r + xMoves[i]][c + yMoves[i]] != -1
				      &&
				   //	   r + xMoves[i] > 0){
// && c + yMoves[i] > 0
				   
				      r + xMoves[i] <  moves.length &&
				       c + yMoves[i] + 1 <  moves[0].length + 1){
			       

				total += moves[r + xMoves[i]][c + yMoves[i]];
			
			    }
			    }
			    catch(IndexOutOfBoundsException e){}
			}
			
		
			}
			movesDup[r][c] = total;
		       
			
		
		
		    
	    
		
		}
	    }
	    duplicate(moves,movesDup);
	}
    
    
	
    
	    
		
       	String result = "";
	for(int i = 0; i  < field.length; i ++){
	    for(int c = 0; c < field[i].length; c ++){
		if(c != field[i].length - 1){
		    result += field[i][c] +" " ;
		}
		if(c == field[i].length - 1){
		    result += field[i][c] + "\n";
		}
	    }
	}
		String result2 = "";
       	for(int i = 0; i  < moves.length; i ++){
	    for(int c = 0; c < moves[i].length; c ++){
		if(c != moves[i].length - 1){
		    result += moves[i][c] +" " ;
		}
		if(c == moves[i].length - 1){
		    result += moves[i][c] + "\n";
		}
	    }
	}
		String result3 = "";
	for(int i = 0; i  < movesDup.length; i ++){
	    for(int c = 0; c < movesDup[i].length; c ++){
		if(c != movesDup[i].length - 1){
		    result += movesDup[i][c] +" " ;
		}
		if(c == movesDup[i].length - 1){
		    result += movesDup[i][c] + "\n";
		}
	    }
	}
	//	System.out.println(result3);
		//	System.out.println(lake[3][5]);
		//	return 1;
    
		return movesDup[r2 - 1][c2 - 1];
    }

	public static void duplicate(int[][] x, int[][] y){
	    for(int r = 0; r < x.length; r ++){
		for(int c = 0; c < x[r].length; c ++){
		    x[r][c] = y[r][c];
		}
	    }
	}
	// return movesDup[r2][c2];
}

    /*
    public static void main(String[] args){
	try{
	    
	    System.out.println(USACO.bronze("makelake.in"));
	    //  System.out.println(toString(lake));
	}
	catch(FileNotFoundException e){}
    }
}
    */
    

