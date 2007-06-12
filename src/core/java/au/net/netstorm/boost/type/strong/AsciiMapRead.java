package au.net.netstorm.boost.type.strong;

import au.net.netstorm.boost.type.util.core.KeyExists;

public interface AsciiMapRead extends KeyExists {
    AsciiBytes get(String key);
}
