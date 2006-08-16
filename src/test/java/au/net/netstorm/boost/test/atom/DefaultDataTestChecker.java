package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;

// FIX SC600 Remove OldDTC.

public final class DefaultDataTestChecker implements DataTestChecker {
    private DataChecker constructorChecker = new ConstructorDataChecker();
    private DataChecker methodChecker = new MethodDataChecker();
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private ClassTestChecker classChecker = new DefaultClassTestChecker();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public void checkIsData(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        checkStructure(cls, fields);
        checkCalls(cls, fields);
        // FIX SC600 BREADCRUMB Back here after breadcrumb below.
        //
        // The can be checked by ensuring the field reference is different and the getXxx is different again.
        // Can have any number of private methods.
        // Public methods must match field specifications.
        // Types must be Immutable or PrimitiveImmutable types.
        // Check nulls barf in methods.
        // Check nulls barf in constructor.
        // Check constructor fails with combinations of nulls.  Including arrays with nulls.
        // Check fields are final.
        // Arrays must be copied going in and copied coming out.
        //
        // FIX SC600 BELOW HERE GOES.
        // FIX SC050 Tidy this up.
//        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
//        fixture.checkClassDeclaration(Data.class);
//        Object[] parameters = getInstances(fields);
//        Object instance = getInstance(cls, parameters);
//        MethodTestFixture.checkMethods(instance, fields);
//        MemberTestFixture.checkMembers(instance, fields, parameters);
    }

    private void checkCalls(Class cls, FieldSpec[] fields) {
        // FIX SC600 BREADCRUMB Use instance provider and also perform null checks.
    }

    private void checkStructure(Class cls, FieldSpec[] fields) {
        checkClassDeclaration(cls);
        checkConstructor(cls, fields);
        checkMethods(cls, fields);
    }

    private void checkConstructor(Class cls, FieldSpec[] fields) {
        constructorChecker.check(cls, fields);
    }


    private void checkMethods(Class cls, FieldSpec[] fields) {
        methodChecker.check(cls, fields);
    }

    private void checkClassDeclaration(Class cls) {
        classChecker.checkImplementsAndFinal(cls, Data.class);
        classChecker.checkSubclassOf(cls, Primordial.class);
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
