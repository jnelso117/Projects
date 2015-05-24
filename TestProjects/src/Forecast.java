/**
 * @author Jeremy Nelson @ The University of Alabama at Birmingham
 * This is an API that contains popular forecasting methods that managers use in businesses such as:
 * Mean Absolute Deviation
 * Mean Squared Error
 * Mean Absolute Percent Error
 * Tracking Signals
 * 
 * I made this for Operations Management(MG403) initially for myself as a study tool for an Exam.
 * I have decided to release it to the public as a small API.  This also serves as a project to keep my Java programming skills up to-date.
 * 
 */
import java.util.*;
public class Forecast {
	public static double movingAverage(double[] period) {
		double weight = 0;
		for(int i = 0; i < period.length; i++) {
			weight += period[i];
		}
		return weight/period.length;
		
	}
	public static void weightedAverage(double[] weights, double[] result) {
		if(weights.length != result.length) throw new RuntimeException("Please ensure that you have an equal amount of weights per result.");
		double weightSum = 0.0;
		double weightTimesResult = 0.0;
		for(int i = 0; i < weights.length;i++) {
			weightTimesResult += result[i]*weights[i];
			weightSum += weights[i];
			
		}
		System.out.println(weightTimesResult / weightSum);
	}
	/**
	 * @param actual
	 * Your array of Actual numbers.  This array will be compared to the forecasted numbers.
	 * @param forecast
	 * Your array of Forecasted numbers.  This array will be compared to the actual numbers.
	 * @return MAD
	 * This will return a double value for the Mean Absolute Deviation.
	 */
	public static double mad(double[]actual, double[]forecast ) {
		double N = actual.length;
		double sigma = 0;
		double deviations = Math.abs(sigma);
		if (actual.length != forecast.length) 
			{throw new RuntimeException("Make sure that Actual and Forecast arrays are the same length."); }
		else
		for(int i = 0; i < actual.length;i++) {
			
			double deviation = Math.abs(actual[i] - forecast[i]);
			sigma += deviation++;
		}
	      return (sigma / N);
	}
	
	/**
	 * @param actual
	 * @param forecast
	 * @return
	 */
	public static double mse(double[]actual, double[]forecast ) {
		double N = actual.length - 1;
		double sigma = 0;

		if (actual.length != forecast.length) 
			{throw new RuntimeException("Make sure that Actual and Forecast arrays are the same length."); }
		else
		for(int i = 0; i < actual.length;i++) {
			
			double deviation = Math.abs(actual[i] - forecast[i]);
			sigma += Math.pow(deviation,2);
		}
		return sigma / N;
	}
	public static double trackingSignal(double[]actual, double[]forecast) {
		double N = actual.length;
		double sigma = 0;
		double sigmaforecast = Math.abs(sigma);
		double cumulativeError = 0;
		double mad, trackingSignal;
		if (actual.length != forecast.length) {
			throw new RuntimeException("Make sure that Actual and Forecast arrays are the same length."); 
			}
		else
		for(int i = 0; i < actual.length;i++) {
			
			double cumAbsForecastError = Math.abs(actual[i] - forecast[i]);
			cumulativeError += actual[i] - forecast[i];
			sigma += cumAbsForecastError++;
		}
		mad = sigma / N;
		trackingSignal = cumulativeError / mad;
		//Returns tracking signal and rounds to 2 points after the decimal.
		return (double)Math.round(trackingSignal * 100)/100;
	}
	public static double mape(double[]actual, double[]forecast ) {
		double N = actual.length;
		double sigma = 0;

		if (actual.length != forecast.length) 
			{throw new RuntimeException("Make sure that Actual and Forecast arrays are the same length."); }
		else
		for(int i = 0; i < actual.length;i++) {
			
			double difference = Math.abs(actual[i] - forecast[i]);
			double forecastError = difference / actual[i];
			double absPercentError = forecastError * 100;
			// Trace the input!
			sigma += absPercentError;
		}
		return (sigma / N);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] actual, forecast;
		
		
		System.out.println("This will print the MAD, MSE, MAPE, and Tracking Signal of actual and forecasted results");
		System.out.println("Type the size of each array, hit enter, and type in each number followed by a space");
		System.out.println("Example: 5 (I have 5 numbers) \n1 2 3 4 5");
		System.out.print("Please ensure that both sets of numbers are the same.\nIf you have 5 actual numbers, please provide 5 forecasted numbers.");
		System.out.println("Type in your actual results");
		//actual = StdArrayIO.readDouble1D();
		System.out.println("Type in your forecast numbers");
		//forecast = StdArrayIO.readDouble1D();
//		System.out.println("MAD is: " + mad(actual, forecast));
//		System.out.printf("MSE is: %s %n", mse(actual,forecast));
//		System.out.printf("Mape is: %s %n", mape(actual,forecast));
//		System.out.printf("Tracking Signal: %s %n", trackingSignal(actual,forecast));
		double[] period = {1,2,3,4,5,6,7,8,9,10,11,12};
		double[] weights = {10, 12, 13,16,19,23,26,30,28,18,16,14};
		weightedAverage(period,weights,11,3);
		
		
	}

}
