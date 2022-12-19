package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IterateOverList {
	
	public static void main(String[] args) {
		
		List<Integer> first = new ArrayList<>();		
		first.add(1);
		first.add(2);
		first.add(3);
		System.out.println(first);
		Collections.sort(first);
		
		
		List<String> lists = Arrays.asList("C","C++","Java","python");
		
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i));
		}
		System.out.println("-------------");
		
		//Enhanced for each loop
		for(String list: lists) {
			System.out.println(list);
		}
		System.out.println("-------------");
		
		//basic loop with iterator
		for (Iterator iterator = lists.iterator(); iterator.hasNext();) {
			String list = (String) iterator.next();
			System.out.println(list);
		}
		System.out.println("-------------");
		
		//while loop with iterator
		Iterator<String> iterator = lists.iterator();
		while (iterator.hasNext()) {
			String list = (String) iterator.next();
			System.out.println(list);
		}
		
		//java 8 stream + Lambda
		lists.stream().forEach(list->System.out.println(list));
		
		//java 8 forEach + lambda
		lists.forEach(list->System.out.println(list));
		
		
		//java 8 stream + for each =lambda
		lists.stream().filter(list->!"Java".equals(list))
		.forEach(list->System.out.println(list));
	}
	 

}
