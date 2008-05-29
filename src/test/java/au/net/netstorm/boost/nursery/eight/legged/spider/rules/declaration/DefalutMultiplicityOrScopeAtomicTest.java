package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

public final class DefalutMultiplicityOrScopeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private MultiplicityOrScope subject;
    RuleBuilder builderMock;

    public void setUpFixtures() {
        subject = new DefaultMultiplicityOrScope(builderMock);
    }

    public void testAsSingle() {
        expect.oneCall(builderMock, VOID, "setIsSingleton");
        subject.asSingle();
    }

    public void testInHost() {
        expect.oneCall(builderMock, VOID, "setScope", TreeHolder.class, Scope.ANY_NAME);
        subject.in(TreeHolder.class);
    }

    public void testInName() {
        expect.oneCall(builderMock, VOID, "setScope", Scope.ANY_HOST, "tree");
        subject.in("tree");
    }

    public void testInHostAndName() {
        expect.oneCall(builderMock, VOID, "setScope", TreeHolder.class, "tree");
        subject.in(TreeHolder.class, "tree");
    }
}
