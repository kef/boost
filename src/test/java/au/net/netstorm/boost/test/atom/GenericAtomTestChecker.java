package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// SUGGEST Think about how to incorporate a test with a marker interface which uses field
// SUGGEST introspection to determine which properties.  Declaration of a single array
// SUGGEST is probably enough to specify field/property order.  Might use volatile or
// SUGGEST transient to mark fields as optional.
// SUGGEST Should we be using a DataAtomConfiguration object which has set/get for behaviour.

public final class GenericAtomTestChecker implements AtomTestChecker {
    private final AtomConfiguration config;
    private DataChecker triangulationChecker;
    private DataChecker constructorNullChecker;

    public GenericAtomTestChecker(AtomConfiguration config, SpecificProviderRegistry specifics) {
        this.config = config;
        triangulationChecker = new PropertyTriangulationDataChecker(specifics);
        constructorNullChecker = new ConstructorNullDataChecker(specifics);
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
        checkConstructorRefusesNulls(cls, fields);
    }

    private void checkTriangulationOnProperties(Class cls, FieldSpec[] fields) {
        triangulationChecker.check(cls, fields);
    }

    private void checkConstructorRefusesNulls(Class cls, FieldSpec[] fields) {
        if (config.checkNulls()) constructorNullChecker.check(cls, fields);
    }
}
