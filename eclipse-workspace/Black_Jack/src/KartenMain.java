import java.util.*;

public class KartenMain {
	
	public static void main(String[] args) {
		
		List<Karte> stappel = new ArrayList<>();
		
		for (int farb = 0; farb < Karte.Farbe.values().length; ++farb) {
			for (int wert = 0; wert < Karte.Wert.values().length; ++wert) {
				stappel.add(new Karte(Karte.Farbe.values()[farb], Karte.Wert.values()[wert]));
			}
		}
		
		Collections.shuffle(stappel);
		
		System.out.println(stappel);
		
		
		//Collections.sort(stappel);
		stappel.sort(new KarteComp());
		
		
		System.out.println(stappel);
		
		
		

	}

}
