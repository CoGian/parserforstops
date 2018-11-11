package parserforstops;

public class Bus {

	private String bus_id ; 
	private String bus_name ;
	
	
	public Bus(String bus_id, String bus_name) {
		
		this.bus_id = bus_id;
		this.bus_name = bus_name;
	}
	public String getBus_id() {
		return bus_id;
	}
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}
	public String getBus_name() {
		return bus_name;
	}
	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	} 
	
}
