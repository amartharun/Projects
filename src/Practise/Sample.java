package Practise;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		int n = 2020;
		int a = (n/10)*10;
		int b= a+10;
		if(n-a > b-n) {
			System.out.println(b);
		}
		else {
			System.out.println(a);
		}
	}
}