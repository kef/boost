package au.net.netstorm.boost.util.equals;

public interface DummyEqualsChecker {
    void checkEquals(Object expected, Object actual);

    void checkNotEquals(Object expected, Object actual);
}
