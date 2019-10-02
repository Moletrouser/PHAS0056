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
		
	}   

}
