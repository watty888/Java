package JavaTutorial;

import java.util.Scanner;

public class Aufgabe2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Artikelpreis eingeben: ");
		int artikelpreis = s.nextInt();
		
		System.out.print("Anzahl eingeben: ");
		int anzahl = s.nextInt();
		
		System.out.print("Mehrwertsteuersatz eingeben: ");
		double MWS = s.nextInt() / 100. + 1.;
		
		System.out.print(MWS);

		double gesamtsumme = MWS * (artikelpreis * anzahl);
		
		System.out.println(gesamtsumme); // check why double has dot after 6th digit???
	
		s.close();
	}
}
