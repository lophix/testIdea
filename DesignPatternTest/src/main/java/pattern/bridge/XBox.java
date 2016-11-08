package pattern.bridge;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-15:22
 */
public class XBox extends GameConsole {
    @Override
    public void run() {
        System.out.println("Turn on XBox");
    }

    @Override
    public void installGame(Game game) {
        this.game = game;
    }

    @Override
    public void playGame() {
        System.out.println("Use XBox play game");
        game.start();
    }
}
