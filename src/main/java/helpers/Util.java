package helpers;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static int generateSixDigitNumber() {
        return ThreadLocalRandom.current().nextInt(100000, 1_000_000);
    }
}
