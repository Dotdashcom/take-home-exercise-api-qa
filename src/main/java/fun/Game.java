package fun;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Game {
    private Integer id;
    private String text;
}
