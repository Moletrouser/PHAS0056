package module5;

import java.lang.reflect.Array;
import java.io.*;
import java.util.*;

public class SquareMatrix {

	double  [][] matrixData;
	int numRows;
	int numColumns;
	
	public SquareMatrix(double[][] elements) {
		//if (checkSquare() == false) {
		//	throw new Exception("Not valid square matrix. # of Rows must equal # of columns.");
		//}
		matrixData = elements;
		
	}
	
	public int rows() {
		int rows = matrixData.length;
		return rows;
	}
	
	
	public int columns() {
		int columns = Array.getLength(matrixData[0]);
		return columns;
	}
	
	public boolean checkSquare() {
		if (this.rows() == this.columns()) {
			return true;
		}
		else {
		return false;
		}
	}
	
	
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString() {
	        int rows = matrixData.length;
	        int columns = matrixData[0].length;
	        String line = "[";

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                line += matrixData[i][j] + "  ";
	            }

	            System.out.println(line + "]");
	            line = "[";
	        }
	return "";
	
	}
		
		

	
	
	
	
	
	
	public static void main(String[] args) {
		
		double [][] mat1 = {{1,2,3,4,5},{6,7,8,9,10}};
		
		try {
		SquareMatrix matrix1 = new SquareMatrix(mat1);
		System.out.println(matrix1);
		}
		catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}

	}

}
