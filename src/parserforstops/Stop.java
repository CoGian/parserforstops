package parserforstops;

import java.util.ArrayList;

public class Stop {
	
	private String id ;
	private String name ; 
	private ArrayList<String> passing_line = new ArrayList<>()  ; 
	
	
	public Stop(String id, String name, ArrayList<String> passing_lines) {
		
		this.id = id;
		this.name = name;
		this.passing_line = passing_lines;
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPassing_lines() {
		return passing_line;
	}

	public void getPassing_lines(ArrayList<String> bus_id) {
		this.passing_line = bus_id;
	}

}

