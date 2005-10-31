package au.net.netstorm.boost.util.nullo;

// FIXME: SC104 Make instance.

public class NullChecker {
    public static void check(Object parameter) {
        if (parameter == null) throw new IllegalArgumentException();
    }
}
