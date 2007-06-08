package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.strong.BooleanHolder;
import au.net.netstorm.boost.type.strong.BytesHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;
import au.net.netstorm.boost.type.strong.LongHolder;
import au.net.netstorm.boost.type.strong.StringHolder;

public final class DefaultSuperMap implements SuperMap {
    private final TypedMap typed;
    private final HolderMap holder;

    public DefaultSuperMap(TypedMap typedMap, HolderMap map) {
        this.typed = typedMap;
        this.holder = map;
    }

    public String getString(String key) {
        return typed.getString(key);
    }

    public int getInt(String key) {
        return typed.getInt(key);
    }

    public long getLong(String key) {
        return typed.getLong(key);
    }

    public boolean getBoolean(String key) {
        return typed.getBoolean(key);
    }

    public byte[] getBytes(String key) {
        return typed.getBytes(key);
    }

    public int[] getInts(String key) {
        return typed.getInts(key);
    }

    public IntegerHolder getIntHolder(String key) {
        return holder.getIntHolder(key);
    }

    public StringHolder getStringHolder(String key) {
        return holder.getStringHolder(key);
    }

    public BytesHolder getBytesHolder(String key) {
        return holder.getBytesHolder(key);
    }

    public LongHolder getLongHolder(String key) {
        return holder.getLongHolder(key);
    }

    public BooleanHolder getBooleanHolder(String key) {
        return holder.getBooleanHolder(key);
    }

    public IntegerHolder[] getIntsHolder(String key) {
        return holder.getIntsHolder(key);
    }

    public boolean exists(String key) {
        return holder.exists(key);
    }

    // FIX 54563 TDD These up.
    public void put(String key, String stringValue) {
        typed.put(key, stringValue);
    }

    public void put(String key, int intValue) {
        typed.put(key, intValue);
    }

    public void put(String key, boolean booleanValue) {
        typed.put(key, booleanValue);
    }

    public void put(String key, long longValue) {
        typed.put(key, longValue);
    }

    public void put(String key, byte[] bytesValue) {
        typed.put(key, bytesValue);
    }

    public void put(String key, int[] intsValue) {
        typed.put(key, intsValue);
    }

    public void put(String key, IntegerHolder intValue) {
        holder.put(key, intValue);
    }

    public void put(String key, StringHolder stringValue) {
        holder.put(key, stringValue);
    }

    public void put(String key, BytesHolder bytesValue) {
        holder.put(key, bytesValue);
    }

    public void put(String key, LongHolder longValue) {
        holder.put(key, longValue);
    }

    public void put(String key, BooleanHolder booleanValue) {
        holder.put(key, booleanValue);
    }

    public void put(String key, IntegerHolder[] intsValue) {
        holder.put(key, intsValue);
    }
}
