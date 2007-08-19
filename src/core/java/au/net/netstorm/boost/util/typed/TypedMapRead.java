package au.net.netstorm.boost.util.typed;

public interface TypedMapRead extends KeyExists {
    String getString(String key);

    int getInt(String key);

    long getLong(String key);

    boolean getBoolean(String key);

    int[] getInts(String key);

    byte[] getBytes(String key);

    String[] getStrings(String key);
}
