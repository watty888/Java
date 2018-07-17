package JavaTutorial;

import java.util.Scanner;

public class Aufgabe1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Laenge eingeben: ");
		int laenge = s.nextInt();

		System.out.print("Laenge eingeben: ");
		int breite = s.nextInt();	
		System.out.println("");

		int umfang = 2 * (laenge + breite);
		int flaeche = laenge * breite;

		System.out.print("Umfang = " + umfang);
		System.out.println("Flaeche = " + flaeche);
		
		s.close();
	}
}
