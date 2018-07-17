
package JavaTutorial;

import java.util.Scanner;

public class Aufgabe4 {

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("m = ");
		int m = s.nextInt(); //123
		
		m = (m % 10) * 100 + ((m % 100)/ 10)* 10 + ((m % 1000)/ 100);
		System.out.print(m);
		
		s.close();

	}

}
