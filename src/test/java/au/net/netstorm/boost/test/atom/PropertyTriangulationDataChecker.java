package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.core.Provider;
import au.net.netstorm.boost.test.random.DefaultFieldRandomizer;
import au.net.netstorm.boost.test.random.DefaultSpecificProviderAssembler;
import au.net.netstorm.boost.test.random.FieldRandomizer;
import au.net.netstorm.boost.test.random.SpecificProviderAssembler;
import au.net.netstorm.boost.test.specific.Specifics;
import au.net.netstorm.boost.util.introspect.FieldSpec;

final class PropertyTriangulationDataChecker implements DataChecker {
    private TriangulationChecker nonArrayChecker = new NonArrayPropertyTriangulationChecker();
    private TriangulationChecker arrayChecker = new ArrayPropertyTriangulationChecker();
    private SpecificProviderAssembler providerAssembler = new DefaultSpecificProviderAssembler();
    private FieldRandomizer fieldUtil;

    public PropertyTriangulationDataChecker(Specifics specifics) {
        Provider randomProvider = providerAssembler.everything(specifics);
        fieldUtil = new DefaultFieldRandomizer(randomProvider);
    }

    public void check(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            check(cls, fields, i);
        }
    }

    private void check(Class cls, FieldSpec[] fields, int position) {
        Object[] instances = fieldUtil.getInstances(fields);
        Object parameter = instances[position];
        FieldSpec candidate = fields[position];
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
