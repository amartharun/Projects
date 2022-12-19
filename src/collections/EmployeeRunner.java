package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EmployeeRunner {

	public static void main(String[] args) {
	
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(10,"Amara",24,1000));
		emp.add(new Employee(11,"cmars",25,2334));
		emp.add(new Employee(12,"bmard",26,36));
		emp.add(new Employee(13,"tmarf",27,56));
		emp.add(new Employee(14,"hmarg",28,22));
		
//		Collections.sort(emp, new MySort());
//		System.out.println(emp);
		
		Collections.sort(emp, (o1,o2)-> (o2.getName().compareTo(o1.getName())));
		System.out.println(emp);
	}	 

}


//class MySort implements Comparator<Employee>{
//
//	@Override
//	public int compare(Employee o1,Employee o2) {
//		// TODO Auto-generated method stub
//		return (int) (o1.getSalary()-o2.getSalary());
//	}
//
//
//}
