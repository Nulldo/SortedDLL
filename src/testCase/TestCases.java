package testCase;

import adts.*;

public class TestCases {

	public static void main(String[] args) {
		
		SortedDoubleLinkedList<String> list = new SortedDoubleList<String>();
		
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
		System.out.println(reverseSort(list) + "\nThere are " + list.size() + " movies on the list.");
				
		//Remove a movie from the list (Citizen Kane)
		list.remove("Citizen Kane");
		
		//Display removed movie
		System.out.println("Citizen Kane Removed");		
		
		//Remove tail movie
		list.remove("Whiplash");
		
		//Display removed movie
		System.out.println("Whiplash Removed.");
		
		//Display list of movies randomly + number of movies
		System.out.println(randomSort(list) + "\nThere are " + list.size() + " movies on the list.");
				
		//Find The Lego Movie using binary search, display its position in the list ('It is the Xth movie')
		
		System.out.println(list.getBinary("The Lego Movie").getData() + " found, it is");
		
		//Find Project Hail Mary using sequential search, display its position in the list ('... Xth movie')
		
		


	}

}
