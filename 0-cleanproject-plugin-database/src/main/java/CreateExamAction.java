import IO.CommandLineReader;

public class CreateExamAction implements ActionInterface {

	ExamService examService;
	LectureService lectureService;

	CreateExamAction() {
		LectureRepository lectureRepository = new LectureRepository();
		this.lectureService = new LectureService(lectureRepository);

		ExamRepository examRepository = new ExamRepository();
		this.examService = new ExamService(examRepository, lectureRepository);
	}

	@Override
	public void execute() {
		System.out.println("Enter the lecture the exam was about:");
        String lecture = CommandLineReader.readLine();
        
		System.out.println("Enter a exam description:");
        String title = CommandLineReader.readLine();
        
		System.out.println("Enter the grade (1-6):");
        String gradeString = CommandLineReader.readLine();
        
		System.out.println("Enter the weight (0-1):");
        String weightString = CommandLineReader.readLine();
        
        try {
        	double grade = Double.parseDouble(gradeString);
        	double weight = Double.parseDouble(weightString);
            this.examService.create(title, weight, grade, new LectureName(lecture));
        } catch(Exception e) {
        	System.out.println(e);
        }
	}

}
