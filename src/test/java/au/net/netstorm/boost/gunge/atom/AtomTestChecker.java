package au.net.netstorm.boost.gunge.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface AtomTestChecker {
    void checkAtom(Class cls, FieldSpec[] fields);
}
