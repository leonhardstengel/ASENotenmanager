import IO.CommandLineReader;

public class CalculateGradesAction implements ActionInterface {

	GradeService gradeService;

	CalculateGradesAction() {
		LectureRepository lectureRepository = new LectureRepository();
		ExamRepository examRepository = new ExamRepository();
		this.gradeService = new GradeService(examRepository, lectureRepository);
	}
	
	@Override
	public void execute() {
		System.out.println("Enter a lecture or 'ALL' for the overall grade:");
        String input = CommandLineReader.readLine();
        try {
        	Grade grade;
        	if(input.equalsIgnoreCase("ALL")) {
            	grade = this.gradeService.calculateGeneralGrade();
            } else {
            	grade = this.gradeService.calculateGradeForLecture(new LectureName(input));
            }
            System.out.println("Your Grade for '"+input+"' currently is " + grade);
        } catch (Exception e) {
        	System.out.println(e);
        }
	}

}
