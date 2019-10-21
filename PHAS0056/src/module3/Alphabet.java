package module3;

	import java.util.Random;
	
	
	
public class Alphabet {
	
	int n;
	
	public String StringBuilder(String newchar) {
		
		return builtString;
	}
	
	public static char randomCharacter() throws Exception{
		Random random = new Random();
		int n = random.nextInt(128);
		if (n<=31) {
			throw new Exception("The ASCII symbols with decimal codes 0-31 (inclusive) are not printable. Roll again.");
		}
		char character = (char)n;
	return character;
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			System.out.println("The rolled random character was: " +randomCharacter());
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		int i = 0;
		while (i<=400) {
			
		}
			try {
				System.out.println("The rolled random character was: " +randomCharacter());
			}
			catch(Exception e) {
				System.out.println("Error: " +e.getMessage());
			}
			finally {
		
		}
		
	}

}
