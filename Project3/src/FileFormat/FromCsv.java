package FileFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import GIS.Fruit;
import GIS.Packman;

public class FromCsv {

	private ArrayList<Fruit> ALF;
	private ArrayList<Packman> ALP;
	public FromCsv(String csvFile) {
		
		ALF = new ArrayList<Fruit>();
		ALP = new ArrayList<Packman>();
		
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{
			br.readLine();
			while ((line = br.readLine()) != null) 
			{
				String[] userInfo = line.split(cvsSplitBy);
//				boolean flag = false; 
//				int id = Integer.parseInt(userInfo[1]);
				double lat = Double.parseDouble(userInfo[2]);
				double lon = Double.parseDouble(userInfo[3]);
				double alt = Double.parseDouble(userInfo[4]);

				if(userInfo[0].equals("P")) {
					int speed = Integer.parseInt(userInfo[5]);
					int radius = Integer.parseInt(userInfo[6]);
					//need to fix this
					Packman p = new Packman(lat,lon,alt,speed, radius);
//					System.out.println(p);
//					System.out.println(p);
					ALP.add(p);
					
//					flag=ALP.add(p);
					
				}
				else if(userInfo[0].equals("F")) {
					int weight = Integer.parseInt(userInfo[5]);
					//need to fix this
					Fruit f = new Fruit(lat,lon,alt,weight);	
//					System.out.println(f);
					ALF.add(f);
					
					
					
					
//					flag = ALF.add(f);
				}
					

			}
//			System.out.println(ALP.size());
//			System.out.println(ALF.size());
			br.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public ArrayList<Fruit> getALF() {
		return ALF;
	}
	public ArrayList<Packman> getALP() {
		return ALP;
	}
	public static void main (String [] args) {
		FromCsv newFile = new FromCsv("C:\\Users\\djtov\\Downloads\\Ex3 (2)\\Ex3\\data\\game_1543684662657.csv") ;
	}
}
