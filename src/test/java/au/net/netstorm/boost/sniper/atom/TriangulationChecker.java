package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;

interface TriangulationChecker {
    void check(Class cls, Object[] parameters, FieldSpec candidate, Object parameter);
}
