
import java.util.*;

public class Deck {
	
	private List<Karte> stappel = new ArrayList<Karte>();
	
	public Deck() {
		for (int farb = 0; farb < Karte.Farbe.values().length; ++farb) {
			for (int wert = 0; wert < Karte.Wert.values().length; ++wert) {
				stappel.add(new Karte(Karte.Farbe.values()[farb], Karte.Wert.values()[wert]));
			}
		}
	}
	
	void shuffle() {
		Collections.shuffle(stappel);
	}
	
	List<Karte> deal(List<Karte> player) {
		for (int i = 0; i < 2; ++i) {
			player.add(stappel.get(stappel.size() - 1));
			stappel.remove(stappel.size() - 1);
		}
		return player;
	}
	
	int size() {
		return stappel.size();
	}
	@Override
	public String toString() {
		return  "\n" + stappel;
	}

	
	
	
	
	
}
