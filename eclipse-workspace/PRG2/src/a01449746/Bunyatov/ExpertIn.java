package a01449746.Bunyatov;

import java.util.*;
//import java.util.TreeSet;

public class ExpertIn extends Person implements KannSpringen {
	
	private final Set<Fertigkeit> expert = new TreeSet<Fertigkeit>();
	
	ExpertIn(String vn, String nn, int alt, int gr, int gw, Set<Fertigkeit> s, Set<Fertigkeit> ex) {
		super(vn, nn, alt, gr, gw, s);
		
		if (ex.size() > 3)
			throw new IllegalArgumentException("Maximum 3 Spezialisierungen moeglich!");
		
		expert.addAll(ex);
	}
	
	@Override 
	boolean trainieren(Fertigkeit f) {
		if (expert.contains(f)) {
			super.trainieren(f);
			super.trainieren(f);
		}
		return super.trainieren(f);
	}
	
	@Override
	public int hoehe() {
		if (expert.contains(Fertigkeit.PROGRAMMIEREN)) {
			return super.getGroesse() - 20;
		}
		return super.hoehe();
	}

}
