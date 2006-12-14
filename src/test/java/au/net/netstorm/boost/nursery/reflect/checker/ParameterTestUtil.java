package au.net.netstorm.boost.nursery.reflect.checker;

import au.net.netstorm.boost.nursery.instance.InstanceProvider;
import au.net.netstorm.boost.edge.EdgeException;

public interface ParameterTestUtil {
    Object[] createBadParamValues(InstanceProvider instanceProvider, Class[] paramTypes, int indexOfParamToMakeBad,
            Object badValue);

    void handleException(EdgeException e);
}
