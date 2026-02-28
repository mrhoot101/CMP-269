package Exercise_6;

public class LehmanGradeBook {
	public boolean isPassing(int grade) {
		if (100 >= grade && grade >= 0) {
			return grade >= 70;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	char getLetterGrade(int score) {
		
		if (score >= 95) {
			return 'A';
		}
		else if (score >= 90) {
			return 'B';
		}
		else if (score >= 80) {
			return 'C';
		}
		else if (score >= 70){
			return 'D';
		}
		else {
			return 'F';
		}
	}
}
