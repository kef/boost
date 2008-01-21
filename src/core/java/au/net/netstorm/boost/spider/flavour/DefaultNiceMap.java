package au.net.netstorm.boost.spider.flavour;

import java.util.HashMap;
import java.util.Map;

// FIX 2237 Move any non-flavoured stuff out of the package and clean.
public final class DefaultNiceMap<K, V> implements NiceMap<K, V> {
    private final Map<K, V> map = new HashMap<K, V>();
    // Leave in for test framework to tweak
    private static boolean overridesAllowed = false;

    public void put(K key, V value) {
        if (value == null) fail(key, "Come on, ya have to give me somethin' man.  Anything but a null");
        validate(key);
        map.put(key, value);
    }

    public V get(K key) {
        V result = nullGet(key);
        if (result == null) fail(key, "No matching key");
        return result;
    }

    public boolean exists(K key) {
        return nullGet(key) != null;
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    private V nullGet(K key) {
        return map.get(key);
    }

    private void validate(K key) {
        if (overridesAllowed) return;
        if (map.containsKey(key)) fail(key, "Key already exists");
    }

    private void fail(K key, String msg) {
        throw new MapException(key, msg);
    }
}
