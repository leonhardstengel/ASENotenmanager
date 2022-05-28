import java.util.ArrayList;

public class LectureService {
	private LectureRepositoryInterface lectureRepository;
	
	public LectureService(LectureRepositoryInterface lectureRepository) {
		this.lectureRepository = lectureRepository;
	}
	
	public Lecture getByName(LectureName name) throws LectureNotFoundException {
		Lecture l = this.lectureRepository.getByName(name);
		if(l == null) {
			throw new LectureNotFoundException(name);
		}
		return l;
	}
	
	public Lecture create(String name, int ects, int semester) throws InvalidLectureNameException, PersistException, InvalidSemesterException, InvalidEctsException {
		Lecture l = new Lecture(name, ects, semester);
		this.lectureRepository.save(l);
		return l;
	}
	
	public ArrayList<Lecture> getAll() {
		return this.lectureRepository.getAll();
	}
}
