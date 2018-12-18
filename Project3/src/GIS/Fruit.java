package GIS;

import Geom.Point3D;

public class Fruit {

	private Point3D p;
	private int weight;
	private static int size=0;
	private int id;
	private MetaData md;

	
	public Fruit() {
		
	}
	public Fruit(double lat, double lon, double alt, int Weight) {
		p = new Point3D(lat,lon,alt);
		this.weight = Weight;
		id = size;
		this.size++;
		md = new MetaData();
	}
	public Fruit(Fruit other) {
		this.p = other.getP();
		this.weight = other.getWeight();
		this.size = other.getsize();
		this.md = other.getMd(); 
	}


	public MetaData getMd() {
		return md;
	}


	public Point3D getP() {
		return p;
	}


	public void setP(Point3D p) {
		this.p = p;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getsize() {
		return size;
	}


	public void setsize(int size) {
		this.size = size;
	}
	public String toString() {
		return(" Fruit: "+ p+" Weight: " +this.weight+" ID: " +id+ " " + md);
	}
}
