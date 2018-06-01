public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
	private int distance,disStart;

    public Location(int _x , int _y, Location prev,Location goal){
	x = _x;
	y = _y;
	previous = prev;
	if(goal == null){
		distance = 0;
	}
	else{
	distance = Math.abs(this.getY() - goal.getY()) + Math.abs(this.getX() - goal.getX());
    }
	}
	
	public Location(int _x , int _y, Location prev,Location goal,Location start,int disSta){
	x = _x;
	y = _y;
	
	previous = prev;
	
	if(prev == start){
		disStart = 0;
	}
	else{
		disStart = disSta;
	}
	if(goal == null){
		distance = 0;
	}
	else{
	distance = Math.abs(this.getY() - goal.getY()) + Math.abs(this.getX() - goal.getX()) + disStart;
    }
	
	}

	

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }
	public int getDistance(){
		return distance;
	}
	public int getDisStart(){
		return disStart;
	}
    public Location getPrev(){
	return previous;
    }

    public void setX(int val){
	x = val;
    }

    public void setY(int val){
	y = val;
    }
    public void setPrev(Location val){
	previous = val;
    }
	
	public int compareTo(Location other){
		return distance - other.getDistance();
	}
}





       
