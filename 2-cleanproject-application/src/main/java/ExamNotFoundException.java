
public class ExamNotFoundException extends Exception {
    public ExamNotFoundException(ExamTitle title){
        super("Exam '"+title+"' not found.");
    }
}
