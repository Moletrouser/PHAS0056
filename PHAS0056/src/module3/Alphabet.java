package module3;

	import java.util.Random;
	
	
	
public class Alphabet {
	
	int n;
	String builtString = "";
	
	public String StringBuilder(String newchar) {
		builtString = builtString + newchar;
		return builtString;
	}
	
	public static char randomCharacter() { // throws Exception{
		Random random = new Random();
		int n = random.nextInt(128);
		//if (n<=31) {
		//	throw new Exception("The ASCII symbol rolled was not a letter or a digit");
		//}
		char character = (char)n;
	return character;
		
	}
	public static int parseInt(String s) throws Exception {
		char charconvert = s.charAt(0);
		//boolean digittruth = Character.isDigit(charconvert);
		//boolean lettertruth = Character.isLetter(c);
		//if (digittruth == false && lettertruth == false) {
		//	throw new Exception("The character:" +charconvert +" is neither a letter or a digit");
		//}
		int parsedint = (int)charconvert;
		if (parsedint <= 31 || parsedint == 127) {
			throw new Exception("The character with ASCII number:" +parsedint +" is neither a letter nor a digit");
		
		}
		return parsedint;
	}
	
	
	
	public static void main(String[] args) {
		
		/*
		try {
			System.out.println("The rolled random character was: " +randomCharacter());
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		*/
		
		int i = 0;
		String builtstring = "";
		int runningtotal = 0;
		int exceptions = 0;
		
		while (i<=400) {
			
			try {
			char c = randomCharacter();
			boolean lettertruth = Character.isLetter(c);
			boolean digittruth = Character.isDigit(c);
			if (lettertruth == true || digittruth == true) {
				String converttostring = Character.toString(c);
				//int converttoint = (int) c;
				int converttoint = parseInt(converttostring);
				builtstring = builtstring + converttostring;
				runningtotal = runningtotal + converttoint;
			}
			String converttostring = Character.toString(c);
			int converttoint = parseInt(converttostring);
			/*
			if (lettertruth == true) {
				//int charconvert = (int)c;
				String stringconvert = Character.toString(c);
				int stringtonumber = parseInt(stringconvert);
				runningtotal = runningtotal + stringtonumber;S
				builtstring = builtstring + stringconvert;
			}
			//if (digittruth == true) {
			if (lettertruth = false) {
				String stringconvert = Character.toString(c);
				int intconvert = parseInt(stringconvert);
				runningtotal = runningtotal + intconvert;
				builtstring = builtstring + stringconvert;
			}
			*/
			
			}
			catch(Exception e) {
				System.out.println("Error: " +e.getMessage());
				exceptions = exceptions + 1;
				
			}
			
			i = i + 1;
		}
		System.out.println(builtstring);	
		System.out.println("The total of numbers added together is: " +runningtotal);
		System.out.println("The total of numbers of exceptions was: " +exceptions);
			
		}
		
	}


