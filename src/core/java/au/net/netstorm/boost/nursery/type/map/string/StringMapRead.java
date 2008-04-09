package au.net.netstorm.boost.nursery.type.map.string;

import au.net.netstorm.boost.gunge.typed.KeyExists;

public interface StringMapRead extends KeyExists {
    String get(String key);
}
