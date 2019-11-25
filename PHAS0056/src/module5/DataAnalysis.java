package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


public class DataAnalysis {
	
	double n;
	
	Theory power = new Theory(n);
	
	// reads the data from a url into a buffered reader and returns an Array List
	public static ArrayList<Double> brFromURL (URL url) throws IOException{
		// initialises the array lists
		ArrayList<Double> xData = new ArrayList<Double>();
		ArrayList<String> xData1 = new ArrayList<String>();
		ArrayList<Double> yData = new ArrayList<Double>();
		ArrayList<String> yData1 = new ArrayList<String>();
		ArrayList<Double> eyData = new ArrayList<Double>();
		ArrayList<String> eyData1 = new ArrayList<String>();
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
			while (sc.hasNextDouble()) { //loops while the scanner still has a double on the line given as input
				double nextNumber = sc.nextDouble();
				String snextNumber = Double.toString(nextNumber);
				allData1.add(snextNumber);
			}
		}
		int i=0;
		int arrayLength = allData.size();
		// sorts the data into separate array lists
		while(i<arrayLength) {
			if (i%3 == 0) {
				String temp = allData1.get(i);
				xData1.add(temp);
			}
			if (i%3==1) {
				String temp = allData1.get(i);
				yData1.add(temp);
			}
			if (i%3==2) {
				String temp = allData1.get(i);
				eyData1.add(temp);
			}
			i++;	
	    }
		i = 0;
		// sorts the data into separate array lists
		for (i = 0; i < xData1.size(); i++) { 
		    xData.add(Double.parseDouble(xData1.get(i))); 
		}
		//System.out.println("xData is: " +xData);
		i = 0;
		for (i = 0; i < yData1.size(); i++) { 
			yData.add(Double.parseDouble(yData1.get(i))); 
		}
		//System.out.println("yData is: " +yData);
		i = 0;
		for (i = 0; i < eyData1.size(); i++) { 
			eyData.add(Double.parseDouble(eyData1.get(i))); 
		}
		//System.out.println("eyData is: " +eyData);
		i = 0;
		for (i = 0; i < allData1.size(); i++) { 
			allData.add(Double.parseDouble(allData1.get(i))); 
		}
		return allData;
		}
	
		
	// takes experimental data the degree of polynomial you want to fit to it as inputs and returns Chi squared
	public static double goodnessOfFit(double n, ArrayList<Double> xData,ArrayList<Double> yData, ArrayList<Double> eyData) {
		//n = 4;
		// initialises the arrays for the predictions and residuals
		ArrayList<Double> yPredict = new ArrayList<Double>();
		ArrayList<Double> residuals = new ArrayList<Double>();
		ArrayList<Double> residuals_sqrd = new ArrayList<Double>();
		ArrayList<Double> chi_array = new ArrayList<Double>();
		int i_max = xData.size();
		for (int i=0; i<i_max;i++) {
			double yValue = Math.pow(xData.get(i), n);
			yPredict.add(yValue);
		}
		//calculates the residuals and squares them
		for (int i=0; i<i_max;i++) {
			residuals.add(yPredict.get(i) - yData.get(i));
			residuals_sqrd.add((residuals.get(i))*(residuals.get(i)));
			chi_array.add(residuals_sqrd.get(i)/Math.pow(eyData.get(i),2));			
		}
		//sums the squared residuals
		double sum = 0;
		for(int i = 0; i < residuals_sqrd.size(); i++) {
		    sum = sum + chi_array.get(i);
		} 
		double chi_sqrd = sum;
		//System.out.println(yPredict);
		return chi_sqrd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
	try {
		//initialises the array lists
		ArrayList<Double> xData = new ArrayList<Double>();
		ArrayList<Double> yData = new ArrayList<Double>();
		ArrayList<Double> eyData = new ArrayList<Double>();
		// gives the URL to read the data from
		URL url = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		ArrayList<Double> allData = brFromURL(url);
		int i=0;
		int arrayLength = allData.size();
		// sorts the data into separate array lists
		while(i<arrayLength) {
			if (i%3 == 0) {
				Double temp = allData.get(i);
				xData.add(temp);
			}
			if (i%3==1) {
				Double temp = allData.get(i);
				yData.add(temp);
			}
			if (i%3==2) {
				Double temp = allData.get(i);
				eyData.add(temp);
			}
			i++;	
	    }
		//System.out.println("eyData is: " +eyData);
		System.out.println("Chi squared with n=2 equals: " +goodnessOfFit(2, xData, yData, eyData));	
		System.out.println("Chi squared with n=4 equals: " +goodnessOfFit(4, xData, yData, eyData));	
		System.out.println("The value of Chi squared for n=4 is significantly smaller for n=4 (9 vs 16000) than for n=2 which shows that y=x^4 describes the relationship far better than y=x^2");
		}
	catch (Exception e) {
				
	}
					
	

	}

}
