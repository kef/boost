package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX SC600 BREADCRUMB Fix this.  Do not extend DataChecker.
interface TriangulationChecker {
    void check(Class cls, Object[] parameters, FieldSpec candidate, int position);
}
