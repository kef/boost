package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.random.DefaultFieldRandomizer;
import au.net.netstorm.boost.sniper.random.FieldRandomizer;

final class PropertyTriangulationDataChecker implements DataChecker {
    private final TriangulationChecker nonArrayChecker = new NonArrayPropertyTriangulationChecker();
    private final TriangulationChecker arrayChecker = new ArrayPropertyTriangulationChecker();
    private final FieldRandomizer randomizer;

    public PropertyTriangulationDataChecker(Provider random) {
        randomizer = new DefaultFieldRandomizer(random);
    }

    public void check(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            check(cls, fields, i);
        }
    }

    private void check(Class cls, FieldSpec[] fields, int position) {
        Object[] instances = randomizer.getInstances(fields);
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
