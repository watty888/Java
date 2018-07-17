package a01449746.Bunyatov;

public enum Fertigkeit {
	MATHEMATIK(30),
	GEOGRAFIE(10),
	GESCHICHTE(),
	ENGLISCH(),
	FRANZOESISCH(),
	JAPANISCH(40),
	LITERATUR(),
	SPORT(10),
	PROGRAMMIEREN(40);
	
	private int grundwert;
	
	private Fertigkeit() {
		grundwert = 20;
	}
	
	private Fertigkeit(int wert){
		grundwert = wert;
	}
	
	int getBonuse(int stufe) {
		if (this == PROGRAMMIEREN) {
			return grundwert + stufe * 100;
		}
		return grundwert * stufe;
	}
	
	@Override
	public String toString() {
		String str = this.name();
		return str;
	}
}
