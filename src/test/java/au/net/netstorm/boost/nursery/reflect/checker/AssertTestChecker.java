package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertTestChecker {
    void checkEquals(Object[] value1, Object[] value2);

    void checkEquals(byte[] value1, byte[] value2);

    void checkEquals(int[] value1, int[] value2);

    void checkNotEquals(byte[] value1, byte[] value2);
}
