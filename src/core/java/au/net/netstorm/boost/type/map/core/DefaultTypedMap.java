package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.util.core.TypeUtility;

public final class DefaultTypedMap implements TypedMap {
    private final TypedMapRead typedMapRead;
    private final TypedMapWrite typedMapWrite;
    TypeUtility typeUtility;

    public DefaultTypedMap(TypedMapRead typedMapRead, TypedMapWrite typedMapWrite) {
        this.typedMapRead = typedMapRead;
        this.typedMapWrite = typedMapWrite;
    }

    public String getString(String key) {
        return typedMapRead.getString(key);
    }

    public int getInt(String key) {
        return typedMapRead.getInt(key);
    }

    public long getLong(String key) {
        return typedMapRead.getLong(key);
    }

    public boolean getBoolean(String key) {
        return typedMapRead.getBoolean(key);
    }

    public byte[] getBytes(String key) {
        return typedMapRead.getBytes(key);
    }

    public int[] getInts(String key) {
        return typedMapRead.getInts(key);
    }

    public boolean exists(String key) {
        return typedMapRead.exists(key);
    }

    public void put(String key, String stringValue) {
        typedMapWrite.put(key, stringValue);
    }

    public void put(String key, int intValue) {
        typedMapWrite.put(key, intValue);
    }

    public void put(String key, boolean booleanValue) {
        typedMapWrite.put(key, booleanValue);
    }

    public void put(String key, long longValue) {
        typedMapWrite.put(key, longValue);
    }

    public void put(String key, byte[] bytesValue) {
        typedMapWrite.put(key, bytesValue);
    }

    public void put(String key, int[] intsValue) {
        typedMapWrite.put(key, intsValue);
    }
}
