import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectureNameTest {

	@Test
	@DisplayName("Invalid values for LectureName")
	void testInvalidValues() {
		assertThrows(Exception.class, () -> new LectureName("A"));
		assertThrows(Exception.class, () -> new LectureName("abcdefghihjklmnophazenvhdncjsjcndhksjebfsnskheidnskxj"));
		assertThrows(Exception.class, () -> new LectureName("ALL"));
		assertThrows(Exception.class, () -> new LectureName("aLl"));
	}

	@Test
	@DisplayName("Valid values for Grade")
	void testValidValues() {
		assertDoesNotThrow(() -> new LectureName("Mathematik I"));
		assertDoesNotThrow(() -> new LectureName("T3_3000 Theo"));
		assertDoesNotThrow(() -> new LectureName("Alll"));
	}
	
	@Test
	@DisplayName("test getter")
	void testGetter() {
		assertDoesNotThrow(() -> {
			String name = "Theoretische";
			LectureName ln = new LectureName(name);
			assertEquals(name, ln.toString());
		});
	}

}
