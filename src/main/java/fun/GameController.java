package fun;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private static final String template = "Playing %s is fun!";
    private int counter = 1;
    private Map<Integer,Integer> map = new HashMap<>();

    @RequestMapping("/game")
    public Game greeting(@RequestParam(value="name", defaultValue="Sudoku") String name) {
        return Game.builder().id(fib(counter++)).text(String.format(template, name)).build();
    }
    
    private int fib(int counter) {
    		if(counter == 1 || counter == 2) {
    			return 1;
    		}
    		if(map.containsKey(counter)) {
    			return map.get(counter);
    		}
    		int value = fib(counter - 1) + fib(counter - 2);
    		map.put(counter, value);
    		return value;
    }
}
