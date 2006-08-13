package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.checker.ClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.serialize.SerializationTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import junit.framework.Assert;

// FIX SC600 Rename FieldSpec to NamedType.  FieldSpec and BeanSpec can then extend NamedType.
// FIX SC600 checkIsData should take in BeanSpecs.

public final class DefaultDataTestChecker implements DataTestChecker {
    private InstanceTestUtil instancer = new DefaultInstanceTestUtil();
    private ClassTestChecker classChecker = new DefaultClassTestChecker();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public void checkIsData(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        checkClass(cls);
        checkConstructor(cls, fields);
        //
        // Checks is Data.class
        // Check extends Primordial.class
        // Check constructor fails with combinations of nulls.  Including arrays with nulls.
        // Arrays must be copied going in and copied coming out.
        // Can have any number of private methods.
        // Public methods must match field specifications.
        // Types must be Immutable or PrimitiveImmutable types.
        //
        // FIX SC050 Tidy this up.
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        fixture.checkClass(Data.class);
        Object[] parameters = getInstances(fields);
        Object instance = getInstance(cls, parameters);
        // Check if Serializable.
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, fields);
        MemberTestFixture.checkMembers(instance, fields, parameters);
    }

    private void checkClass(Class cls) {
        classChecker.checkImplementsAndFinal(cls, Data.class);
        classChecker.checkSubclassOf(cls, Primordial.class);
    }

    private void checkConstructor(Class cls, FieldSpec[] fields) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        Class[] declaredTypes = constructor.getParameterTypes();
        Class[] expectedTypes = getTypes(fields);
        checkConstructor(expectedTypes, declaredTypes);
        // Checks constructor matches provided field specs.
    }

    private void checkConstructor(Class[] expectedTypes, Class[] declaredTypes) {
        int length = expectedTypes.length;
        Assert.assertEquals("Constructor must have " + length + "arguments", length, declaredTypes.length);
    }

    private Class[] getTypes(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }

    private Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        return getInstance(constructor, parameters);
    }

    private Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = getTypes(fields);
        return triangulationProvider.getInstances(classes);
    }

    private Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}