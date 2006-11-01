package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.Data;

public interface MethodSpec extends Data {
    String getName();

    Class[] getParams();
}
