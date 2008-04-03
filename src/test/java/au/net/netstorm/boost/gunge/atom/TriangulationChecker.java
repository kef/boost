package au.net.netstorm.boost.gunge.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface TriangulationChecker {
    void check(Class cls, Object[] parameters, FieldSpec candidate, Object parameter);
}
