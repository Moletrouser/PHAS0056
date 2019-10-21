package module3;

	import java.util.Random;
	
public class Alphabet {
	
	int n;
	String builtString = "";

	public String StringBuilder(String newchar) {
		builtString = builtString + newchar;
		return builtString;
	}
	
	// generates a random character by selecting a character with ASCII number between 0-128, warning may generate unprintable character
	public static char randomCharacter() { 
		Random random = new Random();
		int n = random.nextInt(128);
		char character = (char)n;
	return character;
	}
	
	// converts both letters and numbers to integers, throws exception if non letter/non number detected as input
	public static int parseInt(String s) throws Exception {
		char charconvert = s.charAt(0);
		int parsedint = (int)charconvert;
		if (Character.isDigit(charconvert) == false && Character.isLetter(charconvert)==false) {
			throw new Exception("The character with ASCII number: " +parsedint +" is neither a letter nor a digit");
		}
		return parsedint;
	}
	
	
	public static void main(String[] args) {
		
		
		// initialises the loop counter, empty string, running total and number of exceptions caught as zero
		int i = 0;
		String builtstring = "";
		int runningtotal = 0;
		int exceptions = 0;
		
		// will loop 400 times
		while (i<400) {
			
			try {
			
			char c = randomCharacter();
			boolean lettertruth = Character.isLetter(c);
			boolean digittruth = Character.isDigit(c);
			
			//checks if rolled character is a letter
			if (lettertruth == true) {
				String converttostring = Character.toString(c);
				int converttoint = parseInt(converttostring);
				builtstring = builtstring + converttostring;
				runningtotal = runningtotal + converttoint;
			}
			//checks if rolled character is a digit
			if (digittruth == true) {
				String converttostring = Character.toString(c);
				int converttoint = parseInt(converttostring);
				builtstring = builtstring + converttostring;
				runningtotal = runningtotal + converttoint;
			}
			else {
				String converttostring = Character.toString(c);
				int converttoint = parseInt(converttostring);
				parseInt(converttostring);
				//System.out.println(converttoint);
			}
			}
			// prints error message if exception detected and adds 1 to exception counter
			catch(Exception e) {
				System.out.println("Error: " +e.getMessage());
				exceptions = exceptions + 1;	
			}
			finally {
			// advances the loop counter by 1
			i = i + 1;
			}
		}
		
		
		// prints the length of the built string, the total sum of numbers added and total number of exceptions along with the exception error messages
		int length = builtstring.length();
		System.out.println(builtstring);	
		System.out.println("The length of the built string is: " +length);	
		System.out.println("The total of numbers added together is: " +runningtotal);
		System.out.println("The total of numbers of exceptions was: " +exceptions);
			
		}
		
	}


