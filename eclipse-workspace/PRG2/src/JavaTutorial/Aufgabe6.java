
package JavaTutorial;

import java.util.Scanner;

public class Aufgabe6 {
	
	static int ggt(int a, int b) {
		if (b == 0) return a;
		else return ggt(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("a = ");
		int a = s.nextInt();
	
		System.out.print("b = ");
		int b = s.nextInt();
		
		System.out.print(ggt(a, b));
		
		s.close();
	}

}