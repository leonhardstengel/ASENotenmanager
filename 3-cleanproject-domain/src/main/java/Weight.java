
public class Weight {
	private final double value;
	
	Weight(double weight) throws InvalidWeightException {
		if(weight < 0) {
			throw new InvalidWeightException("Weight too small");
		}
		if(weight > 1) {
			throw new InvalidWeightException("Weight too big");
		}
		this.value = weight;
	}

	public double getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Weight weight = (Weight) o;
		return Double.compare(weight.value, value) == 0;
	}

	@Override
	public String toString() {
		return ""+this.value;
	}
}
