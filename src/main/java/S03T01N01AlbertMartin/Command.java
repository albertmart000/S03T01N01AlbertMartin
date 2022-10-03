package S03T01N01AlbertMartin;

public class Command {

    private int position;
    private String commandText;

    public Command(int position, String commandText) {
        this.position = position;
        this.commandText = commandText;
    }

    public int getPosition() {
        return position;
    }

    public String getCommandText() {
        return commandText;
    }

    @Override
    public String toString() {
        return  "[" + position + "]   " +
                commandText + "\n";
    }
}
