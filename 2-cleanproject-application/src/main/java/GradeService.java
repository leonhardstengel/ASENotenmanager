import java.util.ArrayList;

public class GradeService {
	
	private ExamRepositoryInterface examRepository;
	private LectureRepositoryInterface lectureRepository;
	
	public GradeService(ExamRepositoryInterface examRepository, LectureRepositoryInterface lectureRepository) {
		this.examRepository = examRepository;
		this.lectureRepository = lectureRepository;
	}
	
	public Grade calculateGradeForLecture(LectureName lectureName) throws InvalidGradeException, NoGradesException, LectureNotFoundException, ExamNotFoundException {
		Lecture lecture = this.lectureRepository.getByName(lectureName);
		if(lecture == null) {
			throw new LectureNotFoundException(lectureName);
		}
		ArrayList<Exam> exams = examRepository.getByLecture(lecture);
		if(!exams.isEmpty()) {
			return getGrade(exams);
		} else {
			throw new ExamNotFoundException();
		}
	}

	private Grade getGrade(ArrayList<Exam> exams) throws InvalidGradeException {
		double tmpGrade = 0;
		double sumWeight = 0;
		for(Exam exam : exams) {
			sumWeight += exam.getWeight().getValue();
			tmpGrade += exam.getWeight().getValue() * exam.getGrade().getValue();
		}
		double grade = tmpGrade/sumWeight;
		return new Grade(grade);
	}

	public Grade calculateGeneralGrade() throws InvalidGradeException, NoGradesException {
		ArrayList<Exam> exams = examRepository.getAll();
		if(!exams.isEmpty()) {
			int sumEcts = 0;
			double tmpGrade = 0;
			for(Exam exam : exams) {
				Lecture lecture = this.lectureRepository.getByName(exam.getLecture());
				sumEcts += lecture.getEcts().getValue();
				tmpGrade += exam.getWeight().getValue() * lecture.getEcts().getValue() * exam.getGrade().getValue();
			}
			double grade = tmpGrade/sumEcts;
			return new Grade(grade);
		} else {
			throw new NoGradesException();
		}
	}
}