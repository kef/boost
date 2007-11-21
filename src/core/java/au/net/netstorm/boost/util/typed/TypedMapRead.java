package au.net.netstorm.boost.util.typed;

public interface TypedMapRead extends KeyExists {
    String getString(String key);

    Integer getInt(String key);

    Long getLong(String key);

    Boolean getBoolean(String key);

    Integer[] getInts(String key);

    byte[] getBytes(String key);

    String[] getStrings(String key);
}
