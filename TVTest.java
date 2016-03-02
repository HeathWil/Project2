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


		String tv="\"Star Trek: The Continuing Mission\" (2007) {We Will Control All That You See and Hear (#1.6)} {{SUSPENDED}}	2010";

		TV tvTest= new TV(tv);

		String title="\"Star Trek: The Continuing Mission\"";
		String introYear="(2007)";
		String episode="We Will Control All That You See and Hear";
		String seasonNum="#1";
		String episodeNum="6";
		String suspended="{{SUSPENDED}}";
		String years="2010";


		Assert.assertEquals(tvTest.getTitle(), title);
		Assert.assertEquals(tvTest.getEpisode(), episode);
		Assert.assertEquals(tvTest.getEpisodeNum(), episodeNum);
		Assert.assertEquals(tvTest.getIntroYear(), introYear);
		Assert.assertEquals(tvTest.getSeasonNum(), seasonNum);
		Assert.assertEquals(tvTest.getYears(), years);
		Assert.assertEquals(tvTest.getSuspended(), suspended);



		String words="happy am I";

		String result="I am happy";

		Assert.assertEquals(TV.reverse(words), result);
	}

}
