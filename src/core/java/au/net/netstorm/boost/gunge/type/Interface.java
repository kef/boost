package au.net.netstorm.boost.gunge.type;

import java.lang.reflect.Type;

public interface Interface<T> extends Data {
    Class<T> getType();
    Type getReifiedType();
}
