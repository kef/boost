package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.util.type.Data;

public interface Holder<T> extends Data {
    T getValue();
}