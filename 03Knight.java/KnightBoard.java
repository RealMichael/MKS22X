public class KnightBoard{
   private int[][] board;
    private int[] x;
    private int[] y;
    private int ans;
    public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
	x = new int[] {2,1,-1,-2,-2,-1,1,2};
	y = new int[] {1,2,2,1,-1,-2,-2,-1};
    }

    public boolean safe(int row,int col){
	if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 0){
	    return true;
	}
	return false;
    }


    public String pr(){
	String result = "";
	for(int i = 0; i < x.length; i ++){
	    result += x[i];
	}
	return result;
    }
    public String toString(){
	String result = "";
	for(int x = 0;x < board.length; x ++){
	    for(int y = 0;y < board[x].length; y ++){
		
		if(board[x][y] != 0 && board[x][y] < 10){
		    if(y == board[x].length - 1){
			result += " " + board[x][y] + "\n";
		    }
		    else{
			result += " " +  board[x][y] + " ";
		    }
		}
	    		
		if(board[x][y] == 0){
		    if(y == board[x].length - 1){
			result += "_" + "\n";
		    }
		    else{
			result += "_" + " ";
		    }
		}

		if(board[x][y] >= 10){
		    if(y == board[x].length - 1){
			result += board[x][y] + "\n";
		    }
		    else{
			result += board[x][y] + " ";
		    }
		}	    }
	}
	return result;
    }
    
    public void clear(){
	for(int x = 0; x < board.length; x ++){
	    for(int y = 0; y < board[x].length; y ++){
		board[x][y] = 0;
	    }
	}
    }

    public boolean solve(int startingRow, int startingCol){
       	for(int x = 0;x < board.length; x ++){
	    for(int y = 0;y < board[x].length; y ++){
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}

       	if(startingRow < 0 || startingCol < 0 || startingRow > board.length || startingCol > board.length){
	    throw new IllegalArgumentException();
	}
	return solveH(startingRow,startingCol,1);
    }
    
    public boolean solveH(int row,int col, int level){
	int startingR = row;
	int startingC = col;
	if(level == (board.length * board[0].length)){
	    board[row][col] = level;
	    return true;
	}
	//	board[row][col] = level;
	for(int i = 0; i < x.length; i ++){
	    if(safe(row + x[i], col + y[i])){
			board[row][col] = level;
		if(solveH(row + x[i],col + y[i], level + 1)){
		    
		    return true;
		}
	
		board[row][col] = 0;
	    }
	}
	return false;
    }
    
    public int countSolutions(int startingRow, int startingCol){
		for(int x = 0;x < board.length; x ++){
	    for(int y = 0;y < board[x].length; y ++){
		if (board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}

       	if(startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board.length){
	    throw new IllegalArgumentException();
	}

       	return countH(startingRow,startingCol,1,0);


    }

    public int countH(int row,int col, int level, int tracker){
	tracker ++;
	if(level == (board.length * board[0].length)){
	    ans += 1;
	    
	    
	}
	//	board[row][col] = level;
	for(int i = 0; i < x.length; i ++){
	      board[row][col] = level;
	    try{
	
		 if(safe(row + x[i], col + y[i])){
		//	board[row][col] = level;
		     countH(row + x[i] , col + y[i] , level + 1,tracker);	       	    		//	board[row][col ] = 0;
		     board[row + x[i]][col + y[i]] = 0;
		}

	    } catch(ArrayIndexOutOfBoundsException e){
	    }
	    
	}
	board[row][col] = 0;
	return ans;
    }


    public String tester(){
	String result = "";
	if(solve(0,0)){
	    result += "true";
	}
	else{
	    result += "false";
	}
	return result;
    }

    /*
    public static void main(String[] args){
	KnightBoard ab = new KnightBoard(5,5);
	//	System.out.println(ab.tester());
		//	ab.solve(0,0);
			System.out.println(ab.countSolutions(4,4));
	System.out.println(ab);

	//	System.out.println(ab.pr());
    }
    }

    */
}