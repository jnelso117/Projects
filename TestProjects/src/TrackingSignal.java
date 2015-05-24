	import java.util.Scanner;
public class TrackingSignal {
	public static void trackingSignal(double[]actual, double[]forecast, boolean print) {
		double N = actual.length;
		double sigma = 0;
		double sigmaforecast = Math.abs(sigma);
		double cumulativeError = 0;
		double mad, trackingSignal;
		if (actual.length != forecast.length) 
			{throw new RuntimeException("Make sure that Actual and Forecast arrays are the same length!"); }
		else
		for(int i = 0; i < actual.length;i++) {
			
			double cumAbsForecastError = Math.abs(actual[i] - forecast[i]);
			cumulativeError += actual[i] - forecast[i];
			
			if(print == true){
			System.out.println("Cumulative Absolute Error for index " + actual + " + " + forecast + ": " + cumAbsForecastError);
			System.out.println("Cumulative Error for index " + actual[i] + ": " + cumulativeError);
			}
			sigma += cumAbsForecastError++;
		}
		mad = sigma / N;
		trackingSignal = cumulativeError / mad;
		System.out.println("Absolute Cumulative Forecast Error: " + sigma);
		System.out.println("Cumulative Error: " + cumulativeError);
		System.out.println("MAD: " + mad);
		//Prints tracking signal and rounds to 2 points after the decimal.
		System.out.printf("Tracking Signal: %s", (double)Math.round(trackingSignal * 100)/100);
	}
	public static void TrackingSignalExplanation(){
		System.out.println("Tracking Signal");
		System.out.println("Formula: Cumulative Error/MAD");
		System.out.println("Cumulative Error = A[i] - F[i] + A[i2] - F[i2]...");
		System.out.println("MAD = Sum of A - F / N");
		System.out.println("Please enter the size of Actual numbers, followed by the numbers themselves\n");
		System.out.println("For example, if you have 3 months of actual numbers, type 3, hit Enter, and type each number followed by a space");
		System.out.println("Do the same for the Forecasted demand");
	}
	public static void main(String[] args) {
		//Calculates Mean Absolute Deviation
		double[] actual, forecast;
		TrackingSignalExplanation();
		actual = StdArrayIO.readDouble1D();
		forecast = StdArrayIO.readDouble1D();
		trackingSignal(actual, forecast, true);
		
		}
}

	
