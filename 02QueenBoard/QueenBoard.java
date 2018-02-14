public class QueenBoard{
    private int[][] board;
    private int track;
    public QueenBoard(int size){
	board = new int[size][size];
	track = 0;
    }


    //TO STRING
    public String toString(){
	String result = "";
	for(int x = 0;x < board.length; x ++){
	    for(int y = 0;y < board[x].length; y ++){
		
		if(board[x][y] == -1){
		    if(y == board[x].length - 1){
			result += "Q" + "\n";
		    }
		    else{
			result += "Q" + " ";
		    }
		}
	    		
		if(board[x][y] == 0 || board[x][y] == 1){
		    if(y == board[x].length - 1){
			result += "_" + "\n";
		    }
		    else{
			result += "_" + " ";
		    }
		}
	    }
	}
	return result;
    }
       
    //ADD QUEEN
     private boolean addQueen(int r, int c){
	 if( board[r][c] == 0){
	     board[r][c] = -1;
	     return true;
	 }
	 return false;
     }
    //REMOVE QUEEN
    private boolean removeQueen(int r, int c){
	if(board[r][c] == -1){
	    board[r][c] = 0;
	    return true;
	}
	return false;
    }
    
    //SAFE FUNCTION
    
    public boolean safe(int r, int c){
	if(board[r][c] == -1){
	    return false;
	}
	for(int x = 0; x <= c ; x ++){
	    if(board[r][x] == -1){
		return false;
	    }
	}
	for(int a = r , b = c ; b >= 0 && a >= board.length - 1; a -- , b --){
	    if (board[a][b] == -1){
		return false;
	    }
	}


	for(int y = r , z = c ; y >= 0 && z >= 0; y -- , z --){
	    if (board[y][z] == -1){
		return false;
	    }
	}
	return true;
    }

    //SOLVE
    
    public boolean solve(){	 
	for(int x = 0;x < board.length; x ++){
	    for(int y = 0;y < board[x].length; y ++){
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return helpSolve(0);
    }
	

    public boolean helpSolve(int col){
	if(col == board.length){
	    return true;
	}
	
	for(int i = 0; i < board.length; i ++){
	    if(safe(i,col)){
	    if(	addQueen(i,col)){
		if(helpSolve(col + 1)){
		    return true;
		}
		removeQueen(i,col);
						    	       					   }
	    }
	}
    
	return false;
    }
  
    public int count(){
		for(int x = 0;x < board.length; x ++){
	    for(int y = 0;y < board[x].length; y ++){
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
		return countHelp(0,0,0,0);
    }
    

    public int countHelp(int i,int col,int counter   ,int sumStart         ){
       	sumStart = 0;
	
	if(counter == board.length){
	  
	    //    removeQueen(i,col);
	    return 1;
	    
	}

	
	
	if(col == board.length){
	     
	    return 0;
	    
	}

       	for( i = 0; i < board.length; i ++){
	    if(safe(i,col)){
	    if(	addQueen(i,col)){
		sumStart +=  countHelp(i + 1,col + 1,counter + 1,sumStart);
	       	removeQueen(i,col);
						    	       					   }
	    }
	    
	    	}
	
	return sumStart;
    }

    
    public static void main(String[] args){
	QueenBoard ab = new QueenBoard(5);
		//	ab.addQueen(4,5);
	//	ab.addQueen(1,1);
	//	ab.addQueen(0,0);
	System.out.println(ab);
	//	ab.removeQueen(1,1);
	//	ab.solve();
	//	System.out.println(ab);
	//	ab.removeQueen(0,4);
	//	System.out.println(ab);
	//	ab.addQueen(0,0);
		System.out.println(ab);
		System.out.println(ab.count());
	//	System.out.println(ab.safe(0,2));
    }
}
    

