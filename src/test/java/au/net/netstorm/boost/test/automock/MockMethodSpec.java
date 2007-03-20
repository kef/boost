package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.util.type.LooseData;

interface MockMethodSpec extends LooseData {
    Object getReturnValue();

    String getMethodName();

    Object[] getParameters();
}