package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.gunge.type.Data;

public interface TypesExpectations {
    <T extends Data> void types(T obj, Class<T> iface, Object... params);
}
