package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.util.type.Data;

// FIX (Nov 21, 2007) 2233 Move out of nursery
public interface Holder<T> extends Data {
    T getValue();
}