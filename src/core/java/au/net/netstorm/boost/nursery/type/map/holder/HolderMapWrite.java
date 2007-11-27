package au.net.netstorm.boost.nursery.type.map.holder;

import au.net.netstorm.boost.nursery.type.primitive.BooleanHolder;
import au.net.netstorm.boost.nursery.type.primitive.BytesHolder;
import au.net.netstorm.boost.nursery.type.primitive.IntegerHolder;
import au.net.netstorm.boost.nursery.type.primitive.StringHolder;

public interface HolderMapWrite {
    void put(String key, IntegerHolder intValue);

    void put(String key, StringHolder stringValue);

    void put(String key, BytesHolder bytesValue);

    void put(String key, BooleanHolder booleanValue);

    void put(String key, IntegerHolder[] intsValue);
}
