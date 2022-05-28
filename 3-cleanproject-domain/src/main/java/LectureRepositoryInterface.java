import java.util.ArrayList;

public interface LectureRepositoryInterface {
	void save(Lecture lecture) throws PersistException;
	Lecture getByName(LectureName name);
	ArrayList<Lecture> getAll();
}
