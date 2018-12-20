package GIS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MapTest {

	@Test
	void testPixels2Coords() {
		Map m  = new Map(1386,642,"Ariel1.png");
		Point3D p1 = new Point3D(432,254);
		Point3D p2 = new Point3D(32.104308984423675,35.205513766233764,0.0);
		p1 = m.Pixels2Coords(p1, m.getWidth(), m.getHeight());
		assertEquals(p1.toString(),p2.toString());
	}
	
	@Test
	void testCoords2Pixels(){
		Map m  = new Map(1386,642,"Ariel1.png");
		Point3D p1 = new Point3D(432,254);
		Point3D p2 = new Point3D(32.104308984423675,35.205513766233764,0.0);
		p2 = m.Coords2Pixels(p2);
		assertEquals(p1.toString(),p2.toString());
	}
	@Test
	void testDistanceBetweenPixels() {
		
	}

}
