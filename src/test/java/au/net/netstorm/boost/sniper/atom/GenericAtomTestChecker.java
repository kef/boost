package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.provider.Provider;

// SUGGEST Think about how to incorporate a test with a marker interface which uses field
// SUGGEST introspection to determine which properties.  Declaration of a single array
// SUGGEST is probably enough to specify field/property order.  Might use volatile or
// SUGGEST transient to mark fields as optional.
// SUGGEST Should we be using a DataAtomConfiguration object which has set/get for behaviour.

public final class GenericAtomTestChecker implements AtomTestChecker {
    private final AtomConfiguration config;
    private DataChecker triangulationChecker;
    private DataChecker constructorNullChecker;

    public GenericAtomTestChecker(AtomConfiguration config, Provider random) {
        this.config = config;
        triangulationChecker = new PropertyTriangulationDataChecker(random);
        constructorNullChecker = new ConstructorNullDataChecker(random);
    }

    public void checkAtom(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        checkStructure(cls, fields);
        checkBehaviour(cls, fields);
    }

    private void checkStructure(Class cls, FieldSpec[] fields) {
        AtomStructureChecker structureChecker = new GenericAtomStructureChecker(config);
        structureChecker.checkStructure(cls, fields);
    }

    private void checkBehaviour(Class cls, FieldSpec[] fields) {
        checkTriangulationOnProperties(cls, fields);
        checkConstructorMayRefuseNulls(cls, fields);
    }

    private void checkTriangulationOnProperties(Class cls, FieldSpec[] fields) {
        triangulationChecker.check(cls, fields);
    }

    private void checkConstructorMayRefuseNulls(Class cls, FieldSpec[] fields) {
        if (config.checkNulls()) constructorNullChecker.check(cls, fields);
    }
}
