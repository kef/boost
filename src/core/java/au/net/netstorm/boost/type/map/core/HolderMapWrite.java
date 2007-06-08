package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.strong.BooleanHolder;
import au.net.netstorm.boost.type.strong.BytesHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;
import au.net.netstorm.boost.type.strong.LongHolder;
import au.net.netstorm.boost.type.strong.StringHolder;

public interface HolderMapWrite {
    void put(String key, IntegerHolder intValue);

    void put(String key, StringHolder stringValue);

    void put(String key, BytesHolder bytesValue);

    void put(String key, LongHolder longValue);

    void put(String key, BooleanHolder booleanValue);

    void put(String key, IntegerHolder[] intsValue);
}
