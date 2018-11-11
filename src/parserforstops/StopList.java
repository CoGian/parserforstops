package parserforstops;

import java.util.ArrayList;

public class StopList {

	static ArrayList<Stop> stops = new ArrayList<Stop>();
	
	//if stoplist conntains this stop return the stop else null
	public static Stop containsStop(String stop_id) {
		
		
		
		if(!stops.isEmpty()) {
			for(Stop s : stops) {
				if(s.getId().equals(stop_id))
					return s ; 
			}
		}
		
			
		return null ; 
	}
	
}
