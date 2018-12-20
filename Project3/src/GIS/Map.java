package GIS;

import java.awt.image.BufferedImage;

import Geom.MyCoords;
import Geom.Point3D;
/**
 * This is a class that represents a map for this project
 * @author David Tover
 *
 */
public class Map {

	private final Point3D RT = new Point3D(32.105886,35.212337,650);
	private final Point3D RB = new Point3D(32.101900,35.212337,650);
	private final Point3D LT = new Point3D(32.105886,35.202424,650);
	private final Point3D LB = new Point3D(32.101900,35.202424,650);
	private final double diffLat = .003986;
	private final double diffLon = .009913;
	
	private String myImage;
	private double latPerHeight;
	private double lonPerWidth;
	private double width;
	private double height;
	
	public Map(double w, double h , String image) {
		width = w;
		height = h;
		myImage = image;
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
		return ans;
		
	}
	/**
	 * This is a method to convert from pixels to coordinates 
	 * @param p1 the Point in pixels
	 * @param w the width of the frame
	 * @param h the height of the frame
	 */
	public Point3D Pixels2Coords(Point3D p1, double w, double h) {
		
		double vX = LT.x()-p1.y()*latPerHeight;
		double vY = LT.y() + p1.x()*lonPerWidth;
		


		Point3D p2 = new Point3D(vX,vY,p1.z());

		return p2;
	
	}
//	public double DistanceBetweenPixels(Point3D p1, Point3D p2) {
//		MyCoords mc = new MyCoords();
//		double dx = mc.distance3d(LT, RT);
//		double dy = mc.distance3d(LT, LB);
//		double meterPerX = dx / getWidth();
//		double meterPerY = dy / getHeight();
//		
//		int y = Math.abs(p2.iy()-p1.iy());
//		int x = Math.abs(p2.ix()-p1.ix());
//		
//		double ry = y/getHeight();
//		double rx = x/getWidth();
//		
//		double disy = ry*meterPerY;
//		double disx = rx*meterPerX;
//		
//		return Math.sqrt(disy*disy + disx*disx);
//		
//				
//	}
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
	public String getMyImage() {
		return myImage;
	}
	public static void main(String []args) {
		
		
		Map m = new Map(1386,642,"Ariel1.png");
//		Point3D p1 = new Point3D(32.10255812461059,35.207452022366525,650);
//		Point3D p2 = new Point3D(32.10484293457944,35.20783109090909,650);
		MyCoords mc = new MyCoords();
//		
//		double ans = mc.distance3d(p1, p2);
		
		
//		Point3D p1 = new Point3D(703,536);
//		System.out.println(m.Pixels2Coords(p1, m.getWidth(), m.getHeight()));
//		Point3D p2 = new Point3D(756,168);
//		System.out.println(m.Pixels2Coords(p2, m.getWidth(), m.getHeight()));
//		Point3D p3 = m.Coords2Pixels(p2);
//		p3 = m.Pixels2Coords(p3, m.getWidth(), m.getHeight());
//		double ans = m.DistanceBetweenPixels(p1, p2);
//		System.out.println(ans);
//		System.out.println(p3);
		
	}
}
