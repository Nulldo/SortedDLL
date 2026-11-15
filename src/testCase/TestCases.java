package testCase;

import adts.*;

public class TestCases {

	public static void main(String[] args) {
		
		//Instantiates list
		SortedDLL<String> list = new SortedDLL<>();
		
		//Adds objects to list
		list.add("Citizen Kane");
		list.add("The Lego Movie");
		list.add("Kung Fu Panda 2");
		list.add("Project Hail Mary");
		list.add("Robots");
		list.add("Whiplash");
		
		//Prints out the objects within the list horizontally 
		//Expected output:Citizen Kane, Kung Fu Panda 2, Project Hail Mary, Robots, The Lego Movie, Whiplash, 
		System.out.println("List of movies in alphabetical order " + list.toString());
		
		System.out.println();
		
		//Checks if list contains robots (case sensitive)
		//Expected output: This list does not contain robots
		//Gets for element index based searches
		//Expected output for both: Robots
		System.out.println(list.contains("robots") ? "This list contains robots" : "This list does not contain robots");
		System.out.println("get Robots: " + list.get("Robots"));
		System.out.println("get 4th item: " + list.get(3));
		
		System.out.println();
		
		//Gets the number of objects in the list
		System.out.println("Number of movies in the list: " + list.size()); //Expected output: 6
		
		//Gets the current iteration method
		//Expected output: Forward
		System.out.println("Current iteration method: " + list.getIterator());
		
	    System.out.print("\nForward Enhanced For Loop: ");
	    
	    for (String movie : list) {
	    	System.out.print(movie + ", ");
	    }
	    
	    //Sets the current iteration method to reverse
	  	//Expected output: Whiplash, The Lego Movie, Robots, Project Hail Mary, Kung Fu Panda 2, Citizen Kane,
	    list.setIterator("reverse");
	    System.out.print("\nReverse Enhanced For Loop: ");
	    for (String movie : list) {
	    	System.out.print(movie + ", ");
	    }
	    
	    //Sets the current iteration method to random
	    //Expected output: a random list of movies i.e.: Robots, Kung Fu Panda 2, Whiplash, The Lego Movie, Citizen Kane, Project Hail Mary,
	    list.setIterator("random");
	    System.out.print("\nRandom Enhanced For Loop: ");
	    for (String movie : list ) {
	    	System.out.print(movie + ", ");
	    }
	    
	    System.out.println();
	    System.out.println();
	    
	    //Removes two movies
	    System.out.println(list.remove("Robots") ? "Robots removed" : "Robots not found on the list"); //Expected output: Robots removed
	    System.out.println(list.remove("Whiplash") ? "Whiplash removed" : "Whiplash not found on the list"); //Expected output: Whiplash removed
	    System.out.println(list.remove("Robots") ? "Robots removed" : "Robots not found on the list"); //Expected output: Robots not found on the list
	    
	    //Shows the order of list is sill intact
	    //Expected output: Citizen Kane, Kung Fu Panda 2, Project Hail Mary, The Lego Movie,
	    System.out.println("\nMovie list after removing Robots and Whiplash: " + list); 	
	    
	    //Gets the number of objects in the list
	    System.out.println("\nNumber of movies in the list: " + list.size()); //Expected output: 4
	    
	    //Sets the find to binary search
	    list.setFind("binary");
	    while (!list.isEmpty()) {
	    	//Removes everything from list
			list.remove(list.get(0));
		}
	    
	    //Expected output: 
	    System.out.println("\nEmpty list:" + list);
	    
	}

}
