import java.util.Objects;

public class ExamTitle {
	private final String value;
	
	ExamTitle(String title) throws InvalidExamTitleException {
		if(title.length() < 2) {
			throw new InvalidExamTitleException("'"+title+"' is too short");
		}
		if(title.length() > 20) {
			throw new InvalidExamTitleException("'"+title+"' is too long");
		}
		this.value = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExamTitle examTitle = (ExamTitle) o;
		return Objects.equals(value, examTitle.value);
	}

	@Override
	public String toString() {
		return this.value;
	}
}