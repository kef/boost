package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.checker.ClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX SC502 Does it make sense to have this fixtures area?
// FIX SC600 Remove.  Or morph.
final class ClassTestFixture {
    private final ClassTestChecker clsChecker = new DefaultClassTestChecker();
    private final ReflectMaster reflectMaster = new DefaultReflectMaster();
    private final Class cls;

    public ClassTestFixture(Class cls, FieldSpec[] parameters) {
        this.cls = cls;
    }

    // FIX S502 ? Allow the interfaces to check to be changes Data vs Immutable.
    public void checkClass(Class targetInterface) {
        clsChecker.checkSubclassOf(cls, Primordial.class);
        clsChecker.checkImplementsAndFinal(cls, targetInterface);
        checkConstructor();
    }

    private void checkConstructor() {
        // FIX SC050 ... So the BUG smell here is that we do not need to pass the constructor all the way through to IPTU via NTU.
        // FIX SC050 ... Tidying this up will remove a large amount of code.
        Constructor constructor = reflectMaster.getConstructor(cls);
//        Class[] expected = instancer.getClasses(parameters);
        Class[] actual = constructor.getParameterTypes();
//        nuller.checkNullConstructorParameters(constructor, expected);
//        Assert.assertEquals("Class constructor does not have expected number arguments", expected.length, actual.length);
    }
}
