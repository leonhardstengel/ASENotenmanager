import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExamServiceTest {

	private static LectureRepositoryInterface lectureRepository;
	private static ExamRepositoryInterface examRepository;

	private static LectureService lectureService;
	private static ExamService examService;

	private static Lecture lecture;
	private static Exam exam;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		lectureRepository = new MockLectureRepository();
		examRepository = new MockExamRepository();
		lecture = new Lecture("Test1", 5, 1);
		lectureRepository.save(lecture);

		Lecture lecture2 = new Lecture("Test2", 5, 1);
		lectureRepository.save(lecture2);

		exam = new Exam("Klausur", 1.0, 1.5, lecture.getName());
		examRepository.save(exam);
		Exam exam2 = new Exam("Ex", 1.0, 1.5, lecture2.getName());
		examRepository.save(exam2);
		
		lectureService = new LectureService(lectureRepository);
		examService = new ExamService(examRepository, lectureRepository);
	}
	
	@Test
	void testGetByLecture() {
		assertDoesNotThrow(() -> {
			ArrayList<Exam> exams = examService.getByLecture(lecture);
			for(Exam e: exams) {
				assertEquals(lecture.getName(), e.getLecture());
			}
		});
	}

	@Test
	void testValidCreate() {
		assertDoesNotThrow(() -> {
			examService.create("Klausur", 1.0, 5.3, lecture.getName());
		});
	}

	@Test
	void testInvalidCreate() {
		assertThrows(LectureNotFoundException.class, () -> {
			examService.create("Klausur", 1.0, 5.3, new LectureName("ABC"));
		});
	}

}
