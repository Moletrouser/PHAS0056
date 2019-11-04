package module5;

public class Theory {

	public double n;
	
	public Theory(double nn) {
		nn = n;
	}
	
	public double y(double x) {
		double y = Math.pow(x,n);
		return y;
	}
	


   public static void main(String[] args) {
	
	Theory t1 = new Theory(5);
	
	double value = t1.y(3);
	System.out.println(value);
	   
   }
}  