package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

import au.net.netstorm.boost.gunge.generics.TypeToken;
import au.net.netstorm.boost.nursery.autoedge.Edge;
import au.net.netstorm.boost.nursery.autoedge.testdata.AutoEdgeByteBuffer;
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
        subject = new DefaultTypeTokenFinder(Edge.class);
        matchingType = extractParameterizedType(AutoEdgeByteBuffer.class);
        differentType = extractParameterizedType(new TypeToken<ByteBuffer>() {}.getClass());
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
        } catch (RuntimeException e) { /* expected */ }
    }

    private ParameterizedType extractParameterizedType(Class<?> c) {
        return (ParameterizedType) c.getGenericInterfaces()[0];
    }
}
