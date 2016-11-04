package pattern.factory.simple;

/**
 * @Authuor Administrator
 * @Create 2016-11-04-10:57
 */
public class DivOperator extends Operator {

    public int getResult(int a, int b) {
        if (a != 0)
            return a / b;
        else
            System.err.println("error");
        return 0;
    }
}
