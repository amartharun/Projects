package test;

import java.time.*;

public class Amar {

	public static void main(String[] args) {
		/*String test="amarthyanadh";
		System.out.println(test.charAt(0));
		String largeText="I'm working in TCS";
		System.out.println(largeText.substring(5));
		System.out.println(largeText.indexOf("in"));
		System.out.println(largeText.lastIndexOf('i'));
		System.out.println(largeText.contains("in"));
		System.out.println(!test.equalsIgnoreCase("AMarthyanadh"));
		if(!test.equals("Amar")) {
			System.out.println("Inside");
		}
		else {
			System.out.println("outside");
		}
		LocalDate now = LocalDate.now();
		System.out.println(now);
		LocalDate before=now.minusYears(2);
		System.out.println(before);*/
		try{
		    Float f1=new Float("3.0");
		    int x=f1.intValue();
		    byte b=f1.byteValue();
		    double d=f1.doubleValue();
		    System.out.println(x+b+d);
		}
		catch (NumberFormatException e)
		{
		    System.out.println("bad number");
		}
		
	}
	
}
