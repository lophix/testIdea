package pattern.strategy;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-13:52
 */
public class AddCalculation implements Calculation {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
