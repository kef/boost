package au.net.netstorm.boost.sniper.check;

public interface AssertTestChecker {
    void checkEquals(Object[] value1, Object[] value2);

    void checkEquals(byte[] value1, byte[] value2);

    void checkEquals(int[] value1, int[] value2);

    void checkNotEquals(byte[] value1, byte[] value2);

    void checkBagEquals(Object[] o1, Object[] o2);

    void fail(String message);
}
