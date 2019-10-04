package module1;

public class DataTypes {

	public static void main(String[] args) {
		double doubVar = 5.0;
		System.out.println("doubVar equals " +doubVar);
		float floatVar = 5;
		System.out.println("floatVar equals " +floatVar);
		int intVar = 5;
		System.out.println("intVar equals " +intVar);
		long longVar = 5;
		System.out.println("longVar equals " +longVar);
		byte byteVar = 5;
		System.out.println("byteVar equals " +byteVar);
		System.out.println("\n");
		
		System.out.println("doubVar squared equals " +doubVar * doubVar);
		System.out.println("floatVar squared equals " +floatVar * floatVar);
		System.out.println("intVar squared equals " +intVar * intVar);
		System.out.println("longVar squared equals " +longVar * longVar);
		System.out.println("byteVar squared equals " +byteVar * byteVar);
		System.out.println("\n");
		
		System.out.println("floatVar plus intVar equals " +(floatVar + intVar));
		System.out.println("Java first converts intVar to a float and then adds it to floatVar, giving the right answer as a float");
		System.out.println("intVar plus floatVar equals " +(intVar + floatVar));
		System.out.println("If added in the opposite order, Java still converts intVar to a float before the addition, giving the same answer");
		System.out.println("\n");
		
		System.out.println("byteVar multiplied by doubVar equals " +(byteVar * doubVar));
		System.out.println("Java seems to convert byteVar into a double before attempting the multiplication, outputting the right answer as a double");
		System.out.println("doubVar multiplied by byteVar equals " +(doubVar * byteVar));
		System.out.println("If multiplied in the opposite order, Java still converts byteVar to a double before the multiplication, giving the same answer");
		System.out.println("\n");
		
		System.out.println("longVar minus doubVar equals " +(longVar - doubVar));
		System.out.println("Again, Java converts longVar into a double before the subtraction, outputting the right answer as a double");
		System.out.println("doubVar minus longVar equals " +(doubVar - longVar));
		System.out.println("If subtracted in the opposite order, Java still converts longVar into a double before the subtraction, giving the right answer");
		System.out.println("\n");
		
		char charVar = 'f';
		System.out.println("If we try and 'add' charVar to intVar we get:" +(charVar + intVar));
		System.out.println("Interestingly Java seems to take the ASCII code for 'f' which is 102 and then add this number to intVar giving 107");
		char charVar2 = 'f' + 10;
		System.out.println("If we instead define a new character variable charVar2 as 'f + 10' the output is: " +charVar2);
		System.out.println("This shows us Java is taking the ASCII code for f which is 102 and is adding 10 to it to get 112 and then outputting the ASCII character with code 107, which is p");
		System.out.println("\n");
		
		int x = 3;
		int y;
		// int z = x + y;
		System.out.println("Since we did not initialise y, if we try to add x and y we get the error 'The local variable y may not have been initialized', and the program will not run ");
		System.out.println("\n");
		
		double doubVar2 = 4.99;
		int intVar2 = (int) doubVar2;
		System.out.println("When Java is told to perform a double-to-integer cast on the number 4.99, it gives:" +intVar2);
		System.out.println("This is because when performing double-to-integer casts, Java simply keeps the integer part of the number and discards everything after the decimal point");
		System.out.println("It does not attempt to round the double to the nearest integer");
		System.out.println("\n");
	}   

}
