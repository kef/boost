package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import org.jmock.Mock;

// FIX 1665 Remove jMock.
public final class DefaultCreatorProxyInjectorAtomicTest extends PrimordialTestCase implements UsesMocks {
    private CreatorProxyInjector subject;
    private MockExpectations expect;
    private CreatorProxySupplier creatorProxySupplier;
    private Interface objectToInject;
    private EdgeClass edgeClass;
    private String nameWithNewInIt = "NewMonkey";

    public void setupSubjects() {
        subject = new DefaultCreatorProxyInjector(creatorProxySupplier);
    }

    // FIX 1665 Rename.  CreatorInjector.
    // FIX 1665 Remove
    public void testNothing() {
        subject.inject(objectToInject);
    }

    // FIX BREADCRUMB 1665
    public void brokenInject() {
        // FIX 1665 Not an interface
        Class type = objectToInject.getClass();
        // FIX 1665 Sort this out in a sec
        Field[] fields = type.getDeclaredFields();
        expect.oneCall(edgeClass, fields, "getDeclaredFields", type);
        expectAllFieldsToBeCreators(fields, type);
        subject.inject(objectToInject);
    }

    private void expectAllFieldsToBeCreators(Field[] fields, Class type) {
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            setExpectationsForFindingCreatorFields(field, type);
            callProxySupplierAndInject(field, type);
        }
    }

    private void setExpectationsForFindingCreatorFields(Field field, Class type) {
        expect.oneCall(field, type, "getType");
        expect.oneCall(type, nameWithNewInIt, "getName");
        expect.oneCall(field, null, "get");
        expect.oneCall(field, VOID, "setAccessible", Boolean.TRUE);
    }

    private void callProxySupplierAndInject(Field field, Class type) {
        Object creatorProxy = createCreatorProxy();
        expect.oneCall(creatorProxySupplier, creatorProxy, "create", new DefaultInterface(type));
        expect.oneCall(field, VOID, "set", objectToInject, creatorProxy);
    }

    private Object createCreatorProxy() {
        Mock mockCreatorProxy = new Mock(GenericCreator.class);
        return mockCreatorProxy.proxy();
    }
}
