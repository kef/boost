package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

public interface DataInvocationHandlerValidator {
    void check(FieldValueSpec[] fields, Interface iFace);
}
