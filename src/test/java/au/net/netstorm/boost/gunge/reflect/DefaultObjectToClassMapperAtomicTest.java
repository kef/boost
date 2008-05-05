package au.net.netstorm.boost.gunge.reflect;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultObjectToClassMapperAtomicTest extends LifecycleTestCase implements InjectableTest {
    ObjectToClassMapper subject;

    public void testMap() {
        Class<?> result = subject.map("i am a string");
        assertEquals(String.class, result);
    }
}
