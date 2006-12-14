package au.net.netstorm.boost.nursery.reflect.checker;

import au.net.netstorm.boost.nursery.instance.InstanceProvider;

public interface ParameterTestUtil {
    Object[] createParameterValuesWithNull(InstanceProvider instanceProvider, Class[] paramTypes, int paramToMakeNull);

    // SUGGEST R This belongs somewhere else.
    void invoke(Runnable block);
}
