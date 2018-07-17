package test;

public class Bruch implements Comparable<Bruch>{
	int numerator;
	int denominator;
	
	public Bruch() {
		this.numerator = 0;
		this.getDenominator();
	}
	
	public Bruch(int nominator, int denumerator) {
		super();
		this.numerator = nominator;
		this.denominator = denumerator;
	}

	@Override
	public String toString() {
		return getNumerator() + "/" + getDenominator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bruch other = (Bruch) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	@Override
	public int compareTo (Bruch other) { 
		if (other.getClass() != getClass())
			throw new ClassCastException();
		
		System.out.println(Integer.compare(this.numerator, other.numerator));
		
		return 0;
		
		//return (int)(kontoStand -((Konto)other).kontoStand);
	}


}
