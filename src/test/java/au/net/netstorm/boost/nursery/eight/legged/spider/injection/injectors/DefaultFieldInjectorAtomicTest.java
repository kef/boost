package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import java.lang.reflect.Field;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.Dummy;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultFieldInjectorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private MemberInjector subject;
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
        expect.oneCall(fielderMock, VOID, "get", fieldDummy, instanceDummy);
        expect.oneCall(fielderMock, VOID, "set", fieldDummy, instanceDummy, "foo");
        subject.inject(instanceDummy);
    }

    public void testDontInject() {
        expect.oneCall(fielderMock, "already-set", "get", fieldDummy, instanceDummy);
        subject.inject(instanceDummy);
    }
}
