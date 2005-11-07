package au.net.netstorm.boost.util.nullo;


public class NullMaster {
    // FIXME: SC502 Make instance.

    public static void check(Object parameter) {
        if (parameter == null) throw new IllegalArgumentException();
    }
}
