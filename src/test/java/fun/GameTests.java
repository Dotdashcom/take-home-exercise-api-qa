package fun;

import java.util.ArrayList;
import java.util.List;

public class GameTests {

    //Testing game name with cucumber
    private Game result;
    public String expectedText;
    GameController controller = new GameController();
    public void gameTest(String gameName){

        result = controller.greeting(gameName);

        if (gameName.isEmpty() || gameName.equals(" ")){
            expectedText = "Playing Sudoku is fun!";
        }else {
            expectedText = "Playing " + gameName + " is fun!";
        }
    }

    public String getResultTest(){

        return result.getText();
    }

    //Get game ID with cucumber
    public int getResultID(){
        return result.getId();
    }

    //Testing game ID with cucumber
    public boolean checkID(String times){
        int howManyTimes = Integer.parseInt(times);
        boolean isIDCorrect = false;
        List<Integer> actualListID = new ArrayList<>();
        for (int i = 0; i < howManyTimes; i++){
            result = controller.greeting("check ID");
            actualListID.add(getResultID());
        }

        List<Integer> expectedListID = new ArrayList<>();
        int fbNumbers1 = 1;
        int fbNumbers2 = 1 ;

        for (int i = 0; i < howManyTimes; i++){
            expectedListID.add(fbNumbers1);
            int sum = fbNumbers1 + fbNumbers2;
            fbNumbers1 = fbNumbers2;
            fbNumbers2 = sum;
        }
        if (actualListID.equals(expectedListID)){
            isIDCorrect = true;
        }
        System.out.println("Actual ID: " + actualListID);
        System.out.println("Expected ID: " + expectedListID);
        return isIDCorrect;
    }
}
