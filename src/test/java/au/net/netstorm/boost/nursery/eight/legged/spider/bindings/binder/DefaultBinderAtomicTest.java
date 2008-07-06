package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.DefaultBinding;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Precedence;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Binding;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraintFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints.BindingConstraint;

public final class DefaultBinderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Binder subject;
    FieldTestUtil fielder;
    BindingConstraintFactory constraintsMock;
    InjectionTypeBuilder typerMock;
    InjectionType typeMock;
    Bindings bindingsMock;
    BindingConstraint constraintMock;
    Class hostDummy;
    Class ifaceDummy;
    String nameDummy;

    public void setUpFixtures() {
        subject = new DefaultBinder(bindingsMock);
        fielder.setInstance(subject, "typer", typerMock);
        fielder.setInstance(subject, "constraints", constraintsMock);
    }

    public void testBind() {
        setBindingExpectations(Precedence.RAW);
        Target result = subject.bind(ifaceDummy);
        checkBinding(result);
    }

    public void testBindName() {
        setBindingExpectations(Precedence.NAMED, nameDummy);
        Target result = subject.bind(ifaceDummy, nameDummy);
        checkBinding(result);
    }

    public void testBindHost() {
        setBindingExpectations(Precedence.HOSTED, hostDummy);
        Target result = subject.bind(ifaceDummy, hostDummy);
        checkBinding(result);
    }

    public void testBindHostAndName() {
        setBindingExpectations(Precedence.HOSTED_AND_NAMED, hostDummy, nameDummy);
        Target result = subject.bind(ifaceDummy, hostDummy, nameDummy);
        checkBinding(result);
    }

    private void checkBinding(Target result) {
        assertEquals(true, result instanceof DefaultTarget);
    }

    private void setBindingExpectations(Precedence precedence, Object... constraints) {
        Binding binding = new DefaultBinding(typeMock, constraintMock);
        expect.oneCall(typerMock, typeMock, "build", ifaceDummy);
        expect.oneCall(constraintsMock, constraintMock, "nu", constraints);
        expect.oneCall(bindingsMock, VOID, "add", binding);
    }
}
