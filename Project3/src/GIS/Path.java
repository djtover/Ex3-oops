package GIS;

import java.util.ArrayList;
import java.util.Iterator;

import Geom.Point3D;

public class Path {

//	private ArrayList <Fruit> AL;
	private ArrayList<Point3D> AL;
	private double time;

	public Path() {
		this.AL  = new ArrayList<Point3D>();
		time = 0;
	}

	public ArrayList<Point3D> getAL() {
		return AL;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}

	public boolean add(Point3D f) {
		return AL.add(f);

	}
	public Iterator<Point3D> iterator(){
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