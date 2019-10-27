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
		double minValue;
		double maxValue;
		double nValues;
		double sumOfValues;
		FileWriter f = new FileWriter(dataFile);
		f.close();
	}
	
	void analyseData(String line) {
		Character firstchar =  line.charAt(0);
		Scanner sc = new Scanner(line);
		if (line != null && Character.isLetter(firstchar) == false) {
			while(sc.hasNext()){
		       // sc.next();
		        System.out.println(sc.next());
		sc.close();		
		}
		}
	
	
	}
	
	
	

	public static void main(String[] args) {
		
		
		// C:\Users\Peter Brown\git\PHAS0056\PHAS0056\src\module4
		String directory = getStringFromKeyboard();
		String saveFile = (directory + File.separator + dataFile);
		
		NumericalReader nr = new NumericalReader();
		
		try { 
		String urlString = getStringFromKeyboard();
		BufferedReader b = nr.brFromURL(urlString);
		nr.analysisStart();
		
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
