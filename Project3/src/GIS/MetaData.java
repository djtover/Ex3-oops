package GIS;

import java.util.Date;
/**
 * This class represents a metadata that is the timestamp of the object on when it was created or found
 * @author David Tover
 *
 */
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
