import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * *******Feb 19, 2014**********
 * 
 * This class is going to take in a string of all the tv show data in the file and construct
 * it into a tvSeries object, parse it, and store
 * it into a data ArrayList of type String. 
 * 
 *
 */
public class TV {
	
	/**An arrayList of type String that will store the data of the tv show*/
	private ArrayList<String> data= new ArrayList<String>();
	/**A String representation of the series' title*/
	private String title="";
	/** A String representation of the year found by the title in the file*/
	private String introYear;
	/**A String representation of the episode's title*/
	private String episode="";
	/**A String representation of the episode's episode number*/
	private String episodeNum;
	/** A String representation of the episode's season number*/
	private String seasonNum;
	/**A String representation of the years the tv show aired*/
	private String years;
	/**A String representation of all the tvdata that needs to be parsed*/
	public String tvData;
	
	
	
	
	/**this method constructs the tvSeries object
	 * 
	 * @param tvData, A String representation of all the tv show's data
	 */
	public TV(String tvData){
		
		this.tvData=tvData;
		
		/**An array of type string that will store the file with whitespace and such removed*/
		String[] str=tvData.split("[ |\t]+");
		
		
		//for loop that will read the string array and add each shortened string to the arrayList data
		for(String s: str){
			
			data.add(s);
			
		}
		
		//will be used to point to the location in the array
		int i= data.size()-1;
		
		
		//removing extra whitespace
		data.get(i).trim();
		
		
		//storing the year/s
		years=data.get(i);
		
		//decrement i
		--i;
		
		{
		String episodeOrYear=data.get(i);
		
		
		//if the character in episode or year is }, itll go through the process of separating that
		//episode data
		if (episodeOrYear.charAt(episodeOrYear.length()-1) == '}'){
			
			episode=data.get(i);
		}
		
		//if the character is ), it means it is the yearIntro and will store as such
		if(episodeOrYear.charAt(episodeOrYear.length()-1) == ')'){
			
			introYear=data.get(i);
		}
	}
		
		{
		//decrementing i again
		i=data.size()-2;
		String yearOrTitle=data.get(i);
		
		if(yearOrTitle.charAt(yearOrTitle.length()-1) == ')'){
			introYear=data.get(i);
			
		}
		
		else {
			while(i>=0){
				title+=data.get(i) + " ";
				i--;
			}
		}
		}
		
		title=reverse(title);
		
		System.out.println(title +  " " + episode + " " + years);
	}
	
	/**
	 * this method takes the file that was read in backwards and reverses it into normal reading order
	 * @param source, a String representation of whatever needs to be reversed because it is in backward order
	 * @return source
	 */
	public static String reverse(String source){
		StringTokenizer token= new StringTokenizer(source, " ");
		Stack<String> storage=new Stack<String>();
		StringBuilder newTitle= new StringBuilder();

		while(token.hasMoreElements()){
			String str=(String)token.nextToken();
			if(!storage.equals("")) storage.push(str);
		}

		while(!storage.isEmpty()){
			newTitle.append(storage.pop());
			if(!storage.isEmpty()) newTitle.append(" ");
		}

		return newTitle.toString();
	}

	/** Citation: http://codereview.stackexchange.com/questions/43838/reverse-a-string-word-by-word*/
	//	http://codereview.stackexchange.com/questions/43838/reverse-a-string-word-by-word


	
	
	
	/**
	 * this method gets the title
	 * @return title, a String representation of the series title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * this method gets the intro year found by the series title in the file
	 * @return introYear
	 */
	public String getIntroYear() {
		return introYear;
	}

	/**
	 * this method gets the episode title
	 * @return episode, a String representation of the episode's title name
	 */
	public String getEpisode() {
		return episode;
	}

	/**
	 * this method gets the episode's number in the season
	 * @return episodeNum, A string representation of the episodes number
	 */
	public String getEpisodeNum() {
		return episodeNum;
	}

	/**
	 * this method gets the season number of the episode
	 * @return seasonNum, a String representation of the season of the episode
	 */
	public String getSeasonNum() {
		return seasonNum;
	}

	/**
	 * this method gets the years the tv show aired
	 * @return years, A String representation of the tv show's aired years.
	 */
	public String getYears() {
		return years;
	}
	
	/**
	 * this method finds whether what the user is looking for is or is not in the library
	 * @param temp, A string of what the user is searching for
	 * @return boolean true or false depending whether it is found in the library
	 */
	public boolean contains(String temp){
		
		return true;
	}
	
	/**
	 * this method converts the data into a string
	 */
	public String toString(){
		return title + " " + introYear + " " + episode + " " + seasonNum + "." + episodeNum + " " + years;
	}
	

}
