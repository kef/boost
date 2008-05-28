package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Type;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;

public final class DedaultInjectionTypeBuilderAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    InjectionTypeBuilder subject;
    Type typeMock;

    public void setUpFixtures() {
        
    }

    public void testBuild() {
        // FIX 2394 colour me in 
    }
}
