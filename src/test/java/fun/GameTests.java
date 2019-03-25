package fun;

import static org.junit.Assert.*;
import org.junit.*;


public class GameTests{

@Test public void sample() {
		
	assertEquals("Gradle is gr8", "Gradle is gr8");
}
	
	
//Testing empty game name which should return "Sudoku is fun!"
@Test public void BlankTest(){
GameController controller = new GameController();
	String value = "";
	String expected = "Playing Sudoku is fun!";
	Game result = null;
	result = controller.greeting(value);
	
	System.out.println(result.getText());
	
	assertEquals(expected, result.getText());
}

//Testing with game name Chess which shoudl return "Playing Chess is fun!"
@Test public void ChessTest(){
GameController controller = new GameController();
	String value = "Chess";
	String expected = "Playing Chess is fun!";
	Game result = null;
	result = controller.greeting(value);
	
	System.out.println(result.getText());
	
	assertEquals(expected, result.getText());
}

//Testing with a game name that is supposed to fail
@Test public void ExpectedFailure(){
GameController controller = new GameController();
	String value = "Chess";
	String expected = "Playing xxxxx is fun!";
	Game result = null;
	result = controller.greeting(value);
	
	System.out.println(result.getText());
	
	assertNotSame(expected, result.getText());
}

//Testing with a minimum scenario (first 3) of fibonacci numbers (1, 1, and 2)
@Test public void FibTestMinimum(){
GameController controller = new GameController();
	String value = "Chess";
	int expected = 1;
	Game result = null;
	result = controller.greeting(value);
		
	System.out.println(result.getId());
		
	assertEquals(new Integer(expected), new Integer(result.getId()));	
	
	
	value = "Chess";
	expected = 1;
	result = null;
	result = controller.greeting(value);
		
	System.out.println(result.getId());
		
	assertEquals(new Integer(expected), new Integer(result.getId()));	
	
	value = "Chess";
	expected = 2;
	result = null;
	result = controller.greeting(value);
		
	System.out.println(result.getId());
		
	assertEquals(new Integer(expected), new Integer(result.getId()));	
	
	result = controller.greeting(value);
		
	System.out.println(result.getId());
	
	result = controller.greeting(value);
		
	System.out.println(result.getId());
}
 
//Testing the ID value after 79 runs to see if the fibonacci sequence remains positive
//79 was picked because after that many runs the unsigned integer becomes too big to remain positive
//fibonacci sequence must always be positive and therefore must me tested
@Test public void FibTestMax(){
GameController controller = new GameController();
	String value = "Checkers";
	int expected = 0;
	Game result = null;
	
	for (int i = 0; i < 79; i++) {
		result = controller.greeting(value);
		
	}
	
	//checking if the result value is postive or negative
	int flag = 0;
	if (result.getId() < 0) {
		flag = 1;
	}
	
	
	//assertEquals(new Integer(expected), new Integer(result.getId()));
	assertEquals(new Integer(expected),new Integer(flag));
	System.out.println(result.getId());
	System.out.println(result.getText());
}

//Testing the ID value after 10 runs to see if it matches the appropriate fibonacci sequence at 10 runs
@Test public void FibTestMiddle(){
GameController controller = new GameController();
	String value = "Checkers";
	int expected = 55;
	Game result = null;
	
	for (int i = 0; i < 10; i++) {
		result = controller.greeting(value);
		
	}

	
	assertEquals(new Integer(expected), new Integer(result.getId()));

	System.out.println(result.getId());
	System.out.println(result.getText());
}




//default value test
@Test public void FibTest6(){
GameController controller = new GameController();
	String value = null;
	//String value2 = null;
	String expected = "Playing Sudoku is fun!";
	Game result = null;
	//System.out.println(result.getText());
	result = controller.greeting(value);
	
	System.out.println(result.getText());
	
	assertEquals(expected, result.getText());
}


}



