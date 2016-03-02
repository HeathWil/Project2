
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * *******March 1, 2016********
 * This class is going to store all the data that was found and parsed in the tv and movie classes 
 * and store them into a combined library.
 *
 */
public class Database {

	/** An List of type Movie that stores the movies in the movie library*/
	private List<Movie> movieData= new ArrayList<Movie>();
	/** An List of type TV that stores the tvseries in the tv library*/
	private List<TV> tvData= new ArrayList<TV>();
	/** A String List representation that will store the movieData and tvData combined into one large library*/
	private List<String> data= new ArrayList<String>();


	/**
	 * This method creates the database object, and also creates a database of all the media types that are in the program. 
	 * @param movieData, An List of type Movie that stores all the movies' data
	 * @param tvData, An List of type Tv that stores all the tvseries' data
	 */
	public Database(List<Movie> movieData, List<TV> tvData){


		this.movieData=movieData;
		this.tvData=tvData;

		String movieLibrary=movieData.toString();
		String tvLibrary=tvData.toString();

		data.add(movieLibrary);
		data.add(tvLibrary);

		//System.out.println(data);


	}

	/**
	 * 
	 * @return movieData, of Type List
	 */
	public List<Movie> getMovieData() {
		return movieData;
	}

	/**
	 * 
	 * @return tvData, of type List
	 */
	public List<TV> getTvData() {
		return tvData;
	}

	/**
	 * 
	 * @return data, of Type List
	 */
	public List<String> getData() {
		return data;
	}

	/**
	 * @return a string representation of the whole library.
	 */
	public String toString(){

		return data.toString();
	}

	/**
	 * 
	 * @param movieData
	 */
	public void setMovieData(List<Movie> movieData) {
		this.movieData = movieData;
	}

	/**
	 * 
	 * @param tvData
	 */
	public void setTvData(List<TV> tvData) {
		this.tvData = tvData;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(List<String> data) {
		this.data = data;
	}




}
