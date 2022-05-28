
public class Exam {
	private ExamTitle title;
	private Weight weight;
	private Grade grade;
	private LectureName lecture;
	
	Exam(String title, double weight, double grade, LectureName lecture) throws InvalidGradeException, InvalidWeightException, InvalidExamTitleException, InvalidLectureNameException {
		this.title = new ExamTitle(title);
		this.weight = new Weight(weight);
		this.grade = new Grade(grade);
		this.lecture = lecture;
	}
	
	public ExamTitle getTitle() {
		return title;
	}
	public Weight getWeight() {
		return weight;
	}
	public Grade getGrade() {
		return grade;
	}

	public LectureName getLecture() {
		return lecture;
	}

	@Override
	public String toString() {
		return ""+this.title + " " + this.lecture + "\t: Grade " + this.grade + ", Weight " + this.weight;
	}
}
