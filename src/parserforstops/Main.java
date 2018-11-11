package parserforstops;

import java.io.BufferedReader;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		ArrayList<Bus> busses = new ArrayList<>(); 
		 
		 int stop_id= 14000; 
		 for(;stop_id<100000;stop_id ++)
		 {
			 WebDriver driver = new ChromeDriver();
			 try {
			 	
				System.out.println("Open Oasth Website");
				String str ; 
				if(stop_id%10000 == stop_id  )
					str="0" + stop_id ; 
				else 
					str = Integer.toString(stop_id); 
				System.out.println(str);
				driver.get("http://oasth.gr/#el/stopinfo/screen/"+str+"/");
				
				
				Thread.sleep(1000);
				
				// Capture all the passing lines details
				String stop_name = driver.findElement(By.xpath("//*[@id=\"contentsArea\"]/div[3]/div/div[2]/h1/span[2]")).getText(); 
				List<WebElement> passing_lines = driver.findElements(By.xpath("//*[@id=\"contentsArea\"]/div[3]/div/div[2]/div[2]/ul/li"));
				
              
				// Displays the number of arrivals captured inside the list
				System.out.println(stop_name + " List size detected  " + passing_lines.size() + "\n");

				// Declares an iterator to fetch the Entries
				java.util.Iterator<WebElement> it = passing_lines.iterator();

				ArrayList<String> passing_buses = new ArrayList<>() ; 
				
				// Print the arrival times on the console 
				while (it.hasNext()) {
			
					 String[] array1 = it.next().getText().split("\n");
					 String busno = array1[0] ; 
					 String bus_name = array1[1] ; 
					
					 Bus b = new Bus(busno, bus_name) ; 
					 if (!busses.contains(b))
						 busses.add(b) ; 
					
					 passing_buses.add(busno) ; 
					 System.out.println( busno + " "+bus_name);
			
										 
				}
				/*
				Stop s = new Stop(str, stop_name, passing_buses) ; 
			    DBconnector db = new DBconnector() ; 
			    db.add_stop(str, stop_name);
			    for(String strg : passing_buses)
			    	db.add_has(str, strg) ; 
				StopList.stops.add(s) ; 
				driver.close();
				*/
			 } catch (Exception e) {
					
				 driver.close();
					
			 }
		
		 }
		

	}

}
