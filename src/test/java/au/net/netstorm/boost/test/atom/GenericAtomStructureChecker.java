package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class GenericAtomStructureChecker implements AtomStructureChecker {

    private ClassChecker classChecker = new DefaultClassChecker();
    private DataChecker constructorChecker = new ConstructorDataChecker();
    private DataChecker classMethodStructureChecker = new ClassMethodStructureDataChecker();
    private DataChecker propertyMethodStructureChecker = new PropertyMethodStructureChecker();
    private DataChecker immutabilityChecker = new ImmutabilityDataChecker();
    private AtomConfiguration config;

    public GenericAtomStructureChecker(AtomConfiguration config) {
        this.config = config;
    }

    public void checkStructure(Class cls, FieldSpec[] fields) {
        checkClassDeclaration(cls, fields);
        checkConstructor(cls, fields);
        checkClassMethodStructure(cls, fields);
        checkPropertyMethodStructure(cls, fields);
        checkPropertiesImmutable(cls, fields);
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


}
