package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;
import java.util.List;
import au.net.netstorm.boost.bullet.mirror.ReflectObjectMaster;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultCompatibleSignaturesFilterAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {

    private CompatibleSignaturesFilter subject;
    private Class<?>[] target = {};
    private Constructor<?> ctor;
    private Class<?>[] ctorTypes;
    MethodSignatureRules jlsMock;
    ReflectObjectMaster objectMaster;
    List<Class<?>> targetMock;

    public void setUpFixtures() {
        expect.oneCall(targetMock, 0, "size");
        expect.oneCall(targetMock, target, "toArray", new Object[]{new Class[0]});
        subject = new DefaultCompatibleSignaturesFilter(targetMock);
        ctor = objectMaster.getConstructor(DefaultCompatibleSignaturesFilter.class);
        ctorTypes = ctor.getParameterTypes();
    }

    public void testFilterAllow() {
        checkAllow(true);
    }

    public void testFilterDisallow() {
        checkAllow(false);
    }

    private void checkAllow(boolean expectation) {
        expect.oneCall(jlsMock, expectation, "compatible", ctorTypes, target);
        boolean result = subject.accept(ctor);
        assertEquals(expectation, result);
    }
}
