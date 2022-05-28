
import java.util.ArrayList;

public class ExamService {
	private ExamRepositoryInterface examRepository;
	private LectureRepositoryInterface lectureRepository;
	
	public ExamService(ExamRepositoryInterface examRepository, LectureRepositoryInterface lectureRepository) {
		this.examRepository = examRepository;
		this.lectureRepository = lectureRepository;
	}
	
	public Exam create(String title, double weight, double grade, LectureName lecture) throws InvalidGradeException, InvalidWeightException, InvalidExamTitleException, PersistException, InvalidLectureNameException, LectureNotFoundException {
		Lecture l = this.lectureRepository.getByName(lecture);
		if(l == null) {
			throw new LectureNotFoundException(lecture);
		}
		Exam e = new Exam(title, weight, grade, lecture);
		this.examRepository.save(e);
		return e;
	}
	
	public ArrayList<Exam> getAll() {
		return this.examRepository.getAll();
	}
	
	public ArrayList<Exam> getByLecture(Lecture l) {
		return this.examRepository.getByLecture(l);
	}
}
