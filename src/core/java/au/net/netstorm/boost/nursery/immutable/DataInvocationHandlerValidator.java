package au.net.netstorm.boost.nursery.immutable;

import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.type.Interface;

public interface DataInvocationHandlerValidator {
    void check(FieldValueSpec[] fields, Interface iFace);
}
