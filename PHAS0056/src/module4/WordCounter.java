package module4;


import java.io.*;
import java.net.*;	

public class WordCounter {
	
	
	
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL newurl = new URL(urlName);
		InputStream is = newurl.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);
		//System.out.println("Please type something!");
		//try {
		//	String s = b.readLine();
		//	System.out.println("You typed: "+s);
		//	String line;
		//	 while ((line=b.readLine()) != null) {
		//	 System.out.println(line);
		//	 }
		//}
		//catch (IOException e) {
		//	System.out.println("Problem: "+e.getMessage());
		//}	
		return b;	
	}
		
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}	
	
	
	

	
	public static void main(String[] args) {
		
		try {
		brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
		}
		catch(IOException e) {
		}
		
		
		
	}	
}
