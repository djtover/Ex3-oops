package GIS;

import java.util.Date;

public class MetaData {

	private long timeStamp;
	
	public MetaData() {
		Date d = new Date();
	    this.timeStamp = d.getTime();	
	}

	public long getTimeStamp() {
		return timeStamp;
	}
	public String toString() {
		return ("TimeStamp: "+ timeStamp);
	}
}
