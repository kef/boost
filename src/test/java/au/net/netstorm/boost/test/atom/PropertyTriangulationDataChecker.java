package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class PropertyTriangulationDataChecker implements DataChecker {
    private DataChecker nonArrayChecker = new NonArrayPropertyTriangulationChecker();
    private DataChecker arrayChecker = new ArrayPropertyTriangulationChecker();

    public void check(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            check(cls, fields, i);
        }
        // FIX SC600 BREADCRUMB Remove this bridge.
        nonArrayChecker.check(cls, fields);
    }

    private void check(Class cls, FieldSpec[] fields, int i) {
    }
}
