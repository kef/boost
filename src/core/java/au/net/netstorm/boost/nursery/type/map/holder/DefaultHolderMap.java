package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.gunge.typed.TypeUtility;
import au.net.netstorm.boost.gunge.typed.TypedMap;
import au.net.netstorm.boost.spider.core.Nu;
import au.net.netstorm.boost.nursery.type.primitive.BooleanHolder;
import au.net.netstorm.boost.nursery.type.primitive.BytesHolder;
import au.net.netstorm.boost.nursery.type.primitive.IntegerHolder;
import au.net.netstorm.boost.nursery.type.primitive.StringHolder;

// SUGGEST (Nov 22, 2007): Genericise to get/put.  Hurts in ResultSetHolderMap.
public final class DefaultHolderMap implements au.net.netstorm.boost.nursery.type.map.holder.HolderMap {
    private final TypedMap map;
    HolderUtility holderUtility;
    TypeUtility typeUtility;
    Nu nu;

    public DefaultHolderMap(TypedMap map) {
        this.map = map;
    }

    public <T extends IntegerHolder> T getIntHolder(String key, Class<T> iface) {
        Integer value = map.getInt(key);
        return nu.nu(iface, value);
    }

    public <T extends StringHolder> T getStringHolder(String key, Class<T> iface) {
        String value = map.getString(key);
        return nu.nu(iface, value);
    }

    public <T extends BytesHolder> T getBytesHolder(String key, Class<T> iface) {
        byte[] value = map.getBytes(key);
        return nu.nu(iface, value);
    }

    public <T extends BooleanHolder> T getBooleanHolder(String key, Class<T> iface) {
        Boolean value = map.getBoolean(key);
        return nu.nu(iface, value);
    }

    public <T extends IntegerHolder> T[] getIntsHolder(String key, Class<T> iface) {
        Integer[] ints = map.getInts(key);
        return holderUtility.toHolderArray(iface, ints);
    }

    public <T extends StringHolder> T[] getStringsHolder(String key, Class<T> iface) {
        String[] strings = map.getStrings(key);
        return holderUtility.toHolderArray(iface, strings);
    }

    public boolean exists(String key) {
        return map.exists(key);
    }

    public void put(String key, IntegerHolder integerHolder) {
        Integer value = integerHolder.getValue();
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

    public void put(String key, BooleanHolder booleanHolder) {
        Boolean value = booleanHolder.getValue();
        map.put(key, value);
    }

    public void put(String key, IntegerHolder[] integerHolders) {
        Integer[] ints = getInts(integerHolders);
        map.put(key, ints);
    }

    private Integer[] getInts(IntegerHolder[] holders) {
        int length = holders.length;
        Integer[] ints = new Integer[length];
        for (int i = 0; i < length; i++) {
            ints[i] = holders[i].getValue();
        }
        return ints;
    }
}