package au.net.netstorm.boost.util.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import junit.framework.Assert;

// FIXME: SC506 Does it make sense to have this fixtures area?
// FIXME: SC042 Interface it.
class ClassTestFixture {
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
        // FIXME: SC050 ... So the BUG smell here is that we do not need to pass the constructor all the way through to IPTU via NTU.
        // FIXME: SC050 ... Tidying this up will remove a large amount of code.
        Constructor constructor = InstanceTestUtil.getConstructor(cls);
        Class[] expected = constructor.getParameterTypes();
        Class[] params = InstanceTestUtil.getClasses(parameters);
        NullTestUtil.checkNullParameters(constructor, params, additional);
        Assert.assertEquals("Class constructor does not have expected number arguments", expected.length, params.length); // FIXME: SC050 This seems to be back to front
    }
}
