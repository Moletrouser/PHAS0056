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
	
	// takes user input from the keyboard and returns it as a string
	public static String getStringFromKeyboard() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string:");
		String inputstring = input.nextLine();
		input.close();
		return inputstring;
	}
	
	// writes the text from the URL page into a buffer in memory
	// public BufferedReader brFromURL(URL url) {
	public static BufferedReader brFromURL (URL url) {
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

	
	// initialises min/max values and numberof/sumof values to later be updated by analyseData
	// void analysisStart(String dataFile) {
	public void analysisStart(String saveFile) {
		//File outputfile = new File("C:\\mywork\\numbers.txt");
		File outputfile = new File(saveFile);
		FileWriter f = null;
		try {
			f = new FileWriter(outputfile);
		} catch (IOException e) {
			System.out.println("Cannot write to the file, check directory is correct. " +e);
		}
		BufferedWriter b = new BufferedWriter(f);
		p = new PrintWriter(b);
		minValue = 1000; 
		maxValue = -1000; 
		nValues = 0; 
		sumOfValues = 0;
	}
	
	// creating method which will analyse the data in the URL file ignoring blank line and 
	// comment lines. It will adjust minVal, maxVal,no. of Values and sum of Values accordingly
	// and print lines containing numbers to screen and to numbers.txt file
	public void analyseData(String string) {
		String trimmedstring = string.trim();
		Scanner sc = new Scanner(trimmedstring);  //trims the string by removing any leading or trailing white space
		while (sc.hasNextDouble()) {    //loops while the scanner still has a double on the line given as input
			Double nextnumber = sc.nextDouble();
		String stringconvert = Double.toString(nextnumber);
		if (minValue > nextnumber) { //tests if the current value is a new minimum value
			minValue = nextnumber;
		}
		if (maxValue < nextnumber) { //tests if the current value is a new maximum value
			maxValue = nextnumber;
		}
		nValues = nValues + 1; 
		sumOfValues = sumOfValues + nextnumber;
		System.out.println(stringconvert);
		p.println(stringconvert);
		//sc.close();
		}
	}
	
	// creating method which will finish analysis by printing to screen the final minVal,
	// maxVal, no. of values and average value. It will also finish writing to numbers.txt file.
	public void analysisEnd () {
		double average = sumOfValues/nValues;
		System.out.println("\n");
		System.out.println("The minimum value is: " +minValue);
		System.out.println("\n");
		System.out.println("The maximum value is: " +maxValue);	
		System.out.println("\n");
		System.out.println("The average value is: " +average);	
		System.out.println("\n");
		System.out.println("The total number of values is: " +nValues);	
		System.out.println("\n");
		p.close();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the file path of the directory you would like to save the numbers text files in: ");
		String saveDir = NumericalReader.getStringFromKeyboard();
		if (saveDir.length() == 0) {
			saveDir = ("C:" +File.separator +"users" +File.separator +"Peter Brown"); // this is the home directory on my personal computer, i can change this to my UCL home 
		}																			  // directory for demonstration purposes but it would not work for testing here

		String dataFile1 = "numbers1.txt";
		String dataFile2 = "numbers2.txt";
		String saveFile1 = (saveDir + File.separator + dataFile1);
		String saveFile2 = (saveDir + File.separator + dataFile2);
		
		NumericalReader nr1 = new NumericalReader ();
		URL url1 = null; // initialises an empty URL
		try {
			url1 = new URL ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");  // this is the URL which will be read into the buffer
			System.out.println("\n");
			System.out.println("URL = "+url1); //prints the URL that has been used
		} catch (MalformedURLException e) {
			System.out.println("Please check that a valid URL address has been entered"+e);
		}
		BufferedReader b1 = brFromURL(url1);
		String line1 = "";
		
		nr1.analysisStart(saveFile1); 
		try {
			// read each line each line in succesion until last line is reached
			while ((line1 = b1.readLine()) != null) { 
				nr1.analyseData(line1); 
			}
		} catch (IOException e) {
			System.out.println("Cannot read from file. " +e);
		}
		// prints maxValue, minValue, average and sumOfValues
		nr1.analysisEnd();
	
		
		NumericalReader nr2 = new NumericalReader ();
		URL url2 = null; // initialises an empty URL
		try {
			url2 = new URL ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt"); // this is the URL which will be read into the buffer
			System.out.println("\n");
			System.out.println("URL = "+url2); //prints the URL that has been used
		} catch (IOException e) {
			System.out.println("Please check that a valid URL address has been entered"+e);
		}
		BufferedReader b2 = brFromURL(url2);
		String line2 = "";
		nr2.analysisStart(saveFile2); 
		try {
			while ((line2 = b2.readLine()) != null) { 
				nr2.analyseData(line2); 
			}
		} catch (IOException e) {
			System.out.println("Cannot read from file." +e);
		}
		nr2.analysisEnd(); // prints maxValue, minValue, average and sumOfValues
	}
}
