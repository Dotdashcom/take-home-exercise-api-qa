package fun;

import lombok.Builder;
import lombok.Getter;
//import static TypeThatHasABuilder.*;


@Getter
@Builder
public class Game {
    private Integer id;
    private String text;
}
