package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;

public interface ClassChecker {
    void check(Class cls, FieldSpec[] fields, Interface type);
}
