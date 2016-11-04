package pattern.strategy;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-13:53
 */
public class SubCalculation implements Calculation {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
