package au.net.netstorm.boost.nursery.type.map.string;

import au.net.netstorm.boost.util.typed.KeyExists;

public interface StringMapRead extends KeyExists {
    String get(String key);
}
