package fun;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Game {
    private Integer id;
    private String text;

    @JsonCreator
    public Game(@JsonProperty("code") int id, @JsonProperty("message") String text) {
        this.id = id;
        this.text = text;
    }
}