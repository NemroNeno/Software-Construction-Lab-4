/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;
import java.util.ArrayList;
import java.util.List;

public class Filter {


    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
    	
    	List<Tweet> result = new ArrayList<>(); 
    	for (Tweet tweet : tweets) 
    	{
    		if (tweet.getAuthor().equalsIgnoreCase(username))
    		{ 
    			result.add(tweet); 
    		}	
    	} 
    	return result;
    }

   
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
    	List<Tweet> result = new ArrayList<>();
    	for (Tweet tweet : tweets)
    	{
    		if (timespan.getStart().isBefore(tweet.getTimestamp()) && timespan.getEnd().isAfter(tweet.getTimestamp())) 
    		{
    			result.add(tweet); 
    		}
    	} 
    	return result;
    }

   
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
    	List<Tweet> filteredTweets = new ArrayList<>(); 
    	for (Tweet tweet : tweets)
    	{ 
    		String text = tweet.getText().toLowerCase();
    		for (String word : words) 
    		{ 
    			if (text.contains(word.toLowerCase())) 
    			{ 
    				filteredTweets.add(tweet);
    				break; 
    				} 
    			} 
    		} 
    	return filteredTweets;
    }

}
