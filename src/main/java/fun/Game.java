package fun;

public class Game {

    private final long id;
    private final String text;

    public Game(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
