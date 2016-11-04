package pattern.strategy;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-14:02
 */
public class StrategyMain {
    public static void main(String[] args) {
        CalculationContext ctx = new CalculationContext("+");
        System.out.println(ctx.getResult(15, 15));
        ctx = new CalculationContext("/");
        System.out.println(ctx.getResult(1, 2));
    }
}
