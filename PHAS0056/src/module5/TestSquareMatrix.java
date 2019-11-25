package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		
		
		double [][] matA = {{2,1,0},{0,1,0},{-1,0,2}};
		double [][] matB = {{1,3,1},{0,2,0},{1,0,-1}};
		double [][] matC = {{2,3},{3,4}};
		double [][] matD = {{-4,3},{3,-2}};
		
		
		
		SquareMatrix matrixA = new SquareMatrix(matA);
		SquareMatrix matrixB = new SquareMatrix(matB);
		SquareMatrix matrixC = new SquareMatrix(matC);
		SquareMatrix matrixD = new SquareMatrix(matD);
		
	
		try {
		System.out.println("Matrix A plus Matrix B is:");
		System.out.println(matrixA.add(matrixB));
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		try {
			System.out.println("Matrix A minus Matrix B is:");
			System.out.println(matrixA.subtract(matrixB));
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		try {
			System.out.println("Matrix A times Matrix B is:");
			System.out.println(matrixA.multiply(matrixB));
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		try {
			System.out.println("Matrix B times Matrix A is:");
			System.out.println(matrixB.multiply(matrixA));
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
	
		try {
			System.out.println("The commutator [A,B] is: ");
			
			System.out.println((matrixA.multiply(matrixB)).subtract(matrixB.multiply(matrixA)));
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		try {
			System.out.println("Matrix C times Matrix D is:");
			System.out.println(matrixC.multiply(matrixD));
			System.out.println("The 2x2 unit matrix is: ");
			System.out.println(SquareMatrix.unit(2));
			System.out.println("Are these equal?:");
			System.out.println(SquareMatrix.equals(matrixC.multiply(matrixD),SquareMatrix.unit(2)));
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
	}
}

