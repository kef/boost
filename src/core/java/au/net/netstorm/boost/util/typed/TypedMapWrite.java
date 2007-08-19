package au.net.netstorm.boost.util.typed;

public interface TypedMapWrite {
    void put(String key, String value);

    void put(String key, int value);

    void put(String key, boolean value);

    void put(String key, long value);

    void put(String key, byte[] value);

    void put(String key, int[] value);
}
