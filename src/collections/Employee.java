package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private long salary;
	
	
	Employee(int id, String name, int age,long salary){
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id=id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
		
		
//		public void display() {
//			System.out.println(id+" "+name+" "+" "+age+" "+salary);
//		}

	 

}
