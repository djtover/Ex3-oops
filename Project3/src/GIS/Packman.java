package GIS;

import Geom.Point3D;

public class Packman {
	private Point3D p;
	private int speed;
	private static int size= 0;
	private int id;
	private int radius;
	private MetaData md;
	private Path path;


	public Packman() {
		
	}
	public Packman(double lat, double lon, double alt, int Speed,int Radius) {
		p = new Point3D(lat,lon,alt);
		this.speed = Speed;
		this.id = size;
		this.size++;
		this.radius = Radius;
		md = new MetaData();
		path = new Path();
	}
	public Packman(Packman other) {
		this.p = other.getP();
		this.speed = other.getSpeed();
		this.size = other.getsize();
		this.radius = other.getRadius();
		this.md = other.getMd();
		this.path = other.getPath();
		
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

//	public vosize setsize(int size) {
//		this.size = size;
//	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String toString() {
		return(" Packman: "+ p+" Speed: "+ speed+ " ID: "+id +" Radius: "+radius+" "+ md + " "+path);
	}
}
