package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import junit.framework.Assert;

// FIXME: SC506 Does it make sense to have this fixtures area?
// FIXME: SC502 Interface it.
class ClassTestFixture extends Assert {
    private final Class cls;
    private final FieldSpec[] parameters;

    public ClassTestFixture(Class cls, FieldSpec[] parameters) {
        this.cls = cls;
        this.parameters = parameters;
    }

    // FIXME: SC506 ? Allow the intefaces to check to be changes Data vs Immutable.
    public void checkClass(Class targetInterface, InstanceProvider additional) {
        ClassPropertiesTestUtil.checkSubclassOf(Primordial.class, cls);
        ClassPropertiesTestUtil.checkImplementationOfInterfaceAndFinal(targetInterface, cls);
        checkConstructor(additional);
    }

    private void checkConstructor(InstanceProvider additional) {
        // FIXME: SC050 Revisit this clusterfuck.  Is "types" actually the same as "classes".  If so, remove a bunch of rot.
        Constructor constructor = InstanceTestUtil.getConstructor(cls);
        Class[] types = constructor.getParameterTypes();
        int length = types.length;
        Class[] classes = InstanceTestUtil.getClasses(parameters);
        NullTestUtil.checkNullParameters(constructor, classes);
        assertEquals("Class constructor does not have expected number arguments", length, parameters.length);
    }
}
