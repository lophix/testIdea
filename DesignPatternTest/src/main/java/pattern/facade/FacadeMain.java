package pattern.facade;

/**
 * Created by Administrator on 2016/11/6.
 */
public class FacadeMain {
    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        weapon.getBlueCrystalSteelBlade();
        weapon.getRedCrystalBlackIronBlade();
    }
}
