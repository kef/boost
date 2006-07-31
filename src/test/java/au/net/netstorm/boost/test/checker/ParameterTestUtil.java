package au.net.netstorm.boost.test.checker;

import au.net.netstorm.boost.util.instance.InstanceProvider;

public interface ParameterTestUtil {
    Object[] createParameterValuesWithNull(InstanceProvider instanceProvider, Class[] paramTypes, int paramToMakeNull);

    // FIXME: SC523 Rename...
// FIXME: SC043 R This belongs somewhere else.
    void invokeBlock(Call invokeBlock);
}
