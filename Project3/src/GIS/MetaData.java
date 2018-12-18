package GIS;

import java.util.Date;

public class MetaData {

	private long timeStamp;
	
	public MetaData() {
		Date da = new Date();
	    this.timeStamp = da.getTime();	
	}

	public long getTimeStamp() {
		return timeStamp;
	}
	public String toString() {
		return ("TimeStamp: "+ timeStamp);
	}
}
