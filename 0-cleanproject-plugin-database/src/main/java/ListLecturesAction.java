import java.util.ArrayList;

public class ListLecturesAction implements ActionInterface {

	LectureService lectureService;

	ListLecturesAction() {
		LectureRepository lectureRepository = new LectureRepository();
		this.lectureService = new LectureService(lectureRepository);
	}

	@Override
	public void execute() {
		System.out.println("Your lectures:");
		ArrayList<Lecture> lectures = this.lectureService.getAll();
		for (Lecture l : lectures) {
			System.out.println(l.toString());
		}
	}

}
