package au.net.netstorm.boost.sniper.automock;

import au.net.netstorm.boost.gunge.type.LooseData;

interface MockMethodSpec extends LooseData {
    Object getReturnValue();

    String getMethodName();

    Object[] getParameters();
}
