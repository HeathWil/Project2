import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * ********Feb 19, 2016********
 *
 * This class will test the TV class to make sure everything is being stored/parsed correcly
 */
public class TVTest {

	@Test
	public void test() {
		
		
		String tv="Something";
		
		TV tvTest= new TV(tv);
		
		
		
		
		Assert.assertEquals(tvTest.getTitle(), actual);
		Assert.assertEquals(tvTest.getEpisode(), actual);
		Assert.assertEquals(tvTest.getEpisodeNum(), actual);
		Assert.assertEquals(tvTest.getIntroYear(), actual);
		Assert.assertEquals(tvTest.getSeasonNum(), actual);
		Assert.assertEquals(tvTest.getYears(), actual);
		
		
		
		String words="happy am I";
		
		Assert.assertEquals(TV.reverse(words), actual);
	}

}
