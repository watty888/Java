
package JavaTutorial;

import java.util.Scanner;

public class Aufgabe5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Jahren = ");
		int jahren = s.nextInt();
	
		System.out.print("Tagen = ");
		int tagen = s.nextInt();
		
		System.out.print("Stunden = ");
		int stunden = s.nextInt();
		
		System.out.print("Minuten = ");
		int minuten = s.nextInt(); 
		
		int sekunden = 60 * minuten + 60 * 60 * stunden + 60 * 60 * 24 * tagen + 60 * 60 * 24 * 365 * jahren;
		System.out.print("Sekunden = ");
		System.out.println(sekunden);
		s.close();
	}

}