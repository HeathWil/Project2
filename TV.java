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
	private String introYear="";
	/**A String representation of the episode's title*/
	private String episode="";
	/**A String representation of the episode's episode number*/
	private String episodeNum="";
	/** A String representation of the episode's season number*/
	private String seasonNum="";
	/**    */
	private String suspended="";
	/**A String representation of the years the tv show aired*/
	private String years="";
	/**A String representation of all the tvdata that needs to be parsed*/
	public String tvData="";




	/**this method constructs the tvSeries object
	 * 
	 * @param tvData, A String representation of all the tv show's data
	 */
	public TV(String tvData){

		this.tvData=tvData;

		/**An array of type string that will store the file with whitespace and such removed*/
		String[] str=tvData.split("[ |\t]+" );



		//for loop that will read the string array and add each shortened string to the arrayList data
		for(String s: str){

			data.add(s);

		}


		//System.out.println(data);


		//will be used to point to the location in the array
		int i= data.size()-1;


		//removing extra whitespace
		data.get(i).trim();


		//storing the year/s
		years=data.get(i);

		//decrement i
		--i;


		String episodeOrYear=data.get(i);


		//if the character in episode or year is }, itll go through the process of separating that
		//episode data
		if (episodeOrYear.charAt(episodeOrYear.length()-1) == '}'){




			//if the second to last character is ), itll store that whole word in seasonNum (work on separating that later)
			if(episodeOrYear.charAt(episodeOrYear.length()-2)== ')'){








				int x= episodeOrYear.length()-1;


				//making the integers to help with finding the substring
				while(episodeOrYear.charAt(x) != ')'){
					--x;
				}


				int beginningx=x;
				//snagging the last word of the ep title too for some reason
				while(episodeOrYear.charAt(x) != '('){
					--x;
				}

				int endx=x;

				//storing the substring found into the episode num
				String substring= episodeOrYear.substring(endx + 1, beginningx);

				String [] seasonandep=substring.trim().split("\\.");

				episodeNum=seasonandep[1];
				seasonNum=seasonandep[0];



				String findingEp="";
				--i;
				findingEp=data.get(i);

				while(!findingEp.contains(")")){

					episode+=data.get(i) + " ";
					--i;
					findingEp=data.get(i);


				}

				String yearOrTitle=data.get(i);
				if(yearOrTitle.charAt(yearOrTitle.length()-1) == ')'){
					introYear=yearOrTitle;


				}




			}



			//if the second to last character is } then it should be suspended and therefore this should store all the 
			// data in the correct places. 
			if(episodeOrYear.charAt(episodeOrYear.length()-2) == '}'){
				suspended=data.get(i);




				--i;








				//assigning episode or year the second to last data in the list
				episodeOrYear=data.get(i);

				//making an integer to help point to the position in the string
				int x= episodeOrYear.length()-1;


				//if it ends with }, we know we're looking at the episode data after suspended
				if(episodeOrYear.charAt(episodeOrYear.length()-1) == '}'){




					//Making the integers for finding a substring
					while(episodeOrYear.charAt(x) != ')'){
						--x;
					}
					int beginningx=x;



					while(episodeOrYear.charAt(x) != '('){
						--x;
					}
					int endx=x;



					String substring2= episodeOrYear.substring(endx + 1, beginningx);


					String [] seasonandep=substring2.trim().split("\\.");

					episodeNum=seasonandep[1];
					seasonNum=seasonandep[0];


					String findingEp="";
					--i;
					findingEp=data.get(i);

					while(!findingEp.contains(")")){

						episode+=data.get(i) + " ";
						--i;
						findingEp=data.get(i);


					}

					String yearOrTitle=data.get(i);
					if(yearOrTitle.charAt(yearOrTitle.length()-1) == ')'){
						introYear=yearOrTitle;


					}
				}

			}




			if(episodeOrYear.charAt(episodeOrYear.length()-2) != '}'| episodeOrYear.charAt(episodeOrYear.length()-2) != ')'){

				String findingEp="";
				findingEp=data.get(i);
				while(!findingEp.contains(")")){
					episode+=findingEp + " ";
					--i;
					findingEp=data.get(i);
				}

				String yearOrTitle=data.get(i);
				if(yearOrTitle.charAt(yearOrTitle.length()-1) == ')'){
					introYear=yearOrTitle;



				}
				--i;
				yearOrTitle=data.get(i);

				if(yearOrTitle.contains("\"")){

					while(i>=0){

						title +=  data.get(i) + " ";
						--i;
					}
				}
			}




		}




		if(episodeOrYear.charAt(episodeOrYear.length()-1) == ')'){
			while(i>=0){
				introYear=data.get(i);

				--i;

				while(i >=0){
					title+= data.get(i) + " ";
					--i;
				}
			}

		}






		title=reverse(title);
		episode=reverse(episode);


		System.out.println(years + " " + suspended + " " + seasonNum + " " + episodeNum + " " + episode + " " + introYear + " " + title);









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
