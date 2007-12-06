package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.nursery.type.core.Holder;
import au.net.netstorm.boost.util.type.Data;

public interface TypesExpectations {
    <T extends Holder> void types(T obj, Class<T> impl, Object param);

    <T extends Data> void types(T obj, Class<T> impl, Object... params);
}
