package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.type.Interface;

public interface ClassChecker {
    void check(Class cls, FieldSpec[] fields, Interface type);
}
