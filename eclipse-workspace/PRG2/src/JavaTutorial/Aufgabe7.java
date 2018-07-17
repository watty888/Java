package JavaTutorial;

public class Aufgabe7 {

	public static class Flugzeug {
		private int passagieren = 0;
		private int maxPassagieren = 120;
		private int leistung = 50000; //kW
		private String startFH = "N/A";
		private String zielFH = "N/A";
		
		Flugzeug () {}
		Flugzeug (int psg, int maxpsg, int lst, String SFH, String ZFH) {
			passagieren = psg;
			maxPassagieren = maxpsg;
			leistung = lst;
			startFH = SFH;
			zielFH = ZFH;
		}
		
		void setPassagieren (int psg) { passagieren = psg; }
		void setMaxPassagieren (int mxPsg) { maxPassagieren = mxPsg; }
		void setLeistung (int lst) 	{ leistung = lst; }
		void setStartFH (String SFH) { startFH = SFH; }
		public void setZielFH (String ZFH) 	{ zielFH = ZFH; }
		
		int getPassagieren()    { return passagieren; }
		int getMaxPassagieren() { return maxPassagieren; }
		int getLeistung()   { return leistung; }
		String getStartFH() { return startFH; }
		String getZielFH () { return zielFH; }
		
		void aussteigen(int anzahl) throws Exception {
			if (anzahl > passagieren)
				throw new Exception( "Gewuenschte anzahl von austeigenden ist zu hoch!");
			
			passagieren -= anzahl;
		}
		
		void einsteigen(int anzahl) throws Exception {
			if (anzahl > maxPassagieren)
				throw new Exception("Gewuenschte anzahl von einsteigenden ist zu hoch!");
			
			passagieren += anzahl;
		}
		
		void landen(String flughafenNeu) throws Exception {
			aussteigen(passagieren);
			startFH = zielFH;
			zielFH = flughafenNeu;
		}
		
		void print() {
			System.out.println("Passagieren an Bord: " + passagieren);
			System.out.println("Max Passagieren erlaubt: " + maxPassagieren);
			System.out.println("Leistung: " + leistung);
			System.out.println("Start FLughaffen: " + startFH);
			System.out.println("Ziel FLughaffen: " + zielFH);
		}
	
	}
	public static void main(String[] args) throws Exception {
		Flugzeug boeing = new Flugzeug();
		boeing.print();
		System.out.println("");
		
		boeing = new Flugzeug(67, 90, 45000, "Berlin", null);
		boeing.print();
		System.out.println("");
		
		boeing.landen("Costa-Rica");
		boeing.print();
	}

}
