package pattern.bridge;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-15:19
 */
public abstract class GameConsole {
    protected Game game;
    public abstract void run();
    public abstract void installGame(Game game);
    public abstract void playGame();
}
