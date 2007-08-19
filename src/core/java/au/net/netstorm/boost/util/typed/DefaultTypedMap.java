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

    public int getInt(String key) {
        return read.getInt(key);
    }

    public long getLong(String key) {
        return read.getLong(key);
    }

    public boolean getBoolean(String key) {
        return read.getBoolean(key);
    }

    public byte[] getBytes(String key) {
        return read.getBytes(key);
    }

    public String[] getStrings(String key) {
        return read.getStrings(key);
    }

    public int[] getInts(String key) {
        return read.getInts(key);
    }

    public boolean exists(String key) {
        return read.exists(key);
    }

    public void put(String key, String value) {
        write.put(key, value);
    }

    public void put(String key, int value) {
        write.put(key, value);
    }

    public void put(String key, boolean value) {
        write.put(key, value);
    }

    public void put(String key, long value) {
        write.put(key, value);
    }

    public void put(String key, byte[] value) {
        write.put(key, value);
    }

    public void put(String key, int[] value) {
        write.put(key, value);
    }
}
