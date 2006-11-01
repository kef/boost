package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// SUGGEST Think about how to incorporate a test with a marker interface which uses field
// SUGGEST introspection to determine which properties.  Declaration of a single array
// SUGGEST is probably enough to specify field/property order.  Might use volatile or
// SUGGEST transient to mark fields as optional.
// SUGGEST Should we be using a DataAtomConfiguration object which has set/get for behaviour.

public final class GenericAtomTestChecker implements AtomTestChecker {
    private ClassChecker classChecker = new DefaultClassChecker();
    private DataChecker constructorChecker = new ConstructorDataChecker();
    private DataChecker classMethodStructureChecker = new ClassMethodStructureDataChecker();
    private DataChecker propertyMethodStructureChecker = new PropertyMethodStructureChecker();
    private DataChecker immutabilityChecker = new ImmutabilityDataChecker();
    private DataChecker triangulationChecker = new PropertyTriangulationDataChecker();
    private DataChecker constructorNullChecker = new ConstructorNullDataChecker();
    private final AtomConfiguration config;

    public GenericAtomTestChecker(AtomConfiguration config) {
        this.config = config;
    }

    public void checkAtom(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        checkStructure(cls, fields);
        checkBehaviour(cls, fields);
    }

    private void checkStructure(Class cls, FieldSpec[] fields) {
        checkClassDeclaration(cls, fields);
        checkConstructor(cls, fields);
        checkClassMethodStructure(cls, fields);
        checkPropertyMethodStructure(cls, fields);
        checkPropertiesImmutable(cls, fields);
    }

    private void checkBehaviour(Class cls, FieldSpec[] fields) {
        checkTriangulationOnProperties(cls, fields);
        checkConstructorRefusesNulls(cls, fields);
    }

    private void checkClassDeclaration(Class cls, FieldSpec[] fields) {
        classChecker.check(cls, fields, config.getType());
    }

    private void checkConstructor(Class cls, FieldSpec[] fields) {
        constructorChecker.check(cls, fields);
    }

    private void checkClassMethodStructure(Class cls, FieldSpec[] fields) {
        classMethodStructureChecker.check(cls, fields);
    }

    private void checkPropertyMethodStructure(Class cls, FieldSpec[] fields) {
        propertyMethodStructureChecker.check(cls, fields);
    }

    private void checkPropertiesImmutable(Class cls, FieldSpec[] fields) {
        if (config.checkImmutable()) immutabilityChecker.check(cls, fields);
    }

    private void checkTriangulationOnProperties(Class cls, FieldSpec[] fields) {
        triangulationChecker.check(cls, fields);
    }

    private void checkConstructorRefusesNulls(Class cls, FieldSpec[] fields) {
        if (config.checkNulls()) constructorNullChecker.check(cls, fields);
    }
}
