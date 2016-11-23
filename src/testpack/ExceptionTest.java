package testpack;

/**
 * @Authuor Administrator
 * @Create 2016-11-23-16:24
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new NullPointerException("this is null point");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
