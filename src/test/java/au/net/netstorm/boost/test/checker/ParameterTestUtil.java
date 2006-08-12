package au.net.netstorm.boost.test.checker;

import au.net.netstorm.boost.nursery.instance.InstanceProvider;

public interface ParameterTestUtil {
    Object[] createParameterValuesWithNull(InstanceProvider instanceProvider, Class[] paramTypes, int paramToMakeNull);

    // FIX SC523 Rename...
// FIX SC043 R This belongs somewhere else.
    void invoke(Block block);
}
