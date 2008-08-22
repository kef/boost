package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.scalpel.testdata.AutoEdgeInputStream;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

import java.io.InputStream;

public final class DefaultEdgedMethodsAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    private EdgedMethods subject;
    StreamFixture stream;
    MethodWarp warperMock;

    public void testLookup() {
        expect.oneCall(warperMock, stream.realMethod(), "warp", InputStream.class, stream.edgeMethod());
        subject = new DefaultEdgedMethods(AutoEdgeInputStream.class, InputStream.class, warperMock);
        Method expected = subject.lookup(stream.edgeMethod());
        assertEquals(stream.realMethod(), expected);
    }
}
