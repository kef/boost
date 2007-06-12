package au.net.netstorm.boost.type.strong;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class DefaultAsciiMap implements AsciiMap {
    private Map map = new HashMap();

    public AsciiBytes get(String key) {
        if (!exists(key)) throw new IllegalArgumentException(key + " does not exist.");
        return (AsciiBytes) map.get(key);
    }

    public void put(String key, AsciiBytes value) {
        map.put(key, value);
    }

    public boolean exists(String key) {
        return map.containsKey(key);
    }

    public Set entrySet() {
        return map.entrySet();
    }
}
