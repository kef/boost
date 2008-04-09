package au.net.netstorm.boost.gunge.introspect;

import au.net.netstorm.boost.gunge.type.Data;

public interface MethodSpec extends Data {
    String getName();

    Class[] getParams();
}
