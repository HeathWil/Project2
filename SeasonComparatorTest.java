import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;
/**
 * 
 * ********Feb 19, 2016**********
 * 
 * This class will test whether we the seasons are being compared correctly or not
 *
 */
public class SeasonComparatorTest {

	@Test
	public void test() {
		
		
		String tv1="Something";
		String tv2="Something";
		ArrayList<TV> library;
		
		
		
		
		
		TV show1= new TV(tv1);
		TV show2= new TV(tv2);
		
		
		Assert.assertEquals(SeasonComparator.compareTo(tv1, library), actual);
		
		
	}

}
