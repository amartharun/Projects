package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListIterateOver {
	
	public static void main(String[] args) {
		
		LinkedList<String> first = new LinkedList<>();		
		first.add("c");
		first.add("c++");
		first.add("java");
		first.add("python");
		
		Iterator<String> it = first.iterator();
		while (it.hasNext()) {
			String fru = (String) it.next();
			System.out.println(fru);
			
		}
		
		first.forEach((element)->
		System.out.println(element));
		
		for(int i=0;i<first.size();i++) {
			System.out.println(first.get(i));
		}
		System.out.println("-------------");
		
		for(String fru:first) {
			System.out.println(fru);
		}
	}
	 

}
