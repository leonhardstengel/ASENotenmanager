import java.util.ArrayList;

public class MockExamRepository implements ExamRepositoryInterface {

	private ArrayList<Exam> exams = new ArrayList<Exam>();
	
	public void save(Exam exam) throws PersistException {
		exams.add(exam);
	}

	public ArrayList<Exam> getByLecture(Lecture lecture) {
		ArrayList<Exam> es = new ArrayList<Exam>();
		for(Exam e: exams) {
			if(e.getLecture().equals(lecture.getName())) {
				es.add(e);
			}
		}
		return es;
	}

	public ArrayList<Exam> getAll() {
		return exams;
	}

}
