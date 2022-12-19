package collections;

import java.util.*;

public class HashMap {

	public static void main(String[] args) {

		Map<String, Integer> number = new java.util.HashMap<>();
		
		number.put("one", 1);
		number.put("sd", 2);
		number.put("fsd", 3);
		number.put("df", 4);
		
		System.out.println(number);
		
		
		Set<String> keys = number.keySet();
		System.out.println(keys);
			
		
		Collection<Integer> value= number.values();
		System.out.println(value);
		
		
		
		for(Map.Entry<String, Integer> entry: number.entrySet()) {
			
		}
		}

	}
