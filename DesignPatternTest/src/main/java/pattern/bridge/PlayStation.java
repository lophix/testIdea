package pattern.bridge;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-15:21
 */
public class PlayStation extends GameConsole {
    @Override
    public void run() {
        System.out.println("Turn on Play Station");
    }

    @Override
    public void installGame(Game game) {
        this.game = game;
    }

    @Override
    public void playGame() {
        System.out.println("Use Play Station play game");
        this.game.start();
    }
}
