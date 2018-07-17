

public class Karte extends KarteComp implements Comparable<Karte> {
	
	public enum Farbe { HERZ, KARO, PIK, TREFF; }

	public enum Wert {  
		TWO(2), 
		THREE(3), 
		FOUR(4), 
		FIVE(5), 
		SIX(6), 
		SEVEN(7),
		EIGHT(8), 
		NINE(9), 
		TEN(10),
		JACK(11),
		QUEEN(12), 
		KING(13),
		ACE(14); 
		
		private final int value;
		
	    Wert(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	    
	}
	
	private Farbe farbe;
    private Wert wert;
    
    Karte(Farbe f, Wert w) {
    	this.setFarbe(f);
    	this.setWert(w);
    }

	public Farbe getFarbe() {
		return farbe;
	}

	@Override
	public String toString() {
		return farbe + " " + wert;
	}

	public void setFarbe(Farbe farbe) {
		this.farbe = farbe;
	}

	public Wert getWert() {
		return wert;
	}

	public void setWert(Wert wert) {
		this.wert = wert;
	}

	@Override
	public int compareTo(Karte o) {
		//farben sortieren
		if (this.farbe.ordinal() < o.farbe.ordinal())
			return -1;
		
		else if (this.farbe.ordinal() > o.farbe.ordinal()) 
			return 1;
		
		//werte sortieren
		if (this.farbe.ordinal() == o.farbe.ordinal())
			if (this.wert.ordinal() < o.wert.ordinal())
				return -1;
			else if (this.wert.ordinal() > o.wert.ordinal()) 
				return 1;
		return 0;
		
	}
	
	
}
