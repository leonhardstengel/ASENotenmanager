import java.util.ArrayList;

public class ListExamsAction implements ActionInterface {

	ExamService examService;

	ListExamsAction() {
		LectureRepository lectureRepository = new LectureRepository();
		
		ExamRepository examRepository = new ExamRepository();
		this.examService = new ExamService(examRepository, lectureRepository);
	}

	@Override
	public void execute() {
		System.out.println("Your exams:");
		ArrayList<Exam> exams = this.examService.getAll();
		for (Exam e : exams) {
			System.out.println(e.toString());
		}
	}

}
