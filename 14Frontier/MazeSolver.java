import java.util.*;
import java.io.*;

public class MazeSolver{
    private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
      maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }
    
  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
    public boolean solve(int mode){
       	FrontierQueue que = new FrontierQueue();
       	 FrontierStack stacka = new FrontierStack();
	  if(mode == 0){
	  frontier = new FrontierQueue();
      }
      else{
	  frontier = new FrontierStack();
      }

  frontier.add(maze.getStart());
       

      while(frontier.hasNext()){
	  Location current = frontier.next();
	  //  System.out.println(current.toString());
	  if(!(current.equals(maze.getStart()))){
	      maze.set(current.getX(), current.getY(),'.');
	  }
	  //System.out.println(maze.toString());

	  Location[] sub = maze.getNeighbors(current);
	  // String yab = "";
// 	  for(int i = 0; i < sub.length; i ++){
// 	      yab += sub[i].toString() + " ";
// 	  }
	  //	  System.out.println(yab);
	  // return false;
      
    
      // return false;
    
	  for(int i = 0; i < sub.length; i ++){
	      if(sub[i].getX() == maze.getEnd().getX() && sub[i].getY() == maze.getEnd().getY()){
		  return true;
	      }
	      else{
		  frontier.add(sub[i]);
		  int xCordN = sub[i].getX();
		  int yCordN = sub[i].getY();
		  maze.set(xCordN,yCordN,'?');
	      }
	     
	  }
	  
    }
      return false;
}
		  



	  /*
	  if(current.getX() == maze.getEnd().getX() && current.getY() == maze.getEnd().getY()){
	      //   maze.set(current.getX(), current.getY(),'@');
	      while(current.getPrev() != maze.getStart()){
		  current = current.getPrev();
		  maze.set(current.getX(), current.getY(),'@');
	      }
	  
	  return true;
	  }
	  

	    
	  Location[] sub = maze.getNeighbors(current);
	  for(int i = 0; i < sub.length; i ++){
	      //  if(sub[i] == " "){
	      //	  sub[i].setPrev(current);
	      //	  frontier.add(sub[i]);
		  
	      //   }
	      if(sub[i] == maze.getEnd()){
		  return true;
	      }
	      else if(sub[i] != null){
		  frontier.add(sub[i]);
		  maze.set(sub[i].getX(),sub[i].getY(),'?');
		  //  current = frontier.next();
	      }
	  }
      }
    
    return false;
     }
	  */
    
	 
	  
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
   

  public String toString(){
    return maze.toString();
  }



public static void main(String[] args){
	MazeSolver x = new MazeSolver("input.txt");
	System.out.println(x.solve(0));
	//	System.out.println(x);
    }
}