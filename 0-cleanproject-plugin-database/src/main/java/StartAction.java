import IO.CommandLineReader;
import IO.OutputLogger;

import java.util.HashMap;

public class StartAction implements ActionInterface {
	
	HashMap<Integer, ActionInterface> actions = new HashMap();

    public StartAction(){
        actions.put(1, new ListLecturesAction());
        actions.put(2, new CreateLectureAction());
        actions.put(3, new ListExamsAction());
        actions.put(4, new CreateExamAction());
        actions.put(5, new CalculateGradesAction());
    }
	@Override
	public void execute() {
		int response;
        do{
            OutputLogger.log(
                "1: List lectures \n" +
                "2: Create lecture \n" +
                "3: List exams \n" +
                "4: Create exam \n" +
                "5: Calculate grade \n" +
                "0: Quit application \n"
            );
            try{
                response = Integer.parseInt(CommandLineReader.readLine());
                if(response == 0) {
                	break;
                }
                actions.get(response).execute();
                OutputLogger.log("\nEnter to continue");
                CommandLineReader.readLine();
            }catch (Exception e){
                OutputLogger.log("\n Invalid input");
            }
        }while(true);
	}

}
