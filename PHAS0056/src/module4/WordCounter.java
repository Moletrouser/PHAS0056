package module4;


import java.io.*;
import java.net.*;	
import java.util.Scanner; 



public class WordCounter {
	
	
	// reads the URL given as an argument into the buffer
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL newurl = new URL(urlName);
		InputStream is = newurl.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);
		return b;	
	}
	// reads the file given as an argument into the buffer
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}	
	// counts the number of words in the BufferedReader given as input
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		try(Scanner sc = new Scanner(dataAsBR)){
		    int count = 0; //initialises the word count as zero
		    while(sc.hasNext()){ // checks if the scanner has another word on that line
		        sc.next();
		        count = count + 1; // adds one to the counter
		    }
		
		return count;	    
		}		
	}
	
	

	
	public static void main(String[] args) {
		
		try {
		BufferedReader b = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt"); // this is the URL of the page that will be read into the buffer
		int count = countWordsInResource(b);  // counts the words on the webpage
		System.out.println("The number of words on this webpage is: " +count); // prints the word count
		
		}
		catch(IOException e) {
		}
		
		
		
	}	
}
