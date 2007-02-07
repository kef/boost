package au.net.netstorm.boost;

import java.util.Map;

public final class DefaultClassNameMorpher implements ClassNameMorpher {
    public Class stripPrefix(String prefix, Class cls) {
        return Map.class;
    }
}
