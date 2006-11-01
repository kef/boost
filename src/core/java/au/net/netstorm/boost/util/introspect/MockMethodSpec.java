package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.LooseData;

public interface MockMethodSpec extends LooseData {
    Object getReturnValue();

    String getMethodName();

    Object[] getParameters();
}
