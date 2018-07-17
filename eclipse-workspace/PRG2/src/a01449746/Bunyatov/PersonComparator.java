package a01449746.Bunyatov;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getAlter() - o2.getAlter();
		//return o1.getGroesse() - o2.getGroesse();
		//return o1.getNachname().compareTo(o2.getNachname());
	}
	
//	@Override
//	public int compare(Person p1, Person p2) {
//		return p1.getGroesse() - p2.getGroesse();
//	}
}
