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
        Object parameter = instances[position];
        if (isArray(candidate)) arrayCheck(cls, instances, candidate, parameter);
        else nonArrayCheck(cls, instances, candidate, parameter);
    }

    private void arrayCheck(Class cls, Object[] parameters, FieldSpec candidate, Object parameter) {
        arrayChecker.check(cls, parameters, candidate, parameter);
    }

    private void nonArrayCheck(Class cls, Object[] parameters, FieldSpec candidate, Object parameter) {
        nonArrayChecker.check(cls, parameters, candidate, parameter);
    }

    private boolean isArray(FieldSpec candidate) {
        Class type = candidate.getType();
        return type.isArray();
    }
}
