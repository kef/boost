package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxyInjector subject;
    private MockExpectations expect;
    private CreatorProxySupplier creatorProxySupplier;
    private Interface objectToInject;
    private EdgeClass edgeClass;

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector(creatorProxySupplier, edgeClass);
    }

    public void testInject() {
        // FIX 1665 Sort this out in a sec
        Field[] fields = objectToInject.getClass().getDeclaredFields();
        expect.oneCall(edgeClass, fields, "getDeclaredFields", objectToInject.getClass());
        subject.inject(objectToInject);

    }
}
