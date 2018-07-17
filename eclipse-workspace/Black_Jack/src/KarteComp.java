import java.util.Comparator;

public class KarteComp implements Comparator<Karte> {

	@Override
	public int compare(Karte o1, Karte o2) {
		//farben sortieren
		if (o1.getFarbe().ordinal() < o2.getFarbe().ordinal())
			return -1;
		
		else if (o1.getFarbe().ordinal() > o2.getFarbe().ordinal()) 
			return 1;
		
		//werte sortieren
		if (o1.getFarbe().ordinal() == o2.getFarbe().ordinal())
			if (o1.getWert().ordinal() < o2.getWert().ordinal())
				return -1;
			else if (o1.getWert().ordinal() > o2.getWert().ordinal()) 
				return 1;

		return 0;
	}

}
