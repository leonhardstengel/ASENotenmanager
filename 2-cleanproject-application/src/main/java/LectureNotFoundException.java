
public class LectureNotFoundException extends Exception {
    public LectureNotFoundException(LectureName name){
        super("Lecture '"+name+"' not found.");
    }
}
