import java.util.ArrayList;

public class MockLectureRepository implements LectureRepositoryInterface {
	
	ArrayList<Lecture> lectures = new ArrayList<Lecture>();
	
	public void save(Lecture lecture) throws PersistException {
		lectures.add(lecture);
	}

	public Lecture getByName(LectureName name) {
		for(Lecture lecture: lectures) {
			if(lecture.getName().equals(name)) {
				return lecture;
			}
		}
		return null;
	}

	public ArrayList<Lecture> getAll() {
		return lectures;
	}

}
