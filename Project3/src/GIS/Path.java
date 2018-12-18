package GIS;

import java.util.ArrayList;
import java.util.Iterator;

public class Path {

	private ArrayList <Fruit> AL;
	private double time;

	public Path() {
		this.AL  = new ArrayList<Fruit>();
		time = 0;
	}

	public ArrayList<Fruit> getAL() {
		return AL;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}

	public boolean add(Fruit f) {
		return AL.add(f);

	}
	public Iterator<Fruit> iterator(){
		return AL.iterator();
	}
	public int size() {
		return AL.size();

	}
	public void clear() {
		AL.clear();
	}

  public String toString() {
	  String s = "Path: ";
	  for(int i =0; i<AL.size();i++) {
		  s=s+" "+ AL.get(i);
	  }
	  return (s+ "Time: "+time);
  }
}