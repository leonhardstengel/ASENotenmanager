import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LectureServiceTest {

	private static LectureRepositoryInterface lectureRepository;
	
	private static LectureService lectureService;
	
	private static ArrayList<Lecture> lectures;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		lectureRepository = new MockLectureRepository();
		Lecture a = new Lecture("Test1", 5, 1);
		Lecture b = new Lecture("Test2", 7, 2);
		Lecture c = new Lecture("Test3", 6, 3);
		lectureRepository.save(a);
		lectures = new ArrayList<Lecture>();
		lectures.add(a);
		lectureRepository.save(b);
		lectures.add(b);
		lectureRepository.save(c);
		lectures.add(c);
		
		lectureService = new LectureService(lectureRepository);
	}

	@Test
	void testGetByName() {
		assertDoesNotThrow(() -> {
			for(Lecture l: lectures) {
				Lecture lec = lectureService.getByName(l.getName());
				assertEquals(l, lec);
			}
		});
	}
	
	@Test
	void testGetNonExistentLecture() {
		assertDoesNotThrow(() -> {
			Lecture l = new Lecture("Test4", 5, 5);
			assertThrows(LectureNotFoundException.class, () -> lectureService.getByName(l.getName()));
		});
	}

	@Test
	void testCreate() {
		assertDoesNotThrow(() -> {
			lectureService.create("Test4", 5, 5);
			Lecture l = lectureService.getByName(new LectureName("Test4"));
			assertEquals(new LectureName("Test4"), l.getName());
			assertEquals(new Ects(5), l.getEcts());
			assertEquals(new Semester(5), l.getSemester());
		});
	}

	@Test
	void testGetAll() {
		assertEquals(3, lectureService.getAll().size());
	}

}
