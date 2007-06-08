package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.strong.BooleanHolder;
import au.net.netstorm.boost.type.strong.BytesHolder;
import au.net.netstorm.boost.type.strong.IntegerHolder;
import au.net.netstorm.boost.type.strong.LongHolder;
import au.net.netstorm.boost.type.strong.StringHolder;
import au.net.netstorm.boost.type.util.core.KeyExists;

public interface HolderMapRead extends KeyExists {
    IntegerHolder getIntHolder(String key);

    StringHolder getStringHolder(String key);

    BytesHolder getBytesHolder(String key);

    LongHolder getLongHolder(String key);

    BooleanHolder getBooleanHolder(String key);

    IntegerHolder[] getIntsHolder(String key);
}
