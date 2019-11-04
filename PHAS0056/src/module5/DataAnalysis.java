package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DataAnalysis {

	
	public static BufferedReader brFromURL (URL url) {
		double  [][][] data;
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			System.out.println("Error with URL, check URL is formatted correctly. " +e);
			}
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
		}
	
	
	
	
	
	public static void main(String[] args) {
		
	try {	
		URL url = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		BufferedReader b = brFromURL(url);
		}
		catch (Exception e) {
				
		}
					
		

	}

}
