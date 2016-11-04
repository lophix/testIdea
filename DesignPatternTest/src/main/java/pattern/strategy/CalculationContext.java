package pattern.strategy;

import javax.lang.model.type.NullType;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-13:54
 */
public class CalculationContext {

    private Calculation calculation = null;

    public CalculationContext(String type){
        switch (type){
            case "+":
                calculation = new AddCalculation();
                break;
            case "-":
                calculation = new SubCalculation();
                break;
            default:
                System.err.println("Wrong type");
        }
    }

    public int getResult(int a, int b){
        return calculation.calculate(a, b);
    }
}
