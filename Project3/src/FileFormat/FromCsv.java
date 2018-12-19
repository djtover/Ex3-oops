package FileFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import GIS.Fruit;
import GIS.Packman;


/**
 * This is a class that represents a way to extract data from a csv file
 * @author David Tover
 *
 */
public class FromCsv {

	private ArrayList<Fruit> ALF;
	private ArrayList<Packman> ALP;
	
	
	/**
	 * This is the constructor for the way to extract data from a csv file
	 * @param csvFile input the name of the file you want to extract data from
	 */
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
					Packman p = new Packman(lat,lon,alt,speed, radius);
					ALP.add(p);
					
					
				}
				else if(userInfo[0].equals("F")) {
					int weight = Integer.parseInt(userInfo[5]);
					Fruit f = new Fruit(lat,lon,alt,weight);	
					ALF.add(f);
				}
					

			}
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
//	public static void main (String [] args) {
//		FromCsv newFile = new FromCsv("C:\\Users\\djtov\\Downloads\\Ex3 (2)\\Ex3\\data\\game_1543684662657.csv") ;
//	}
}
