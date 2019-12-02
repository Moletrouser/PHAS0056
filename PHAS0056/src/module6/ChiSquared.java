package module6;

import java.util.ArrayList;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {

	public ChiSquared(Collection<DataPoint> data, Theory theory) {
		
	}
	
	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		
		ArrayList<Double> yPredict = new ArrayList<Double>();
		ArrayList<Double> residuals = new ArrayList<Double>();
		ArrayList<Double> residuals_sqrd = new ArrayList<Double>();
		ArrayList<Double> chi_array = new ArrayList<Double>();
		
		ArrayList<DataPoint> data1 = new ArrayList<DataPoint>();
		
		int i_max = data.size();
		for (int i=0; i<i_max;i++) {
			double xValue = data1.get(i).getX();
			double yValue = theory.y(xValue);
			yPredict.add(yValue);
		}
		//calculates the residuals and squares them
		for (int i=0; i<i_max;i++) {
			residuals.add(yPredict.get(i) - yData.get(i));
			residuals_sqrd.add((residuals.get(i))*(residuals.get(i)));
			chi_array.add(residuals_sqrd.get(i)/Math.pow(eyData.get(i),2));			
		}
		//sums the squared residuals
		double sum = 0;
		for(int i = 0; i < residuals_sqrd.size(); i++) {
		    sum = sum + chi_array.get(i);
		} 
		double chi_sqrd = sum;
		//System.out.println(yPredict);
		return chi_sqrd;
	}

	
}

