public class Lecture {
	private LectureName name;
	private Ects ects;
	private Semester semester;

	Lecture(String name, int ects, int semester) throws InvalidLectureNameException, InvalidSemesterException, InvalidEctsException {
		this.name = new LectureName(name);
		this.ects = new Ects(ects);
		this.semester = new Semester(semester);
	}

	public LectureName getName() {
		return name;
	}

	public Ects getEcts() {
		return ects;
	}

	public Semester getSemester() {
		return semester;
	}

	@Override
	public String toString() {
		return ""+this.name + ": " + ects + "ECTS, Semester " + semester;
	}
}