package Exercise_6;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
	@Test
	@DisplayName("Grade 70 should return true for passing")
	void testPassingGrade() {
		LehmanGradeBook gb = new LehmanGradeBook();
		assertTrue(gb.isPassing(70), "A grade of 70 should pass.");
		
		assertEquals('A', gb.getLetterGrade(95));
		assertEquals('B', gb.getLetterGrade(90));
		assertEquals('C', gb.getLetterGrade(80));
		assertEquals('D', gb.getLetterGrade(70));
		assertEquals('F', gb.getLetterGrade(50));
	}
	
	@Test
	void testInvalidGradeThrowsException() {
		LehmanGradeBook gb = new LehmanGradeBook();
		assertThrows(IllegalArgumentException.class, () -> {
			gb.isPassing(150);
			gb.isPassing(-1);
		});
	}
}
