package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertTestChecker {
    void checkEquals(Object[] expected, Object[] actual);

    void checkEquals(byte[] expected, byte[] actual);

    void assertEquals(int[] expected, int[] actual);

    void assertNotEquals(byte[] value1, byte[] value2);

    void assertImmutable(byte[] value1, byte[] value2);
}
