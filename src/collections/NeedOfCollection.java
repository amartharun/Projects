package collections;

import java.util.ArrayList;
import java.util.Collection;

public class NeedOfCollection {
	
	public static void main(String[] args) {
		
		Collection<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("tet");
		fruits.add("orange");
		System.out.println(fruits);
		
		fruits.forEach((element) ->
		{
			if(element=="Orange") {
				System.out.println("Orange in list");

			}
			System.out.println(element);
		});
		
		
		
		fruits.remove("apple");
		System.out.println(fruits);
		System.out.println(fruits.contains("tet"));
		
		
		fruits.clear();
		System.out.println(fruits.isEmpty());
		System.out.print(fruits);
		
	}
	 

}
