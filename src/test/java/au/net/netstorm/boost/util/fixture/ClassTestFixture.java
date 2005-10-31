package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import junit.framework.Assert;

// FIXME: SC506 Does it make sense to have this fixtures area?
class ClassTestFixture {
    private final Class cls;
    private final FieldSpec[] newArgTypes;

    ClassTestFixture(Class cls, FieldSpec[] newArgTypes) {
        this.cls = cls;
        this.newArgTypes = newArgTypes;
    }

    // FIXME: SC506 ? Allow the intefaces to check to be changes Data vs Immutable.
    static void checkClass(Class cls, FieldSpec[] newArgTypes, Class targetInterface) {
        ClassPropertiesTestUtil.checkSubclassOf(Primordial.class, cls);
        ClassPropertiesTestUtil.checkImplementationOfInterfaceAndFinal(targetInterface, cls);
        new ClassTestFixture(cls, newArgTypes).checkConstructor();
    }

    private void checkConstructor() {
        int length = InstanceTestUtil.getConstructor(cls).getParameterTypes().length;
        NullTestUtil.checkNullParameters(InstanceTestUtil.getConstructor(cls), InstanceTestUtil.getClasses(newArgTypes), length);
        Assert.assertEquals("Class constructor does not have expected number arguments", newArgTypes.length,
                length);
    }
}
