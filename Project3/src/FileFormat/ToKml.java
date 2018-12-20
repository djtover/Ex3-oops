package FileFormat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import GIS.Fruit;
import GIS.Packman;

public class ToKml {


	public ToKml(String fileName, ArrayList<Packman> alp , ArrayList<Fruit> alf ) {

		File f = new File(fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);

			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
					"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n" + 
					"";
			bw.write(header);

			for(int i=0; i<alp.size();i++) {
				String id = "P"+ alp.get(i).getId();
				String lat = ""+ alp.get(i).getStartingPoint().x();
				String lon = ""+ alp.get(i).getStartingPoint().y();
				//				String alt = ""+ alp.get(i).getP().z();
				String timeStamp = "" + alp.get(i).getMd();

				String context = "<Placemark>\r\n" + 
						"<name><![CDATA["+id+"]]></name>\r\n" + 
						"<description><![CDATA[BSSID:<br/>Capabilities: <br/>Timestamp: <b>"+timeStamp+"</b>]]></description><styleUrl>#red</styleUrl>\r\n" + 
						"<Point>\r\n" + 
						"<coordinates>"+lon+","+lat+"</coordinates></Point>\r\n" + 
						"</Placemark>\r\n" ;
				bw.write(context);
			}
			
			for(int i=0; i<alf.size();i++) {
				String id = "F"+ alf.get(i).getId();
				String lat = ""+ alf.get(i).getP().x();
				String lon = ""+ alf.get(i).getP().y();
				String timeStamp ="" + alf.get(i).getTime();
				String context = "<Placemark>\r\n" + 
						"<name><![CDATA["+id+"]]></name>\r\n" + 
						"<description><![CDATA[BSSID:<br/>Capabilities: <br/>Timestamp: <b>"+timeStamp+"</b>]]></description><styleUrl>#red</styleUrl>\r\n" + 
						"<Point>\r\n" + 
						"<coordinates>"+lon+","+lat+"</coordinates></Point>\r\n" + 
						"</Placemark>\r\n" ;
				bw.write(context);

			}
			for(int i=0;i<alp.size();i++) {
			String s="	<Placemark>\r\n "+
					 "<LineString>\r\n"+
			        "<extrude>1</extrude>\r\n"+
			        "<tessellate>1</tessellate>\r\n"+
			        " <coordinates>";
			if(alp.get(i).getPath().size()>0) {
				s+= ""+alp.get(i).getStartingPoint().y()+","+alp.get(i).getStartingPoint().x()+"\n";
			}
				for(int j=0;j<alp.get(i).getPath().size();j++) {
					s+= ""+alp.get(i).getPath().getAL().get(j).getP().y()+","+alp.get(i).getPath().getAL().get(j).getP().x()+"\n";
					
				}
				s+="</coordinates>\r\n "+
						"</LineString>\r\n"+
						"</Placemark>\r\n";
				bw.write(s);
			}
			
		
			
			String closer = "</Folder>\r\n" + 
					"</Document></kml>";
			bw.write(closer);
			bw.close();


		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
