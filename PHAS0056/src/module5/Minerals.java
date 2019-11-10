package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Minerals {

	
	// loads the URL given into a buffered reader and returns the data on the page as a ArrayList
	public static ArrayList<String> brFromURL (URL url) throws IOException{
		ArrayList<String> allData1 = new ArrayList<String>();
		ArrayList<Double> allData = new ArrayList<Double>();
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			System.out.println("Error with URL, check URL is formatted correctly. " +e);
			}
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		String line1 = "";
		while ((line1 = b.readLine()) != null) { 	
			Scanner sc = new Scanner(line1);  
			//while (sc.hasNextDouble()) { //loops while the scanner still has a double on the line given as input
			while (sc.hasNext()) {	
				String nextString = sc.next();
				allData1.add(nextString);
			}
		}
		
		return allData1;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		try {
			
			// initialises the empty array lists
			ArrayList<Integer> codeData1 = new ArrayList<Integer>();
			ArrayList<Integer> codeData2 = new ArrayList<Integer>();
			ArrayList<String> locationData = new ArrayList<String>();
			ArrayList<Double> massData = new ArrayList<Double>();
			ArrayList<Double> allData1 = new ArrayList<Double>();
			ArrayList<Double> allData2 = new ArrayList<Double>();
			
			URL url1 = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			URL url2 = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
			
			ArrayList<String> allDatastring1 = brFromURL(url1);
			
			int i=0; // converts the mineral mass array list into an arraylist of type Double
			int arrayLength1 = allDatastring1.size();
			for (i = 0; i < allDatastring1.size(); i++) { 
				allData1.add(Double.parseDouble(allDatastring1.get(i))); 
			}
			
			i=0;  //sorts through the mineral mass array list and sorts the data into separate code number and mass array lists
			while(i<arrayLength1) {
				if (i%2 == 0) {
					int temp = (int) Math.round(allData1.get(i));
					codeData1.add(temp);
				}
				if (i%2 == 1) {
					Double temp = allData1.get(i);
					massData.add(temp);
				}
			i++;
			}
			
			System.out.println("The mass data is: " +massData);
			System.out.println("The codedata1 is: " +codeData1);
			
			ArrayList<String> allDatastring2 = brFromURL(url2);
			i=0;
				
			int arrayLength2 = allDatastring2.size();
			
			i=0;
			
			//sorts through the mineral location array list and sorts the data into separate code number and location array lists
			while(i<arrayLength2) {
				if (i%2 == 1) {		
					int temp = (int) Integer.parseInt(allDatastring2.get(i));
					codeData2.add(temp);
				}
				
				if (i%2 == 0) {
					String temp = allDatastring2.get(i);
					locationData.add(temp);
				}
				
				i++;
			}
		
			System.out.println("The location data is: " +locationData);
			System.out.println("The codedata2 is: " +codeData2);
			
			// initialises two empty hash maps
			HashMap<Integer, Double> mineralsMassMap = new HashMap<Integer, Double>();
			HashMap<Integer, String> mineralsLocationMap = new HashMap<Integer, String>();
			
			i=0; // sorts the mineral mass data into a HashMap
			while(i<codeData1.size()) {
				mineralsMassMap.put(codeData1.get(i), massData.get(i));
				i++;
			}
			
			i=0; // sorts the mineral location data into a hash map
			while(i<codeData2.size()) {
				mineralsLocationMap.put(codeData2.get(i), locationData.get(i));
				i++;
			}
			
			// finds the hashmap key with the smallest associated mass value
			Integer minKey = null;
		    double minValue = Integer.MAX_VALUE;
		    for (Integer key : mineralsMassMap.keySet()) {
		        double value = mineralsMassMap.get(key);
		        if (value < minValue) {
		            minValue = value;
		            minKey = key;
		        }
		   
		   }         
		    
		   // prints the key, mass and location of the mineral with the smallest mass
		   System.out.println("The key of the mineral with smallest mass is: " +minKey);
		   System.out.println("The mineral with smallest mass had a mass of: " +mineralsMassMap.get(minKey)); 
		   System.out.println("The location of the mineral with smallest mass was: " +mineralsLocationMap.get(minKey));
			
		   // finds the hashmap key with the largest associated mass value
		   Integer maxKey = null;
		   double maxValue = Integer.MIN_VALUE;
		   for (Integer key : mineralsMassMap.keySet()) {
		       double value = mineralsMassMap.get(key);
		       if (value > maxValue) {
		           maxValue = value;
		           maxKey = key;
		       }
		   
		  }         
		   
		  // prints the key, mass and location of the mineral with the largest mass
		  System.out.println("The key of the mineral with largest mass is: " +maxKey);
		  System.out.println("The mineral with largest mass had a mass of: " +mineralsMassMap.get(maxKey)); 
		  System.out.println("The location of the mineral with largest mass was: " +mineralsLocationMap.get(maxKey));
		   
		   
		}
		catch (Exception e) {
			
		}


	}
}