package chat;

import java.io.Serializable;
import java.util.Date;

public class HTTPRes implements Serializable {
	String Status; 
	String Version;
	String Timestamp;
	String Format;
	String Connection;
	
	public HTTPRes(String Status, String  Version, String Format, String Connection) {
this.Status = Status ;
this.Version = Version;
Date today = new Date();
today.setHours(0);
//System.out.println(today);
this.Format =Format;
this.Connection = Connection;
this.Timestamp = today.toString() ;
	}

	public void printRes(){
		System.out.println("Status " +Status + " Version " +Version);
		System.out.println("Timestamp " + Timestamp);
		System.out.println("Format "+ Format);
		System.out.println("Connection "+Connection);
	}
	
	
	
}
