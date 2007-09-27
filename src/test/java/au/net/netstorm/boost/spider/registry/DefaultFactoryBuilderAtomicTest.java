package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultFactoryBuilderAtomicTest extends InteractionTestCase implements HasFixtures {
    private static final Class SPIDER_MAN = SpiderMan.class;
    Implementation impl = new DefaultImplementation(SPIDER_MAN);
    Interface iface = new DefaultInterface(Factory.class);
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    FactoryBuilder subject;
    Injector injectorMock;
    EdgeClass classerMock;
    TypeMaster typerMock;
    Factory factoryDummy;

    public void setUpFixtures() {
        subject = new DefaultFactoryBuilder(injectorMock);
        fielder.setInstance(subject, "classer", classerMock);
        fielder.setInstance(subject, "typer", typerMock);
    }

    public void testBuildFails() {
        expect.oneCall(typerMock, false, "implementz", impl, iface);
        try {
            subject.build(SPIDER_MAN);
            fail();
        } catch (DoesNotImplementFactoryException expected) { }
    }

    public void testBuildSuccess() {
        expect.oneCall(typerMock, true, "implementz", impl, iface);
        expect.oneCall(classerMock, factoryDummy, "newInstance", SPIDER_MAN);
        expect.oneCall(injectorMock, VOID, "inject", factoryDummy);
        Factory actual = subject.build(SPIDER_MAN);
        assertEquals(factoryDummy, actual);
    }
}
