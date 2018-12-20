package GIS;

import Geom.Point3D;
/**
 * This class represents a Packman 
 * @author David Tover
 *
 */
public class Packman {
	private Point3D p;
	private int speed;
	private static int size= 0;
	private int id;
	private int radius;
	private MetaData md;
	private Path path;
	private Point3D startingPoint;


	
	public Packman() {
		
	}
	/**
	 * This is constructor to build a new Packman
	 * @param lat input the latitude for the coordinates of the Packman
	 * @param lon input the longitude for the coordinates of the Packman
	 * @param alt input the altitude for the coordinates of the Packman
	 * @param Speed input the speed you want your Packman to run
	 * @param Radius input the radius of the Packman tht it could eat a Fruit
	 */
	public Packman(double lat, double lon, double alt, int Speed,int Radius) {
		p = new Point3D(lat,lon,alt);
		this.speed = Speed;
		this.id = size;
		this.size++;
		this.radius = Radius;
		md = new MetaData();
		path = new Path();
		startingPoint = new Point3D(p);
//		path.add(p);
	}
	/**
	 * This is a constructor to build a Packman from another Packman
	 * @param other Input a Packman 
	 */
	public Packman(Packman other) {
		this.p = other.getP();
		this.speed = other.getSpeed();
		this.size = other.getsize();
		this.radius = other.getRadius();
		this.md = other.getMd();
		this.path = other.getPath();
		startingPoint = other.getStartingPoint();
		
	}

	public Path getPath() {
		return path;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getsize() {
		return size;
	}
	
	public int getRadius() {
		return radius;
	}
	public int getId() {
		return id;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Point3D getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(Point3D startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String toString() {
		return(" Packman: "+ p+" Speed: "+ speed+ " ID: "+id +" Radius: "+radius+" "+ md + " "+path);
	}
}
