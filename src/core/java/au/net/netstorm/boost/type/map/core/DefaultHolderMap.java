package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.strong.BooleanHolder;
import au.net.netstorm.boost.type.strong.BytesHolder;
import au.net.netstorm.boost.type.strong.DefaultBooleanHolder;
import au.net.netstorm.boost.type.strong.DefaultBytesHolder;
import au.net.netstorm.boost.type.strong.DefaultIntegerHolder;
import au.net.netstorm.boost.type.strong.DefaultLongHolder;
import au.net.netstorm.boost.type.strong.DefaultStringHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;
import au.net.netstorm.boost.type.strong.LongHolder;
import au.net.netstorm.boost.type.strong.StringHolder;
import au.net.netstorm.boost.type.util.core.TypeUtility;

// FIX 54563 This becomes a HolderMap (read and write).
public final class DefaultHolderMap implements HolderMap {
    private final TypedMap map;
    TypeUtility typeUtility;

    public DefaultHolderMap(TypedMap map) {
        this.map = map;
    }

    public IntegerHolder getIntHolder(String key) {
        int value = map.getInt(key);
        return new DefaultIntegerHolder(value);
    }

    public StringHolder getStringHolder(String key) {
        String value = map.getString(key);
        return new DefaultStringHolder(value);
    }

    public BytesHolder getBytesHolder(String key) {
        byte[] value = map.getBytes(key);
        return new DefaultBytesHolder(value);
    }

    public LongHolder getLongHolder(String key) {
        long value = map.getLong(key);
        return new DefaultLongHolder(value);
    }

    public IntegerHolder[] getIntsHolder(String key) {
        int[] value = map.getInts(key);
        return typeUtility.toIntHolderArray(value);
    }

    public BooleanHolder getBooleanHolder(String key) {
        boolean value = map.getBoolean(key);
        return new DefaultBooleanHolder(value);
    }

    public boolean exists(String key) {
        return map.exists(key);
    }

    public void put(String key, IntegerHolder integerHolder) {
        int value = integerHolder.getValue();
        map.put(key, value);
    }

    public void put(String key, StringHolder stringHolder) {
        String value = stringHolder.getValue();
        map.put(key, value);
    }

    public void put(String key, BytesHolder bytesHolder) {
        byte[] value = bytesHolder.getValue();
        map.put(key, value);
    }

    public void put(String key, LongHolder longHolder) {
        long value = longHolder.getValue();
        map.put(key, value);
    }

    public void put(String key, BooleanHolder booleanHolder) {
        boolean value = booleanHolder.isTroo();
        map.put(key, value);
    }

    public void put(String key, IntegerHolder[] integerHolders) {
        int[] ints = getInts(integerHolders);
        map.put(key, ints);
    }

    private int[] getInts(IntegerHolder[] integerHolders) {
        int length = integerHolders.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = integerHolders[i].getValue();
        }
        return ints;
    }
}
