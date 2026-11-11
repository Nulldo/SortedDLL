package testCase;

import adts.*;

public class TestCases {

	public static void main(String[] args) {
		
		SortedDLL<String> list = new SortedDLL<String>();
		
		list.add("Citizen Kane");
		list.add("The Lego Movie");
		list.add("Kung Fu Panda 2");
		list.add("Project Hail Mary");
		list.add("Robots");
		list.add("Whiplash");
		
		//Display list of movies head to tail + number of movies
		System.out.println("List of Movies:\n" + list + "\nThere are " + list.size() + " movies on the list.");
		
		//Add a movie to the list
		list.add("Princess Mononoke");
		
		//Display added movie
		System.out.println("Princess Mononoke added.");
		
		//Sort
		list.sort();
		
		//Add a movie at the head
		list.add("American Psycho");
		
		//Display added movie
		System.out.println("American Psycho added.");
		
		//Sort
		list.sort();
		
		//Display list of movies tail to head + number of movies
		System.out.println("Cool movie list, let's see it in reverse!");
		System.out.println(reverseSort(list) + "\nThere are " + list.size() + " movies on the list.");
				
		//Remove a movie from the list (Citizen Kane)
		list.remove("Citizen Kane");
		
		//Display removed movie
		System.out.println("Citizen Kane Removed");		
		
		//Remove tail movie
		String removed = list.getTail;
		list.remove(list.getTail);
		
		//Display removed movie
		System.out.println(removed + " removed.");
		
		//Display list of movies
		System.out.println(sort(list));
		
		//Display list of movies randomly + number of movies
		System.out.println("Time to scramble the movies!");
		System.out.println(randomSort(list) + "\nThere are " + list.size() + " movies on the list.");
				
		//Find a movie using binary search, display its position in the list ('It is the Xth movie')
		System.out.println(list.get("The Lego Movie").getData() + " found, it is");
		
		//Find a movie using sequential search, display its position in the list ('... Xth movie')
		System.out.println(list.get(5).getData() + " found, it is in position " + list.getIndex("Project Hail Mary"));
		
		System.out.println("Is the list empty: " + list.isEmpty());


	}

}
