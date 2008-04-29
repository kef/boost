package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.Constructor;
import java.util.List;

public interface ConstructorFixture {
    List<?> vector();
    List<?> stack();
    Constructor<DualOverloadCtor> vectorctor();
    Constructor<DualOverloadCtor> stackctor();
    Constructor<?>[] constructors();
    Class<?>[] vectortype();
    Class<?>[] stacktype();
}
