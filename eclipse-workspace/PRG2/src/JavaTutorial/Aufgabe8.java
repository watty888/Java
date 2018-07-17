package JavaTutorial;

import java.util.*;

public class Aufgabe8 {
	
	private enum BaumTyp { BUCH, EICHE, MAHAGONI, DEFAULT }
	
	public static class Lager {
//////////////////INTERFACE//////////////////////////////////////////////////////////////////////
		private class Brett {
			@SuppressWarnings("unused")
			BaumTyp typ = BaumTyp.DEFAULT;
			int laenge = 0; //cm	
		}
		
		private Vector<Brett> buche;
		private Vector<Brett> eiche;
		private Vector<Brett> mahagoni;
		
		private boolean addBrett(char sort, int len) throws Exception {
			Brett brett = new Brett();
			brett.laenge = len;
			
			switch(sort) {
				case 'b': brett.typ = BaumTyp.BUCH; buche.addElement(brett); return true;
				case 'e': brett.typ = BaumTyp.EICHE; eiche.addElement(brett); return true;
				case 'm': brett.typ = BaumTyp.MAHAGONI; mahagoni.addElement(brett); return true;
				
				default: throw new Exception("Falsche Angabe!");
			}
		}
		
		private void addMultiple(char sort, int anzahl, int len) throws Exception {
			for (int i = 0; i < anzahl; ++i) { addBrett(sort, len); }
		}
		private void addMultiple(char sort1, int anzahl1, int len1,
								 char sort2, int anzahl2, int len2) throws Exception 
		{
			addMultiple(sort1, anzahl1, len1);
			addMultiple(sort2, anzahl2, len2);
		}
		private void addMultiple(char sort1, int anzahl1, int len1,
				 				 char sort2, int anzahl2, int len2,
				 				 char sort3, int anzahl3, int len3) throws Exception 
		{		
			addMultiple(sort1, anzahl1, len1);
			addMultiple(sort2, anzahl2, len2);
			addMultiple(sort3, anzahl3, len3);
		}
		
		private void schneiden(Brett b, int len) throws Exception { 
			if (len > b.laenge)
				throw new Exception("Kann nicht zersaegen!");
			b.laenge -= len;
		}
		
		private Brett findShortestMatch(Vector<Brett> v, int len) { 
			Brett match = v.get(0);
			for (Brett b : v) {
				if (b.laenge - len <  match.laenge - len)
					match = b;
			}
			return match;
		}

		private void remove(Vector<Brett> v, int len) {
			for (int i = 0; i < v.size(); ++i)
				if (v.get(i).laenge <= len)
					v.remove(i);
		}
		
/////////////////////////////PUBLIC METHODS//////////////////////////////////////////////////////////////		
		
		Lager() {
			buche = new Vector<Brett>();
			eiche = new Vector<Brett>();
			mahagoni = new Vector<Brett>();
		}
		
		void einkauf(char sort, int anz, int len) throws Exception { addMultiple(sort, anz, len); }
		void einkauf(char sort1, int anz1, int len1,
					 char sort2, int anz2, int len2) throws Exception 
		{ 
			addMultiple(sort1, anz1, len1, sort2, anz2, len2); 
		}
		void einkauf(char sort1, int anz1, int len1,
				 	 char sort2, int anz2, int len2,
				 	 char sort3, int anz3, int len3) throws Exception 
		{ 
			addMultiple(sort1, anz1, len1, sort2, anz2, len2, sort3, anz3, len3); 
		}
		
		void verkauf(char sort, int len) throws Exception {
			switch(sort) {
				case 'b': schneiden(findShortestMatch(buche, len), len); break;
				case 'e': schneiden(findShortestMatch(eiche, len), len); break;
				case 'm': schneiden(findShortestMatch(mahagoni, len), len); break;
				default: throw new Exception("Falsche Eingabe!");
			}
		}
		
		
		void aufraumen(int len, char sort) throws Exception {
			switch(sort) {
				case 'b': remove(buche, len); break;
				case 'e': remove(eiche, len); break;
				case 'm': remove(mahagoni, len); break;
				default: throw new Exception("Falsche Eingabe!");
			}
		}
		void bestand() {
			System.out.println("Buche list (" + buche.size() + " Bretten):");
			
			for (int i = 0; i < buche.size(); ++i) {
				System.out.println("no." + i + ": " + buche.get(i).laenge + " cm");
			}
			System.out.println();
			
			System.out.println("Eiche list (" + eiche.size() + " Bretten):");
			
			for (int i = 0; i < eiche.size(); ++i) {
				System.out.println("no." + i + ": " + eiche.get(i).laenge + " cm");
			}
			System.out.println();
			
			System.out.println("Mahagoni list (" + mahagoni.size() + " Bretten):");
			
			for (int i = 0; i < mahagoni.size(); ++i) {
				System.out.println("no." + i + ": " + mahagoni.get(i).laenge + " cm");
			}
		}		
	}

	public static void main(String[] args) throws Exception {
		Lager lag = new Lager();
		
		lag.bestand();
		
		lag.einkauf('b', 20, 200, 'e', 18, 230, 'm', 10, 150);
		
		lag.bestand();
		
		lag.verkauf('m', 100);
		lag.verkauf('m', 40);
		
		
		lag.bestand();
		
		lag.aufraumen(10, 'm');
		lag.bestand();
	}
}
