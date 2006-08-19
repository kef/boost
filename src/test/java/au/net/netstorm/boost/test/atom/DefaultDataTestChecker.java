package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;

import java.lang.reflect.Constructor;

// FIX SC600 Think about how to incorporate a test with a marker interface which uses field
// FIX SC600 introspection to determine which properties.  Declaration of a single array
// FIX SC600 is probably enough to specify field/property order.  Might use volatile or
// FIX SC600 transient to mark fields as optional.
// FIX SC600 Rename to DataAtomTestChecker.
// FIX SC600 Remove OldDTC.
// FIX SC600 Narrow scope in this package.  Private classes for all but DDTC.
public final class DefaultDataTestChecker implements DataTestChecker {
    private DataChecker constructorChecker = new ConstructorDataChecker();
    private DataChecker classMethodStructureChecker = new ClassMethodStructureDataChecker();
    private DataChecker propertyMethodStructureChecker = new PropertyMethodStructureChecker();
    private DataChecker classChecker = new ClassDataChecker();
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public void checkIsData(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        checkStructure(cls, fields);
        checkBehaviour(cls, fields);
        // FIX SC600 BREADCRUMB Back here after breadcrumb below.
        //
        // Public methods must match field specifications.
        // Types must be Immutable or PrimitiveImmutable types.
        // Check nulls barf in methods.
        // Check nulls barf in constructor.
        // Check constructor fails with combinations of nulls.  Including arrays with nulls.
        // Check fields are final.
        // Arrays must be copied going in and copied coming out.
    }

    private void checkBehaviour(Class cls, FieldSpec[] fields) {
        // FIX SC600 BREADCRUMB Use instance provider and also perform null checks.
    }

    private void checkStructure(Class cls, FieldSpec[] fields) {
        checkClassDeclaration(cls, fields);
        checkConstructor(cls, fields);
        checkClassMethodStructure(cls, fields);
        checkPropertyMethodStructure(cls, fields);
    }

    private void checkPropertyMethodStructure(Class cls, FieldSpec[] fields) {
        propertyMethodStructureChecker.check(cls, fields);
    }

    private void checkConstructor(Class cls, FieldSpec[] fields) {
        constructorChecker.check(cls, fields);
    }

    private void checkClassMethodStructure(Class cls, FieldSpec[] fields) {
        classMethodStructureChecker.check(cls, fields);
    }

    private void checkClassDeclaration(Class cls, FieldSpec[] fields) {
        classChecker.check(cls, fields);
    }

    private Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        return getInstance(constructor, parameters);
    }

    private Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = fieldSpecUtil.getTypes(fields);
        return triangulationProvider.getInstances(classes);
    }

    private Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}
