package pattern.factory.simple;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-11:08
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        int a = 20, b = 4;
        Operator operator = OperatorFactory.getOperator("+");
        int result = operator.getResult(a, b);
        System.out.println(result);
        operator = OperatorFactory.getOperator("-");
        result = operator.getResult(a, b);
        System.out.println(result);
    }
}
