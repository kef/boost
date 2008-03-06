package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultTypeMasterAtomicTest extends LifecycleTestCase implements LazyFields {
    TypeMaster subject = new DefaultTypeMaster();
    Class lollyClass = JuicyLolly.class;
    Interface lollyIface = new DefaultInterface(Lolly.class);
    Interface celeryIface = new DefaultInterface(Celery.class);
    Interface edibleIface = new DefaultInterface(Edible.class);
    Interface tastyIface = new DefaultInterface(Tasty.class);
    Interface thingIface = new DefaultInterface(Thing.class);
    Interface juicyIface = new DefaultInterface(Juicy.class);
    Interface desirableIface = new DefaultInterface(Desirable.class);
    Implementation lollyImpl = new DefaultImplementation(lollyClass);

    public void testImplements() {
        checkImplements(lollyImpl, lollyIface, true);
        checkImplements(lollyImpl, edibleIface, true);
        checkImplements(lollyImpl, celeryIface, false);
    }

    public void testExtends() {
        checkExtends(false, lollyIface, celeryIface);
        checkExtends(true, lollyIface, edibleIface);
    }

    public void testInterfaces() {
        Interface[] actual = subject.interfaces(lollyIface);
        Interface[] expected = {lollyIface, edibleIface, tastyIface, thingIface};
        assertBagEquals(expected, actual);
    }

    public void testImplementationInterfaces() {
        Interface[] actual = subject.interfaces(lollyImpl);
        Interface[] expected = {lollyIface, edibleIface, tastyIface, thingIface, juicyIface, desirableIface};
        assertBagEquals(expected, actual);
    }

    public void testDeclaredInterfaces() {
        Interface[] actual = subject.declaredInterfaces(lollyIface);
        Interface[] expected = {edibleIface, tastyIface};
        assertBagEquals(expected, actual);
    }

    public void testDeclaredImplementationInterfaces() {
        Interface[] actual = subject.declaredInterfaces(lollyImpl);
        Interface[] expected = {lollyIface, juicyIface};
        assertBagEquals(expected, actual);
    }

    private void checkExtends(boolean expected, Interface sub, Interface supa) {
        boolean actual = subject.extendz(sub, supa);
        assertEquals(expected, actual);
    }

    private void checkImplements(Implementation implementation, Interface iFace, boolean expected) {
        boolean actual = subject.implementz(implementation, iFace);
        assertEquals(expected, actual);
    }
}
