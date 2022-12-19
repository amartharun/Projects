package Practise;

public class Constructor {

	int id;
	String name;
	int age;

	Constructor(int id, String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}

	Constructor(/*Constructor s*/) {
		//		id=s.id;
		//		name=s.name;
		//		age=s.age;
	}

	void display() {
		System.out.println(id+name+age);
	}

	public static void main(String[] args) {
		Constructor c= new Constructor(1, "Amar", 10);
		Constructor c1= new Constructor();
		c1.id=c.id;
		c1.name=c.name;
		c1.age=c.age;
		c1.display();
		c.display();
	}

}
