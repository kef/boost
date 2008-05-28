package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.lang.reflect.Field;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;

public final class DefaultFieldInjectorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private FieldInjector subject;
    private Field fieldDummy;
    private Dummy instanceDummy;
    FieldTestUtil fielder;
    EdgeField fielderMock;
    Injection injectionMock;
    
    public void setUpFixtures() {
        fieldDummy = fielder.get(Dummy.class, "x");
        instanceDummy = new Dummy();
        subject = new DefaultFieldInjector(injectionMock, fieldDummy);
        fielder.setInstance(subject, "fielder", fielderMock);
    }

    public void testInject() {
        expect.oneCall(injectionMock, "foo", "apply");
        expect.oneCall(fielderMock, VOID, "set", fieldDummy, instanceDummy, "foo");
        subject.inject(instanceDummy);
    }
}
