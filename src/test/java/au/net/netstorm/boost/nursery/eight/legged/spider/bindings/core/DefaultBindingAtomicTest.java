package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraint;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultBindingAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private MutableBinding subject;
    FieldTestUtil fielder;
    InjectionType typeMock;
    BindingConstraint constraintMock;
    InjectionSite siteMock;
    Factory factoryMock;

    public void setUpFixtures() {
        subject = new DefaultBinding(typeMock, constraintMock);
        subject.setFactory(factoryMock);
    }
    
    public void testProperties() {
        expect.oneCall(constraintMock, Precedence.RAW, "precedence");
        assertEquals(Precedence.RAW, subject.getPrecedence());
        assertEquals(typeMock, subject.getType());
    }

    public void testFailedValidation() {
        fielder.setInstance(subject, "factory", null);
        try {
            subject.accepts(siteMock);
            fail();
        } catch (IllegalStateException expected) {}
    }

    public void testAccepts() {
        setAcceptExpectations(true, true);
        checkAccept(true);
    }

    public void testConstraintDoesNotAccept() {
        expect.oneCall(constraintMock, false, "accept", siteMock);
        checkAccept(false);
    }

    public void testFactoryDoesNotAccept() {
        setAcceptExpectations(true, false);
        checkAccept(false);
    }

    public void testGetFactory() {
        setAcceptExpectations(true, true);
        Factory result = subject.getFactory(siteMock);
        assertEquals(factoryMock, result);
    }

    public void testGetFactoryFailure() {
        setAcceptExpectations(true, false);
        try {
            subject.getFactory(siteMock);
            fail();
        } catch (IllegalStateException expected) {}
    }

    private void checkAccept(boolean expected) {
        boolean result = subject.accepts(siteMock);
        assertEquals(expected, result);
    }

    private void setAcceptExpectations(boolean constraint, boolean factory) {
        expect.oneCall(constraintMock, constraint, "accept", siteMock);
        expect.oneCall(factoryMock, factory, "canHandle", siteMock);
    }
}
