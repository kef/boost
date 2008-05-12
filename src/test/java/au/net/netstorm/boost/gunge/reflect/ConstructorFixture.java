package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;

interface ConstructorFixture {
    List<?> vector();
    List<?> stack();
    Constructor<DualOverloadCtor> vectorctor();
    Constructor<DualOverloadCtor> stackctor();
    Constructor<?>[] constructors();
    Class<?>[] vectortype();
    Class<?>[] stacktype();
}
