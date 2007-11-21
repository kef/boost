package au.net.netstorm.boost.util.typed;

public final class DefaultTypedMap implements TypedMap {
    private final TypedMapRead read;
    private final TypedMapWrite write;
    TypeUtility utility;

    public DefaultTypedMap(TypedMapRead read, TypedMapWrite write) {
        this.read = read;
        this.write = write;
    }

    public String getString(String key) {
        return read.getString(key);
    }

    public Integer getInt(String key) {
        return read.getInt(key);
    }

    public Long getLong(String key) {
        return read.getLong(key);
    }

    public Boolean getBoolean(String key) {
        return read.getBoolean(key);
    }

    public byte[] getBytes(String key) {
        return read.getBytes(key);
    }

    public String[] getStrings(String key) {
        return read.getStrings(key);
    }

    public Integer[] getInts(String key) {
        return read.getInts(key);
    }

    public boolean exists(String key) {
        return read.exists(key);
    }

    public void put(String key, String value) {
        write.put(key, value);
    }

    public void put(String key, Integer value) {
        write.put(key, value);
    }

    public void put(String key, Boolean value) {
        write.put(key, value);
    }

    public void put(String key, Long value) {
        write.put(key, value);
    }

    public void put(String key, byte[] value) {
        write.put(key, value);
    }

    public void put(String key, Integer[] value) {
        write.put(key, value);
    }
}
