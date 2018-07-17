package a01449746.Bunyatov;

import java.io.Serializable;
//import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Person extends PersonComparator implements Comparable<Object>, KannSpringen, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	
	private int alter;
	int groesse;
	double gewicht;
	
	Map <Fertigkeit, Integer> fertigkeiten = new TreeMap<Fertigkeit, Integer>();

	private final int MIN_ALTER = 10, MAX_ALTER = 100;
	private final int MIN_GROESSE = 100, MAX_GROESSE = 250;
	private final double MIN_GEWICHT = 20., MAX_GEWICHT = 300.;
	
	
	public Person(String vn, String nn, int alt, int gr, int gw, Set<Fertigkeit> s) {
		
		if (alt < MIN_ALTER || alt > MAX_ALTER || gr < MIN_GROESSE || gr > MAX_GROESSE || gw < MIN_GEWICHT || gw > MAX_GEWICHT )
			throw new IllegalArgumentException("Alter: nur zwischen 10 und 100 (inklusiv) \n"
								  + "Groesse: nur zwischen 100 und 250 (inklusiv)\n"
								  + "Gewicht: nur zwischen 20 und 300 (inklusiv)");
			
			
		setVorname(vn);
		setNachname(nn);
		setAlter(alt);
		setGroesse(gr);
		setGewicht(gw);
		
		for (Fertigkeit f : s)
			addFertigkeit(f);
				
	}
	
	public Person(String vn, String nn){
		setVorname(vn);
		setNachname(nn);
		setAlter(25);
		setGroesse(170);
		setGewicht(70);
	}
	
	boolean aelterAls(Person p) {
		if (alter > p.alter) 
			return true;
		else 
			return false;
	}
	
	boolean groesserAls(Person p) {
		if (groesse > p.groesse) 
			return true;
		else 
			return false;
	}
	
	boolean schwererAls(Person p) {
		if (gewicht > p.gewicht) 
			return true;
		else 
			return false;
	}
	
	boolean lernen(Person p, Fertigkeit f) {
		if (this.fertigkeiten.containsKey(f)) {
			System.out.println(this.getVorname() + ": " + f.name() + " schon beherrscht!");
			return false;
		}
		
		if (!p.fertigkeiten.containsKey(f) ) {
			System.out.println(p.getVorname() + " kennt " + f.name() + " nicht");
			return false;
		}
		
		for (Fertigkeit fl : fertigkeiten.keySet()) {
			if (!p.fertigkeiten.containsKey(fl)) {
				p.addFertigkeit(fl);
				System.out.println(p.getVorname() + " hat " + fl.name()	+ " gelernt");
				this.addFertigkeit(f);
				System.out.println(this.getVorname() + " hat " + f.name()	+ " gelernt");
				return true;
			}
		}
		
		System.out.println(this.getVorname() + " kann nichts im Austausch geben!");
		return false;	
	}
	
	boolean trainieren(Fertigkeit f) {
		if (fertigkeiten.keySet().contains(f)) {
			fertigkeiten.put(f, fertigkeiten.get(f) + 1);
			return true;
		}
		
		System.out.println(this.getVorname() + ": die Fertigkeit " + f.name() + " muss zuersst beherrscht werden!");
		return false;
	}
		
	
	@Override
	public String toString() {
		String toStr = "Person -> ";
		toStr += "[ vn = " + vorname + ", "
					+  "nn = " + nachname + ", "
					+  "age = " + alter + ", "
					+  "sz = " + groesse + ", "
					+  "wg = " + gewicht + ", "
					+  "map = { ";
		
		int count = 0;
		for (Fertigkeit f : fertigkeiten.keySet()) {
			toStr += f.name() + " = " + fertigkeiten.get(f);
			++count;
			if (count < fertigkeiten.size())
				toStr += ", ";
			
		}
		
		toStr += " } ]";
		
		return toStr;
	}
	
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}
	
	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}
	
	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}	
	
	void addFertigkeit(Fertigkeit f) {
		fertigkeiten.put(f, 0);
	}


	@Override
	public int compareTo(Object o) {
		Person p=(Person)o;
		return getAlter()-p.getAlter();
	}

	@Override
	public int hoehe() {
		return this.getGroesse() - 10;
	}

	public static KannSpringen find(Person[] persons) {
		int maxJumpIdx = 0;
		
		for (int i = 1; i < persons.length; ++i) {
			if (persons[i] != null) {
				if (persons[i].hoehe() > persons[maxJumpIdx].hoehe())
					maxJumpIdx = i;
			}
			
		}
		System.out.println("The highest jumper is: ");
		return persons[maxJumpIdx];
		
	}

}
