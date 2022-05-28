public class Grade {
	private final double value;
	
	Grade(double grade) throws InvalidGradeException {
		if(grade < 1) {
			throw new InvalidGradeException("Grade too small");
		}
		if(grade > 6) {
			throw new InvalidGradeException("Grade too big");
		}
		this.value = grade;
	}

	public double getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grade grade = (Grade) o;
		return Double.compare(grade.value, value) == 0;
	}

	@Override
	public String toString() {
		return ""+this.value;
	}
}
