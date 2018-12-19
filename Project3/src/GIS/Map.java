package GIS;

import Geom.Point3D;
/**
 * This is a class that represents a map for this project
 * @author David Tover
 *
 */
public class Map {

	private final Point3D RT = new Point3D(32.105886,35.212337);
	private final Point3D RB = new Point3D(32.101900,35.212337);
	private final Point3D LT = new Point3D(32.105886,35.202424);
	private final Point3D LB = new Point3D(32.101900,35.202424);
	
	private final double diffLat = .003986;
	private final double diffLon = .009913;
	private double latPerHeight;
	private double lonPerWidth;
	private double width;
	private double height;
	
	public Map(double w, double h) {
		width = w;
		height = h;
		lonPerWidth = diffLon/width;
		latPerHeight = diffLat/height;
	}
	public Point3D Coords2Pixels(Point3D p1) {

		
		double dx = Math.abs(p1.x()-LT.x());
		double dy = Math.abs(p1.y()-LT.y());
		
		double rx = dx/diffLat;
		double ry = dy/diffLon;
		
		int w = (int)(ry*width) +1;
		int h = (int)(rx*height)+1;
		
		Point3D ans = new Point3D(w,h,p1.z());
//		System.out.println(ans);
		return ans;
		
	}
	public double getLatPerHeight() {
		return latPerHeight;
	}
	public double getLonPerWidth() {
		return lonPerWidth;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	/**
	 * This is a method to convert from pixels to coordinates 
	 * @param p1 the Point in pixels
	 * @param w the width of the frame
	 * @param h the height of the frame
	 */
	public Point3D Pixels2Coords(Point3D p1, double w, double h) {
//		width = w;
//		height = h;
//		lonPerWidth = diffLon / width;
//		latPerHeight = diffLat/height;
		
		double vX = LT.x()-p1.y()*latPerHeight;
		double vY = LT.y() + p1.x()*lonPerWidth;
		


		Point3D p2 = new Point3D(vX,vY,p1.z());

		return p2;
	
	}
	public static void main(String []args) {
		Point3D p1 = new Point3D(432,254); 
//		Point3D p2 = new Point3D(32.101900,35.212337);
		
		Map m = new Map(1386,642);
		Point3D p2= new Point3D(m.Pixels2Coords(p1, m.getWidth(), m.getHeight()));
//		m.Coords2Pixels(p2);
		System.out.println(p2);
		Point3D p3 = m.Coords2Pixels(p2);
		p3 = m.Pixels2Coords(p3, m.getWidth(), m.getHeight());
		System.out.println(p3);
		
	}
}
