package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.Data;

public interface MockMethodSpec extends Data {
    Object getReturnValue();

    String getMethodName();

    Object[] getParameters();
}
