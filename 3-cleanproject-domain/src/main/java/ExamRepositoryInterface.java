import java.util.ArrayList;

public interface ExamRepositoryInterface {
	void save(Exam exam) throws PersistException;
	ArrayList<Exam> getByLecture(Lecture lecture);
	ArrayList<Exam> getAll();
}
