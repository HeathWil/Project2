import java.util.ArrayList;

/**
 * 
 * *******Feb 19, 2016********
 * This class is going to store all the data that was found and parsed in the tv and movie classes 
 * and store them into a combined library.
 *
 */
public class Media {
	
	/** An arrayList of type Movie that stores the movies in the movie library*/
	private ArrayList<Movie> movieData= new ArrayList<Movie>();
	/** An arrayList of type TV that stores the tvseries in the tv library*/
	private ArrayList<TV> tvData= new ArrayList<TV>();
	/** A String representation that will store the movieData and tvData combined into one large library*/
	private String mediaData="";
	/**An Arraylist data that will help with the creation of the combined library*/
	private ArrayList<String> data= new ArrayList<String>();
	
	
	/**
	 * This method creates the movie object and allows the storage of the other libraries for further use
	 * @param movieData, An ArrayList of type Movie that stores all the movies' data
	 * @param tvData, An ArrayList of type Tv that stores all the tvseries' data
	 */
	public void media(ArrayList<Movie> movieData, ArrayList<TV> tvData){
		
		
		this.movieData=movieData;
		this.tvData=tvData;
	}
	
	/**
	 * This method is going to combine both the Movie and Tv arraylists into one large library arrayList.
	 * @return mediaData, A string representation of all the combined data. 
	 */
	private String createLibrary(){
		
		return mediaData;
	}
	

}
