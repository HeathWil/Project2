import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class MovieTest {
	/**
	 * 
	 * 
	 * ******February 4, 2016*******
	 * This is the JUnit test case, where the program will be tested. 
	 * The constructor will be tested to make sure the string parameter is correct, and
	 *  will also be tested to see if it is storing the movie data in the correct places. i.e.
	 *  the movie's title gets stored in title, the movie's release year is stored in year, and so on.
	 *  The getters will also be tested to make sure that the correct information is getting stored
	 *  in each object. 
	 * 
	 */
	@Test
	public void test1() {

		/**
		 * This will test the movie constructor which parses the data
		 */
		String testMovie="Star Trek (1990/IV) (TV) 1990";
		Movie movieTest= new Movie(testMovie);

		String title="Star Trek";
		String year="1990";
		String sequel="(1990/IV)";
		String releaseFormat="(TV)";






		Assert.assertEquals(movieTest.getTitle(), title);

		Assert.assertEquals(movieTest.getYear(), year);

		Assert.assertEquals(movieTest.getSequel(), sequel);

		Assert.assertEquals(movieTest.getReleaseFormat(), releaseFormat);



	


		/**
		 * This part will test to see if the reverse method in movie is working.
		 */
		String finalTest="works this if happy very be will I";
		String finalAnswer="I will be very happy if this works";



		Assert.assertEquals(Movie.reverse(finalTest), finalAnswer);
	}
}
