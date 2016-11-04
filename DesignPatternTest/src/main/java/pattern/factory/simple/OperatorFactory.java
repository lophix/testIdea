package pattern.factory.simple;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-10:59
 */
public class OperatorFactory {
    private static Operator operator = null;
    public static Operator getOperator(String opt){
        switch (opt){
            case "+":
                operator = new AddOperator();
                break;
            case "-":
                operator = new SubOperator();
                break;
            case "*":
                operator = new MutiOperator();
                break;
            case "/":
                operator = new DivOperator();
                break;
            default:
                System.err.println("Please use + - * / ");
        }
        return operator;
    }
}
