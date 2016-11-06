package pattern.facade;

/**
 * Created by Administrator on 2016/11/6.
 */
public class Weapon {
    private Crystal crystal;
    private Iron iron;
    public Weapon(){
        crystal = new Crystal();
        iron = new Iron();
    }

    public void getRedCrystalBlackIronBlade(){
        System.out.println("The " + crystal.redCrystal() + " add " + iron.blackIron() + " make red crystal black iron blade");
    }

    public void getBlueCrystalSteelBlade(){
        System.out.println("The " + crystal.blueCrystal() + " add " + iron.steel() + " make blue crystal steel blade");
    }
}
