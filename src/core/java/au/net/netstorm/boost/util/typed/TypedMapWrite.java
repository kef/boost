package au.net.netstorm.boost.util.typed;

public interface TypedMapWrite {
    void put(String key, String value);

    void put(String key, Integer value);

    void put(String key, Boolean value);

    void put(String key, Long value);

    void put(String key, byte[] value);

    void put(String key, Integer[] value);
}
