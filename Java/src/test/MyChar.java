package test;

public class MyChar {

	private char ch;

	public MyChar(char ch) {
		// TODO Auto-generated constructor stub
		this.ch=ch;
	}

	public boolean isVowel() {
		// TODO Auto-generated method stub
		if(ch=='a' || ch=='e'|| ch=='i'||ch=='o'||ch=='u') {
			return true;
		}
		return false;
	}
}
