package JavaTutorial;

import java.util.Scanner;

public class Aufgabe3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("m = ");
		int m = s.nextInt();
		
		System.out.print("n = ");
		int n = s.nextInt();
		
		int out = (int) ((int) (m % Math.pow(10, n)) / Math.pow(10, n - 1));
		System.out.println(out);
		
		s.close();
	}
	
}
