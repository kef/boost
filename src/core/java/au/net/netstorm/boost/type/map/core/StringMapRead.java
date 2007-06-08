package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.type.util.core.KeyExists;

public interface StringMapRead extends KeyExists {
    String get(String key);
}
