package module4;

import java.io.*;
import java.net.*;	
import java.util.Scanner; 

public class NumericalReader {
	
	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues;
	private PrintWriter p;
	
	public static String getStringFromKeyboard() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string:");
		String inputstring = input.nextLine();
		input.close();
		return inputstring;
	}
	
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL newurl = new URL(urlName);
		InputStream is = null;
		try {
		is = newurl.openStream();
		}
		catch (IOException e){
		System.out.println("Error with URL: Check that the entered URL is formatted correctly");
		}
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);
		return b;
	}
	
	void analysisStart(String dataFile) throws IOException {
		FileWriter f = null;
		File output = new File("C:\\mywork\\numbers.txt");
		//FileWriter f = new FileWriter(dataFile);
		try {
			f = new FileWriter(output);
		}
		catch (IOException e) {
			System.out.println("Cannot write to file, check target directory.");
		}
		BufferedWriter b = new BufferedWriter(f);
		p = new PrintWriter(b);
		minValue = 0;
		maxValue = 10000;
		nValues = 0;
		sumOfValues = 0;
	}
	
	void analyseData(String line)  throws IOException {
		
		Character firstchar =  line.charAt(0);
		String trimstring = line.trim(); //removes leading and trailing spaces from string
		Scanner sc = new Scanner(trimstring);
		while(sc.hasNextDouble()){
			double nextnumber = sc.nextDouble();
			String stringconvert = Double.toString(nextnumber);
			//if (Character.isDigit(firstchar) == true) {
		    System.out.println("The next number on the line is: " +sc.nextDouble());
		    if (nextnumber > minValue) {
		        System.out.println("The current minValue is: " +nextnumber);
		       	minValue = nextnumber;		      
		    }
		        
		    if (nextnumber < maxValue) {
		        System.out.println("The current maxValue is: " +nextnumber);
		        maxValue = nextnumber;
		   }
		        
	   nValues = nValues + 1;
	   sumOfValues = sumOfValues + nextnumber;
	   System.out.println("The current nValue is: " +nValues);
	   System.out.println("The current sumOfValues is: " +nValues);
	   }		
   }
	
	
	
	
	public void analysisEnd () {
		double average = sumOfValues/nValues;
		System.out.println("The minimum value is: " +minValue +"\n The maximum value is:" +maxValue+ "\n The average value is " + average +"\n The total number of values is: " +nValues +"\n");
		p.close();
	}
	

	public static void main(String[] args) throws IOException {
		
		
		
		//String directory = getStringFromKeyboard();
		//String saveFile = (directory + File.separator + dataFile);
		
		
		
		NumericalReader nr = new NumericalReader();
		// C:\mywork
		// C:\Users\Peter Brown\git\PHAS0056\PHAS0056\src\module4
		// http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt
		//String dataFile = ("C:" + File.separator + "mywork" + File.separator + "numbers.txt");
		
		String dataFile = "numbers.txt";
		File outputfile = new File(dataFile);
		FileWriter fw = new FileWriter(outputfile);
		//System.out.println("Enter the directory you would like to save your file in:");
		//String directory = getStringFromKeyboard();
		//String saveFile = (directory + File.separator + dataFile);
		//String saveFile = "C:\mywork\numbers.txt";
		String saveFile = ("C:" +File.separator + "mywork" + File.separator + "numbers.txt");
		System.out.println("Enter a URL");
		String urlString = getStringFromKeyboard();
		BufferedReader b = nr.brFromURL(urlString);
		nr.analysisStart(saveFile);
		String line = b.readLine();
		System.out.println("The current line is: " +line);
		
		while (line != null) {
			try {
			nr.analyseData(line); // analyze lines, check for comments etc.
			}
			catch (IOException e) {
				 System.out.println("Problem: "+e.getMessage());
			}
		}
		fw.close();
		
		
		
		
		
		
		
		
		/*
		BufferedReader reader = nr.brFromURL("http://foo/bar/");
		String line = "";

		nr.analysisStart(saveFile); // initialize minValue etc.
		while ((line = br.readLine()) != null) {
			nr.analyseData(line); // analyze lines, check for comments etc.
			}
		nr.analysisEnd(); // print min, max, etc.
		*/
		
		
		
		
	}

}
