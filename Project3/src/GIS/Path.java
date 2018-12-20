package GIS;

import java.util.ArrayList;
import java.util.Iterator;

import Geom.Point3D;

public class Path {

	private ArrayList <Fruit> AL;
	//	private ArrayList<Point3D> AL;
	private double time;
	private int weight;

	public Path() {
		this.AL  = new ArrayList<Fruit>();
		time = 0;
		weight=0;
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


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String toString() {
		String s = "Path: ";
		for(int i =0; i<AL.size();i++) {
			s=s+" "+ AL.get(i);
		}
		return (s+ "Time: "+time + " Weight: "+ weight);
	}
}