import IO.CSVHandler;

import java.util.ArrayList;
import java.util.LinkedList;

public class LectureRepository implements LectureRepositoryInterface {

    private String LECTURES_FILEPATH = "Data/Lectures.csv";

	private CSVHandler csvHandler = CSVHandler.getInstance();
	
	@Override
	public void save(Lecture lecture) throws PersistException {
		if(this.getByName(lecture.getName()) == null) {
			this.saveNewLecture(lecture);
		} else {
			throw new PersistException("'" + lecture.getName() + "' already exists");
		}
	}

	private void saveNewLecture(Lecture lecture) {
		StringBuilder sb = new StringBuilder();
        sb.append(lecture.getName()).append(";").append(lecture.getEcts()).append(";").append(lecture.getSemester());
		csvHandler.writeLine(LECTURES_FILEPATH, sb.toString());
	}

	@Override
	public Lecture getByName(LectureName name) {
		String row;
		try{
			LinkedList<String> rows = csvHandler.read(this.LECTURES_FILEPATH, "\r\n");
			for(String r : rows){
				String[] rowdata = r.split(";");
				if(rowdata[0].equals(name.toString())) {
					row = r;
					return getLectureFromRow(row);
				}
			}
		}catch (Exception e){
			System.out.println(e);
		}
		return null;
	}

	private Lecture getLectureFromRow(String row) {
		if(row == null) {
			return null;
		}
		String[] rowdata = row.split(";");
        String name = rowdata[0];
        int ects = Integer.parseInt(rowdata[1]);
        int semester = Integer.parseInt(rowdata[2]);
        try {
            return new Lecture(name, ects, semester);
        } catch(Exception e) {
        	e.printStackTrace();
        	System.exit(-1);
        }
		return null;
	}

	@Override
	public ArrayList<Lecture> getAll() {
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		try{
			LinkedList<String> rows = csvHandler.read(this.LECTURES_FILEPATH, "\r\n");
			rows.remove(0);
			for(String row : rows){
				String[] rowdata = row.split(";");
			    lectures.add(getLectureFromRow(row));
		    }
			return lectures;
		}catch (Exception e){
		    System.out.println(e);
		}
		return null;
	}
	
}
