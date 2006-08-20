package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class PropertyTriangulationDataChecker implements DataChecker {
    private TriangulationChecker nonArrayChecker = new NonArrayPropertyTriangulationChecker();
    private TriangulationChecker arrayChecker = new ArrayPropertyTriangulationChecker();
    private FieldSpecTestUtil fieldUtil = new DefaultFieldSpecTestUtil();

    public void check(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            check(cls, fields, i);
        }
    }

    // FIX SC600 Tidy this.
    // FIX SC600 Do we really need to pass position through?
    private void check(Class cls, FieldSpec[] fields, int position) {
        FieldSpec candidate = fields[position];
        Object[] instances = fieldUtil.getInstances(fields);
        if (isArray(candidate)) arrayCheck(cls, instances, candidate, position);
        else nonArrayCheck(cls, instances, candidate, position);
    }

    private void arrayCheck(Class cls, Object[] parameters, FieldSpec candidate, int position) {
        // FIX SC600 Hard fail on Arrays containing arrays.  We do not support them.
        arrayChecker.check(cls, parameters, candidate, position);
    }

    private void nonArrayCheck(Class cls, Object[] parameters, FieldSpec candidate, int position) {
        nonArrayChecker.check(cls, parameters, candidate, position);
    }

    private boolean isArray(FieldSpec candidate) {
        Class type = candidate.getType();
        return type.isArray();
    }
}
