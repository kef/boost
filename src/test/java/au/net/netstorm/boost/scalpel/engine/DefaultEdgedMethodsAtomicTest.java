package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;
import java.io.InputStream;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.scalpel.testdata.AutoEdgeInputStream;

public final class DefaultEdgedMethodsAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgedMethods subject;
    StreamFixture stream;

    public void setUpFixtures() {
        subject = new DefaultEdgedMethods(AutoEdgeInputStream.class, InputStream.class);
    }

    public void testUnedge() {
        // FIX BREADCRUMB 2328 implement me
        try {
            Method expected = subject.unedge(stream.edgeMethod());
//          assertEquals(stream.realMethod(), expected);
            fail();
        } catch (UnsupportedOperationException expected) {}
    }
}
