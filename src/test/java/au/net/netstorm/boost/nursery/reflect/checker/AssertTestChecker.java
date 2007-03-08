package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertTestChecker {
    void checkEquals(Object[] expected, Object[] actual);

    void checkEquals(byte[] expected, byte[] actual);

    void checkEquals(int[] expected, int[] actual);

    void checkNotEquals(byte[] value1, byte[] value2);

    void checkImmutable(byte[] value1, byte[] value2);
}
