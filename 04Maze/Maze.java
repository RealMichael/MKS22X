import java.util.*;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{

    private char[][]maze;
    private boolean animate;
    private int row;
    private int col;
    private int[] xDirec;
    private int[] yDirec;

    public Maze(String filename) throws FileNotFoundException{
	
	xDirec = new int[] {1,-1,0,0};
	yDirec = new int[] {0,0,1,-1};

	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while(in.hasNextLine()){
		//	row ++
		
	       	String word = in.nextLine();
		row += 1;
		col = word.length();
	    }
	    maze = new char[row][col];
	    Scanner inWords = new Scanner(f);
	    while(inWords.hasNext()){
				
			for(int i = 0; i < maze.length; i ++){
			    String word2 = inWords.nextLine();
		    for(int x = 0; x < word2.length(); x ++){
			maze [i]  [x] = word2.charAt(x);
	    /*
		for(int i = 0; i < word.length; i ++)
		//	row ++;
		System.out.println(word.charAt(0));
	    */
			/*   while(in.hasNextLine()){
		System.out.println("ajfj");
			*/
				    }
		}
	    }
	if(esCount() == false){
	    throw new IllegalStateException();
	}
    }
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    public boolean esCount(){
	int eCount = 0;
	int sCount = 0;
	for(int i = 0;i < maze.length; i ++){
	    for(int x = 0; x < maze[i].length; x ++){
		if(maze[i][x] == 'E'){
		    eCount += 1;
		}
		if(maze[i][x] == 'S'){
		    sCount += 1;
		}
	    }
	}
	if(eCount < 1 || eCount > 1 || sCount > 1 || sCount < 1){
	    return false;

	}
	return true;
    }
    public void setAnimate(boolean b){
        animate = b;
    }
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < maze.length; i ++){
	    for(int x = 0; x < maze[i].length; x ++){
		if(x != maze[i].length - 1){
		    ans += maze[i][x];
		}
		else{
		    ans += maze[i][x] + "\n";
		}
		//	return ans;
	    }
	}
	return ans;
    }

    public boolean safe(int x){
	if(x > 0){
	    return true;
	}
	return false;
    }
    
    public int solve(){
	//	int tracker = 0;
	for(int i = 0; i < maze.length; i ++){
	    for(int x = 0; x < maze[i].length; x ++){
		if(maze[i][x] == 'S'){
		    row = i;
		    col = x;
		}
	    }
	}
	maze[row][col] = ' ';
	return solve(row,col,0,0);
    }

    private int solve(int row, int col, int moveNum, int tracker){
	//automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
	
	if(maze[row][col] == 'E'){
	    return moveNum;
	}
	for(int i = 0; i < xDirec.length; i ++){
	    if(maze[row + xDirec[i]][col + yDirec[i]] == ' ' ||
	        maze[row + xDirec[i]][col + yDirec[i]] == 'E'){
		maze[row][col] = '@';
		/* solve(row + xDirec[i],col + y[Direc[i],moveNum + 1);
		   return solve(row + xDirec[i],col + y[Direc[i],moveNum + 1);
		*/
		tracker = solve(row + xDirec[i],col + yDirec[i],moveNum + 1,tracker);
		if(	safe(tracker)){
			return tracker;
	   
	}
	    }
	    maze[row][col] = ' ';
    }
	    	return - 1;
    }
   


    
    /*
	public static void main(String[] args) {
	    try{
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        
	  f.setAnimate(true);
	  //	  f.solve();

	  System.out.println(f.solve());
	    }
	    catch(FileNotFoundException e){}
	}
}
    
    */
}


