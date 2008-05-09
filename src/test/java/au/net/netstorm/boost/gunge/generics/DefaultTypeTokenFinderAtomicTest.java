package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

import au.net.netstorm.boost.edge.core.Edge;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultTypeTokenFinderAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private TypeTokenFinder subject;
    private ParameterizedType matchingType;
    private ParameterizedType differentType;

    public void setUpFixtures() {
        subject = new DefaultTypeTokenFinder(TypeToken.class);
        matchingType = extractParameterizedType(new TypeToken<ByteBuffer>() {});
        differentType = extractParameterizedType(new OtherType<ByteBuffer>() {});
    }

    public void testFind() {
        boolean requireMoreTokens = subject.next(matchingType);
        assertEquals(false, requireMoreTokens);
        assertEquals(matchingType, subject.result());
    }

    public void testCantFindAsNotParameterizedType() {
        checkCantFind(subject.next(Edge.class));
    }

    public void testCantFindAsDifferentTokenType() {
        checkCantFind(subject.next(differentType));
    }

    private void checkCantFind(boolean requireMoreTokens) {
        assertEquals(true, requireMoreTokens);
        try {
            subject.result();
            fail("Accessing result should fail if no match has been found.");
        } catch (RuntimeException expected) { }
    }

    private ParameterizedType extractParameterizedType(Object t) {
        Class<?> c = t.getClass();
        return (ParameterizedType) c.getGenericInterfaces()[0];
    }
}
