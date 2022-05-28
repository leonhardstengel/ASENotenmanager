import java.util.Objects;

public class LectureName {
	private final String value;
	
	LectureName(String name) throws InvalidLectureNameException {
		if(name.length() < 2) {
			throw new InvalidLectureNameException("'"+name+"' is too short");
		}
		if(name.length() > 30) {
			throw new InvalidLectureNameException("'"+name+"' is too long");
		}
		if(name.equalsIgnoreCase("all")) {
			throw new InvalidLectureNameException("'"+name+"' is not allowed");
		}
		this.value = name;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LectureName that = (LectureName) o;
		return Objects.equals(value, that.value);
	}
}
