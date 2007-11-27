package au.net.netstorm.boost.nursery.type.supa;

import au.net.netstorm.boost.nursery.type.BooleanHolder;
import au.net.netstorm.boost.nursery.type.BytesHolder;
import au.net.netstorm.boost.nursery.type.IntegerHolder;
import au.net.netstorm.boost.nursery.type.StringHolder;
import au.net.netstorm.boost.nursery.type.holder.HolderMap;
import au.net.netstorm.boost.util.typed.TypedMap;

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

    public Integer getInt(String key) {
        return typed.getInt(key);
    }

    public Long getLong(String key) {
        return typed.getLong(key);
    }

    public Boolean getBoolean(String key) {
        return typed.getBoolean(key);
    }

    public byte[] getBytes(String key) {
        return typed.getBytes(key);
    }

    public String[] getStrings(String key) {
        return typed.getStrings(key);
    }

    public Integer[] getInts(String key) {
        return typed.getInts(key);
    }

    public <T extends IntegerHolder> T getIntHolder(String key, Class<T> iface) {
        return holder.getIntHolder(key, iface);
    }

    public <T extends StringHolder> T getStringHolder(String key, Class<T> iface) {
        return holder.getStringHolder(key, iface);
    }

    public <T extends BytesHolder> T getBytesHolder(String key, Class<T> iface) {
        return holder.getBytesHolder(key, iface);
    }

    public <T extends BooleanHolder> T getBooleanHolder(String key, Class<T> iface) {
        return holder.getBooleanHolder(key, iface);
    }

    public <T extends IntegerHolder> T[] getIntsHolder(String key, Class<T> iface) {
        return holder.getIntsHolder(key, iface);
    }

    public <T extends StringHolder> T[] getStringsHolder(String key, Class<T> iface) {
        return holder.getStringsHolder(key, iface);
    }

    public boolean exists(String key) {
        return holder.exists(key);
    }

    public void put(String key, String stringValue) {
        typed.put(key, stringValue);
    }

    public void put(String key, Integer intValue) {
        typed.put(key, intValue);
    }

    public void put(String key, Boolean booleanValue) {
        typed.put(key, booleanValue);
    }

    public void put(String key, Long longValue) {
        typed.put(key, longValue);
    }

    public void put(String key, byte[] bytesValue) {
        typed.put(key, bytesValue);
    }

    public void put(String key, Integer[] intsValue) {
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

    public void put(String key, BooleanHolder booleanValue) {
        holder.put(key, booleanValue);
    }

    public void put(String key, IntegerHolder[] intsValue) {
        holder.put(key, intsValue);
    }
}
