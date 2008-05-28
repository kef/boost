package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultInjectionTypeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionType subject;

    public void setUpFixtures() {
        subject = new DefaultInjectionType(String.class);
    }

    public void testInjectionType() {
        checkParameters();
        checkRaw(subject);
        checkRawClass(String.class);
    }

    public void testInjectionTypeFailure() {
        try {
            new DefaultInjectionType(null);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private void checkParameters() {
        // FIX 2394 add test to support parametized types
        try {
            subject.parameters();
            fail();
        } catch (UnsupportedOperationException expected) {}
    }

    private void checkRaw(InjectionType expected) {
        InjectionType result = subject.raw();
        assertEquals(expected, result);
    }

    private void checkRawClass(Class<?> expected) {
        Class<?> result = subject.rawClass();
        assertEquals(expected, result);
    }
}
