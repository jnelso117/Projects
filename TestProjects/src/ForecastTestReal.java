import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class ForecastTestReal {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testMad() {
		double[] actual = {90,95,115,100,125,140};
		double[] predicted = {100,100,100,110,110,110};
		double expected = 14.2;
		double result = Forecast.mad(actual, predicted);
		assertEquals(14.2,result,.1);
	}

	@Test
	public void testMse() {
		double[] actual = {406, 423, 423, 440};
		double[] predicted = {410, 419, 428, 435};
		assertEquals(27,Forecast.mse(actual, predicted),.5);
	}
	@Test
	public void testMovingAverage() {
		double[] period = {13, 16, 19};
		assertEquals(16,Forecast.movingAverage(period),1e-10);
		System.out.print(Forecast.movingAverage(period));
	}
	@Test
	public void testWeightedAverage() {
		//3 month weighting average
		double[] period = new double[3];
		double[] weights = {10, 12, 13};
		assertEquals(1.6,Forecast.weightedAverage(period,weights,2),.5);
	}
	@Test
	public void testTrackingSignal() {
		double[] actual = {90,95,115,100,125,140};
		double[] predicted = {100,100,100,110,110,110};
		double expected = 2.5;
		double result = Forecast.trackingSignal(actual, predicted);
		assertEquals(2.5,result,.1);
		
	}

	@Test
	public void testMape() {
		double[] actual = {180,168,159,175,190,205,180,182};
		double[] forecast = {175,175.5,174.75,173.18,173.36,175.02,178.02,178.22};
		//With an alpha of .10
		double expected = 5.59;
		double result = Forecast.mape(actual, forecast);
		assertEquals(expected,result,.1);
		//System.out.print(result);
		
	}
	@Test
	public void testMain() {
		/*
		 * 
		 */
	}

}
