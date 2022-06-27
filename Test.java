import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        BigInteger b199 = BigInteger.valueOf(199);
        BigInteger b1999 = b199.pow(199);

        System.out.println(b1999.toString());
    }
}
