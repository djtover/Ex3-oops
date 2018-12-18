package GIS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import Geom.MyCoords;


public class ShortestPathAlgo {

	//	private Game game;
	private Solution s;

	public ShortestPathAlgo(Game g) {
		s = new Solution(findShortest(g));

	}
	private Game findShortest(Game g) {

		ArrayList<Fruit> alf = g.getALF();
		ArrayList <Packman> alp = g.getALP();
		ArrayList <Fruit>	alfCopy = new ArrayList<Fruit>(alf);


		Packman closestP = null;
		Fruit closestF = null;
		MyCoords mc = new MyCoords();
		int index=-1;

		while (!alfCopy.isEmpty()) {
			for(int i=0; i<alp.size();i++) {
				Packman p1 = new Packman(alp.get(i));
				double closestTime = Double.MAX_VALUE;
				for(int j=0; j<alfCopy.size();j++) {
					Fruit f1 = new Fruit(alfCopy.get(j));
					if(closestTime > (mc.distance3d(p1.getP(), f1.getP())/p1.getSpeed()) + p1.getPath().getTime()) {
						closestTime = (mc.distance3d(p1.getP(), f1.getP())/p1.getSpeed()) + p1.getPath().getTime();
						closestP = p1;
						closestF = f1;
						index =j;
					}
					
				}
				if(index!=-1) {
				closestP.getPath().add(closestF);
				closestP.getPath().setTime(closestTime + closestP.getPath().getTime());
				closestP.setP(closestF.getP());
				alfCopy.remove(index);
				}
			}
			closestP =null;
			closestF =null;
			index=-1;
		}



			

		




		//		while(!alf.isEmpty()) {
		//			double closestTime = Integer.MAX_VALUE;
		//			while(itrP.hasNext()) {
		//				Packman p1 = new Packman(itrP.next());
		//				while(itrF.hasNext()) {
		//					Fruit f1= new Fruit(itrF.next());
		////					System.out.println(f1);
		//					if(closestTime> (p1.getP().distance3D(f1.getP())/p1.getSpeed()) + p1.getPath().getTime()){
		//						closestTime = p1.getP().distance3D(f1.getP())/p1.getSpeed() + p1.getPath().getTime();
		//						closestP = p1;
		//						closestF = f1;
		//					}
		//				}
		////				System.out.println(closestF);
		//				closestP.getPath().add(closestF);
		//				closestP.getPath().setTime(closestTime+closestP.getPath().getTime());
		//				closestP.setP(closestF.getP());
		//				alf.remove(closestF);
		//
		//			}
		//
		//		}
		Game newG = new Game(alp , alf);

		return newG;

	}
	public Solution getSolution() {
		return s;
	}
	public static void main(String args[] ) {
		Packman p1 = new Packman(32.10452628971962,35.20409047113997,0.0,1,1);
        Packman p2 = new Packman(32.104470411214955,35.21009834992785,0.0,1,1);
		Fruit f1 = new Fruit(32.10423447975078,35.204555366522364,0.0 ,1);
		Fruit f2 = new Fruit( 32.103688112149534,35.204362256132754,0.0,1);
		Fruit f3 = new Fruit(32.10333421495327,35.203911665223664,0.0,1);
		Fruit f4 = new Fruit( 32.10441453271028,35.20954047546898,0.0,1);
		Fruit f5 = new Fruit(32.10385574766355,35.20964775901876,0.0,1);
		Fruit f6 = new Fruit( 32.1033838847352,35.20973358585859,0.0,1);

		ArrayList<Packman> alp = new ArrayList<Packman>();
		ArrayList <Fruit> alf = new ArrayList<Fruit>();
		alp.add(p1);
		alp.add(p2);
		alf.add(f1);
		alf.add(f2);
//		alf.add(f1);
		alf.add(f3);
		alf.add(f4);
		alf.add(f5);
		alf.add(f6);
		Game g = new Game(alp,alf);
		ShortestPathAlgo spa = new ShortestPathAlgo(g);
		System.out.println(spa.getSolution());
	}
}