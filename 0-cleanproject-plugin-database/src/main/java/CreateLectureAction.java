import IO.CommandLineReader;

public class CreateLectureAction implements ActionInterface {

	LectureService lectureService;

	CreateLectureAction() {
		LectureRepository lectureRepository = new LectureRepository();
		this.lectureService = new LectureService(lectureRepository);
	}

	@Override
	public void execute() {
		System.out.println("Enter the unique lecture name:");
        String name = CommandLineReader.readLine();
        
		System.out.println("Enter the amount of ECTS points for this lecture:");
        String ectsString = CommandLineReader.readLine();
        
		System.out.println("Enter the semester this lecture takes place in:");
        String semesterString = CommandLineReader.readLine();
        
        try {
        	int ects = Integer.parseInt(ectsString);
        	int semester = Integer.parseInt(semesterString);
            this.lectureService.create(name, ects, semester);
        } catch(Exception e) {
        	System.out.println(e);
        }
	}
}
