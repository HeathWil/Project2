import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * *******Feb 19, 2016*********
 * 
 * This class will test whether the Year Comparator is working or not
 *
 */
public class YearComparatorTest {

	@Test
	public void test() {
		
		String mov1="Something";
		String tv1="Something";
		Media library= new Media(stuff, stuff);
		
		
		Assert.assertEquals(YearComparator.compareTo(mov1,library), actual);
	}

}
