package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import module6.DataPoint;




public class TestDataPoints {

	double val1;
	double val2;
	double val3;
	String val4;
	
	public static ArrayList<DataPoint> brFromURL (URL url) throws IOException{
		// initialises the array lists
		ArrayList<DataPoint> data = new ArrayList<DataPoint>();

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
			while (sc.hasNext()) { //loops while the scanner still has a token on the line given as input
				double x = 0;
				double y = 0;
				double ey = 0;
				String label = "";
				LabelledDataPoint entry1 = new LabelledDataPoint(x,y,ey,label);		
				DataPoint entry2 = new DataPoint(x,y,ey);
				String val4 = "";
				double val1 = sc.nextDouble();
				//System.out.println("val1 = " +val1);
				double val2 = sc.nextDouble();
				//System.out.println("val2 = " +val2);
				double val3 = sc.nextDouble();
				//System.out.println("val3 = " +val3);
				if (sc.hasNext() == true) {
					val4 = sc.next();
					entry1.x = val1;
					entry1.y = val2;
					entry1.ey = val3;
					entry1.label = val4;
					data.add(entry1);
					//System.out.println("val4 = " +val4);
				}
				else {
					entry2.x = val1;
					entry2.y = val2;
					entry2.ey = val3;
					data.add(entry2);
					//System.out.println("val4 = " +val4);

				}
	
			}
		sc.close();
		}
		//System.out.println(data);
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	try {	
	URL url = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
	ArrayList<DataPoint> data = brFromURL(url);
	System.out.println(data);
	}
	catch (Exception e) {
		
	}
	
	
	
	
	
	
	
	
	}

}
