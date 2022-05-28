import IO.CSVHandler;

import java.util.ArrayList;
import java.util.LinkedList;

public class ExamRepository implements ExamRepositoryInterface {

	private String EXAMS_FILEPATH = "Data/Exams.csv";

	private CSVHandler csvHandler = CSVHandler.getInstance();

	@Override
	public void save(Exam exam) throws PersistException {
		this.saveNewExam(exam);
	}

	private void saveNewExam(Exam exam) {
		StringBuilder sb = new StringBuilder();
		sb.append(exam.getTitle()).append(";").append(exam.getWeight()).append(";").append(exam.getGrade()).append(";")
				.append(exam.getLecture());
		csvHandler.writeLine(EXAMS_FILEPATH, sb.toString());
	}

	@Override
	public ArrayList<Exam> getByLecture(Lecture lecture) {
		ArrayList<Exam> exams = new ArrayList<Exam>();
		try {
			LinkedList<String> rows = csvHandler.read(EXAMS_FILEPATH, "\r\n");
			for (String row : rows) {
				String[] rowdata = row.split(";");
				if (rowdata[3].equals(lecture.getName().toString())) {
					exams.add(this.getExamFromRow(row));
				}
			}
			return exams;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	private Exam getExamFromRow(String row) {
		String[] rowdata = row.split(";");
		String title = rowdata[0];
		double weight = Double.parseDouble(rowdata[1]);
		double grade = Double.parseDouble(rowdata[2]);
		String lecture = rowdata[3];
		try {
			return new Exam(title, weight, grade, new LectureName(lecture));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Exam> getAll() {
		ArrayList<Exam> exams = new ArrayList<Exam>();
		try {
			LinkedList<String> rows = csvHandler.read(this.EXAMS_FILEPATH, "\r\n");
			rows.remove(0);
			for (String row : rows) {
				String[] rowdata = row.split(";");
				exams.add(getExamFromRow(row));
			}
			return exams;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
