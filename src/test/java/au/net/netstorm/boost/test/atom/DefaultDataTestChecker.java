package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX SC600 Think about how to incorporate a test with a marker interface which uses field
// FIX SC600 introspection to determine which properties.  Declaration of a single array
// FIX SC600 is probably enough to specify field/property order.  Might use volatile or
// FIX SC600 transient to mark fields as optional.
// FIX SC600 Rename to DataAtomTestChecker.
// FIX SC600 Remove OldDTC.
// FIX SC600 Narrow scope in this package.  Private classes for all but DDTC.
public final class DefaultDataTestChecker implements DataTestChecker {
    private DataChecker classChecker = new ClassDataChecker();
    private DataChecker constructorChecker = new ConstructorDataChecker();
    private DataChecker classMethodStructureChecker = new ClassMethodStructureDataChecker();
    private DataChecker propertyMethodStructureChecker = new PropertyMethodStructureChecker();
    private DataChecker immutabilityChecker = new ImmutabilityDataChecker();
    private DataChecker triangulationChecker = new PropertyTriangulationDataChecker();
    private DataChecker constructorNullChecker = new ConstructorNullDataChecker();

    public void checkIsData(Class cls, FieldSpec[] fields) {
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

        // FIX SC600 BREADCRUMB Complete.
        // Arrays with nulls.
        // Arrays must be copied going in and copied coming out.
    }

    private void checkClassDeclaration(Class cls, FieldSpec[] fields) {
        classChecker.check(cls, fields);
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
        immutabilityChecker.check(cls, fields);
    }

    private void checkTriangulationOnProperties(Class cls, FieldSpec[] fields) {
        triangulationChecker.check(cls, fields);
    }

    private void checkConstructorRefusesNulls(Class cls, FieldSpec[] fields) {
        constructorNullChecker.check(cls, fields);
    }
}
