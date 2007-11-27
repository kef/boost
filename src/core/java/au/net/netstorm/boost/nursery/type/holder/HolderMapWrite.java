package au.net.netstorm.boost.nursery.type.holder;

import au.net.netstorm.boost.nursery.type.BooleanHolder;
import au.net.netstorm.boost.nursery.type.BytesHolder;
import au.net.netstorm.boost.nursery.type.IntegerHolder;
import au.net.netstorm.boost.nursery.type.StringHolder;

public interface HolderMapWrite {
    void put(String key, IntegerHolder intValue);

    void put(String key, StringHolder stringValue);

    void put(String key, BytesHolder bytesValue);

    void put(String key, BooleanHolder booleanValue);

    void put(String key, IntegerHolder[] intsValue);
}
