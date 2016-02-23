import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * 
 * ***** February 15, 2016*****
 * This class is going to parse the data of a movie. It will receive all 
 * the data in a single string, that will be separated into title, year, 
 * sequel, releaseFormat 
 *
 */
public class Movie {

	/** A public String that holds the parsed data from the Driver class*/
	public String movieData;
	/** A private String representation of the Movie's title*/
	private String title = "";
	/** A private String representation of the movie's year made*/
	private String year;
	/** A private String representation of the movie's sequel data*/
	private String sequel;
	/** A private String representation of the movie's type(TV, Video, so on)*/
	private String releaseFormat="";
	/** A private ArrayList of type String that will store all of the file's info to be sorted*/
	private ArrayList<String> data= new ArrayList<String>();


	/**
	 * This method is a constructor for the movie. It is going to pass in a String with all
	 * the movie's data and then separate/parse it into the movie's title, year, sequel, and 
	 * releaseFormat(via a nested if loop parser).
	 *
	 * @param movieData, a String of the movie's data
	 * @return void
	 */
	public Movie(String movieData){
		//passing in the initial file and storing it into moviedata.
		this.movieData=movieData;

		/**An array of type string that we store the store the file in now that whitespace/tabs/and so on have been removed*/
		String[] str=movieData.split("[ |\t]+");



	

		// a for loop that will read the string array and add each shortened string to the ArrayList data.
		for (String s: str){	

			data.add(s);

		}

		//integer i that will be used for pointing to the location in the arrayList
		int i= data.size() -1;
		
		//removing the extra whitespace
		data.get(i).trim();


		//Okay, So here's the year!
		year= data.get(i);


		//decrement i
		--i;



		String typeOrSequel=data.get(i);




		//if the last charater in typeOrSequel is ), itll go through all this
		if (typeOrSequel.charAt(typeOrSequel.length()-1) == ')'){


			//if the next to last character is a V, it'll go through this to see if it is simply (V), (TV), or a roman numeral
			if(typeOrSequel.charAt(typeOrSequel.length()-2) =='V'){



				//If T is found, (TV) is stored.
				if(typeOrSequel.charAt(typeOrSequel.length()-3)=='T'){



					releaseFormat= "(TV)";

				}
				
				//If ( is found, (V) is stored
				if(typeOrSequel.charAt(typeOrSequel.length()-3)=='(')
				{
					releaseFormat= "(V)";
				}

				//Check if roman numeral look for / or I
				if(typeOrSequel.charAt(typeOrSequel.length()-3)=='/'){

					i= data.size() -2;
					sequel= data.get(i);
					releaseFormat="(Theatre)";
				}

				//Still checking for roman numeral
				if(typeOrSequel.charAt(typeOrSequel.length()-3)=='I'){
					i= data.size() -2;
					sequel=data.get(i);
					releaseFormat="(Theatre)";
				}
				

			}

			//Okay, so now that the releaseFormat/sequel was found, the sequel or Title must be found.
			i= data.size()-2;
			sequel=data.get(i);
			
			//If no releaseFormat was found in the file, then it was released in theatres.
			if(releaseFormat.equals("")){
					releaseFormat="(Theatre)";
				}
		}


		//Beginning to find the sequel or title
		i=data.size()-3;
		String sequelOrTitle = data.get(i);

		//if a ) is found, it means that the data is definitely a sequel, and will store it as so.
		if(sequelOrTitle.charAt(sequelOrTitle.length()-1)==')'){


			sequel=data.get(i);	

			--i;

		}

		//finding the title and adding it all together. (i>=0) because if i !=0 the first word of the title is left out.
		while (i >= 0){

			title+=data.get(i) + " ";

			i--;
		}


		//calling the reverse method to put the title in readable order. 
		title=reverse(title);









		//System.out.println(title + " " + sequel + " " + releaseFormat + " " + year);








	}
	/**
	 * This method is going to pass in the movies' title that was read in backwards and arrange it into regular reading order.
	 * @param source, A string representation of whatever String is being reversed in word by word order
	 * @return the newly organized title in a String format.
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
	 * This method gets the movie's title.
	 * @return title, a String representation of the movie's title. 
	 */
	public String getTitle() {
		return title;
	}





	/**
	 * This method gets the movie's release year.
	 * @return year, a String representation of the year the movie was released
	 */
	public String getYear() {
		return year;
	}




	/**
	 * This method gets the information if the movie is a sequel
	 * @return sequel, A string representation of if the movie is a continuation
	 */

	public String getSequel() {
		return sequel;
	}




	/** 
	 * This method gets the movie's release format.
	 * @return releaseFormat, a string representation of the format in which the movie was released.
	 */
	public String getReleaseFormat() {
		return releaseFormat;
	}
	
	/**
	 * This method sees if the title contains what the user is looking for, and if so, returns true.
	 * @param temp
	 * @return boolean true or false
	 */
	public boolean contains(String temp) {

		return title.contains(temp);
	}

	/**
	 * This method is a toString method for the movie class
	 * @return line, a String representation of all the movie's data (title,sequel,releaseformat, and year)
	 */
	public String toString(){
		String line= (this.title + " " + this.sequel + " " + this.releaseFormat + " " + this.year);

		return line;
	}















}
