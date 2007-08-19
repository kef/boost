package au.net.netstorm.boost.util.typed;

public interface TypedMapWrite {
    void put(String key, String stringValue);

    void put(String key, int intValue);

    void put(String key, boolean booleanValue);

    void put(String key, long longValue);

    void put(String key, byte[] bytesValue);

    void put(String key, int[] intsValue);
}
