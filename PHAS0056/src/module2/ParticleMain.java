package module2;

public class ParticleMain {

	public double m;
	public double d;
	public double t;
	public double v;
	public double z;
	public final double g = 9.81;
	public final double h = 5;
	
	
	// the drop method executes a while loop that calculates the change in velocity per time step and uses that to
	// update the position and time variables
	public void drop(double deltaT) {
			double z = h; 
			double v = 0;
			t=0; 
			while (z>=0) {
			double a = v*v*d/m-g;
			double dv = a*deltaT;
			double v1 = v+dv;
			double dz = v1*deltaT;
			double z1 = z+dz;
			z=z1;
			v=v1;
			t = t+deltaT;
			}
			System.out.println("The time taken to reach the bottom was: "+ t +" seconds");
			System.out.println("The final velocity was: "+ v +" m/s ");		
	
	}
	
	public static void main(String[] args) {
		
		// sets the initial values for mass and drag
				double m = 4.3; 
				double d = 2.4;
				
				
				FallingParticle newparticle = new FallingParticle (m,d);
				//newparticle.setH(5);
			
				newparticle.drop(0.5);
				newparticle.drop(0.1);
				newparticle.drop(0.01);
				newparticle.drop(0.001);
				newparticle.drop(0.0001);
				
				System.out.println("The first run of the simulation with deltaT = 0.5 is inaccurate because of the way dv is calculated");
				System.out.println("We calculate dv as a*deltaT and so this is only accurate when deltaT is infinitesimally small");
				System.out.println("Because acceleration is the change in displacement per second per second, if we only recalculate a every 0.5 seconds this clearly leads to a bad approximation");
				System.out.println("As deltaT gets smaller and tends towards zero, the time taken to reach the bottom of the container and the final velocity reached also tend to a single value");
				System.out.println("Theoretically only deltaT = 0 gives the true final values for velocity and time however as can be seen from the results the difference between deltaT = 0.0001 and deltaT = 0.00001 is less than 0.0001 seconds and so the difference is insignificant"); 
				
				
				
			}

		
		
	}


