import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Game game = new Game("src/input.txt");
            game.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}