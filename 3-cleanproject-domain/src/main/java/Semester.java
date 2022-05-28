public class Semester {
	private final int value;

	Semester(int semester) throws InvalidSemesterException {
		if(semester < 1) {
			throw new InvalidSemesterException("'"+semester+"' is too low");
		}
		if(semester > 12) {
			throw new InvalidSemesterException("'"+semester+"' is too high");
		}
		this.value = semester;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return ""+this.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Semester semester = (Semester) o;
		return value == semester.value;
	}

}
