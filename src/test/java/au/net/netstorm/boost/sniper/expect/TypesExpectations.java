package au.net.netstorm.boost.sniper.expect;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.nursery.type.core.Holder;

public interface TypesExpectations {
    <T extends Holder> void types(T obj, Class<T> iface, Object param);

    <T extends Data> void types(T obj, Class<T> iface, Object... params);
}
