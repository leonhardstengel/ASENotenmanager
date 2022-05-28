import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

	@Test
	@DisplayName("Invalid values for Grade")
	void testInvalidValues() {
		assertThrows(Exception.class, () -> new Grade(-1));
		assertThrows(Exception.class, () -> new Grade(0.9));
		assertThrows(Exception.class, () -> new Grade(6.1));
		assertThrows(Exception.class, () -> new Grade(Integer.MAX_VALUE));
	}

	@Test
	@DisplayName("Valid values for Grade")
	void testValidValues() {
		assertDoesNotThrow(() -> new Grade(1.0));
		assertDoesNotThrow(() -> new Grade(3.3453));
		assertDoesNotThrow(() -> new Grade(4));
	}
	
	@Test
	@DisplayName("Getter Test")
	void testGetter() {
		assertDoesNotThrow(() -> {
			double grade = 1.5;
			Grade g = new Grade(grade);
			assertEquals(grade, g.getValue());
		});
	}

}
