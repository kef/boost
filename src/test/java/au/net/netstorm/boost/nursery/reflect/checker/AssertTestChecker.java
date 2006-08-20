package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertTestChecker {
    void checkEquals(Object[] expected, Object[] actual);

    void checkEquals(byte[] expected, byte[] actual);
}
