public class Location{
    private int x,y;
    private Location previous;

    public Location(int _x , int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
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
}





       
