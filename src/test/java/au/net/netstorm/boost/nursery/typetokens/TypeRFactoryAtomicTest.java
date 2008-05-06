package au.net.netstorm.boost.nursery.typetokens;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.registry.Factory;

public class TypeRFactoryAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Factory subject;
    private Linkage linkageMock;

    public void setUpFixtures() {
        subject = new TypeRFactory();
    }

    public void testCanHandle() {
        assertEquals(false, subject.canHandle(linkageMock));
    }

    public void testGet() {
        assertNull(subject.get(linkageMock));
    }

}
