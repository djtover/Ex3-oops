package GIS;

import java.util.Date;
/**
 * This class represents a metadata that is the timestamp of the object on when it was created or found
 * @author David Tover
 *
 */
public class MetaData {

	private Date timeStamp;
	
	public MetaData() {
		Date da = new Date();
	    this.timeStamp = da;	
	}

	public Date getTimeStamp() {	
		return timeStamp;
	}
	public String toString() {
		return ("TimeStamp: "+ timeStamp);
	}
}
