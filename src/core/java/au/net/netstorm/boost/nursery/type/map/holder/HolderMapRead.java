package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.BooleanHolder;
import au.net.netstorm.boost.nursery.type.primitive.BytesHolder;
import au.net.netstorm.boost.nursery.type.primitive.IntegerHolder;
import au.net.netstorm.boost.nursery.type.primitive.StringHolder;
import au.net.netstorm.boost.util.typed.KeyExists;

// FIX (Nov 26, 2007) 2233 Can this be reduced to 2 methods?
public interface HolderMapRead extends KeyExists {
    <T extends IntegerHolder> T getIntHolder(String key, Class<T> iface);

    <T extends StringHolder> T getStringHolder(String key, Class<T> iface);

    <T extends BytesHolder> T getBytesHolder(String key, Class<T> iface);

    <T extends BooleanHolder> T getBooleanHolder(String key, Class<T> iface);

    <T extends IntegerHolder> T[] getIntsHolder(String key, Class<T> iface);

    <T extends StringHolder> T[] getStringsHolder(String key, Class<T> iface);
}
