package GIS;

import Geom.Point3D;
/**
 * This is a class that represents a Fruit
 * @author David Tover 
 *
 */
public class Fruit {

	private Point3D p;
	private int weight;
	private static int size=0;
	private int id;
	private MetaData md;

	
	public Fruit() {
		
	}
	/**
	 * This is constructor to build a new Fruit
	 * @param lat input the latitude for the coordinates of the Fruit
	 * @param lon input the longitude for the coordinates of the Fruit
	 * @param alt input the altitude for the coordinates of the Fruit
	 * @param Weight input the weight of the Fruit
	 */
	public Fruit(double lat, double lon, double alt, int Weight) {
		p = new Point3D(lat,lon,alt);
		this.weight = Weight;
		id = size;
		this.size++;
		md = new MetaData();
	}
	/**
	 * This is a constructor to build a Fruit from another Fruit
	 * @param other Input a Fruit 
	 */
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
