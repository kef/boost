package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.constraints;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultBindingConstraintFactoryAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    BindingConstraintFactory subject;
    String nameDummy;
    Class<?> hostDummy;

    public void testNu() {
        BindingConstraint result = subject.nu();
        checkConstraint(result, AnyBindingConstraint.class);
    }

    public void testNuNamed() {
        BindingConstraint result = subject.nu(nameDummy);
        checkConstraint(result, NamedBindingConstraint.class);
    }

    public void testNuHosted() {
        BindingConstraint result = subject.nu(hostDummy);
        checkConstraint(result, HostedBindingConstraint.class);
    }

    public void testNuHostedAndNamed() {
        BindingConstraint result = subject.nu(hostDummy, nameDummy);
        checkConstraint(result, HostedAndNamedBindingConstraint.class);
    }

    private void checkConstraint(BindingConstraint result, Class expected) {
        assertEquals(true, expected.isInstance(result));
    }
}
