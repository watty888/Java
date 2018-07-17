package testvorbereitung;

import a01449746.Bunyatov.Person;

public interface TestInterface {
	
	default void changePerson(Person p) {
		p.setAlter(44);
	}

}
