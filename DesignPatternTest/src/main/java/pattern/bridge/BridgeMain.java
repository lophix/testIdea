package pattern.bridge;

/**
 * @Authuor Administrator
 * @Create 2016-11-08-15:36
 */
public class BridgeMain {
    public static void main(String[] args) {
        GameConsole playStation = new PlayStation();
        playStation.run();
        playStation.installGame(new ShootGame());
        playStation.playGame();

        System.out.println("=====================================");

        GameConsole xBox = new XBox();
        xBox.run();
        xBox.installGame(new FightGame());
        xBox.playGame();
    }
}
