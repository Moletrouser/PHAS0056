package module4;

import java.io.*;
import java.net.*;	
import java.util.Scanner; 

public class NumericalReader {
	
	public static String getStringFromKeyboard() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string:");
		String inputstring = input.nextLine();
		input.close();
		return inputstring;
	}
	
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL newurl = new URL(urlName);
		InputStream is = newurl.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);
		return b;
	}
	
	void analysisStart(String dataFile) throws IOException {
		double minValue = 0;
		double maxValue = 10000;
		double nValues  = 0;
		double sumOfValues = 0;
		FileWriter f = new FileWriter(dataFile);
		f.close();
	}
	
	void analyseData(String line) throws IOExceptions {
		double minValue = 0;
		double maxValue = 100000;
		double nValues  = 0;
		double sumOfValues = 0;
		Character firstchar =  line.charAt(0);
		Scanner sc = new Scanner(line);
		
		
		
		while(sc.hasNext()){
			if (line != null && Character.isLetter(firstchar) == false) {
		    System.out.println("The next number on the line is: " +sc.nextInt());
			double nextnumber = sc.nextInt();
			
		        if (nextnumber > minValue) {
		        System.out.println("The next number is: " +nextnumber);
		        minValue = nextnumber;
		        FileWriter f = new FileWriter("fileName");
		        BufferedWriter b = new BufferedWriter(f);
		        PrintWriter pw = new PrintWriter(b);
		        pw.println(nextnumber);
		        pw.close();
		        }
		        
		        if (nextnumber < maxValue) {
		        System.out.println("The next number is: " +nextnumber);
		        maxValue = nextnumber;
		        FileWriter f = new FileWriter("fileName");
		        BufferedWriter b = new BufferedWriter(f);
		        PrintWriter pw = new PrintWriter(b);
		        pw.println(nextnumber);
		        pw.close();
		        }
		        
	  nValues = nValues + 1;
	  }
	  sc.close();		
	  }
	
	
	}
	
	
	

	public static void main(String[] args) {
		
		
		// C:\Users\Peter Brown\git\PHAS0056\PHAS0056\src\module4
		//String directory = getStringFromKeyboard();
		//String saveFile = (directory + File.separator + dataFile);
		
		
		
		NumericalReader nr = new NumericalReader();
		
		
		//http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt
		try { 
		String directory = getStringFromKeyboard();
		String saveFile = (directory + File.separator + dataFile);
		String urlString = getStringFromKeyboard();
		BufferedReader b = nr.brFromURL(urlString);
		nr.analysisStart(saveFile);
		
		}
		
		
		
		
		
		
		
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
