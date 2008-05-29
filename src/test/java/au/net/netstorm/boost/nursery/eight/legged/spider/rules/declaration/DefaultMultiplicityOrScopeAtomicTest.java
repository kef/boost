package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.HostMatcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.NameMatcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.MultiMatcher;

public final class DefaultMultiplicityOrScopeAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private MultiplicityOrScope subject;
    RuleBuilder builderMock;

    public void setUpFixtures() {
        subject = new DefaultMultiplicityOrScope(builderMock);
    }

    public void testAsSingle() {
        expect.oneCall(builderMock, VOID, "setIsSingleton", true);
        subject.asSingle();
    }

    public void testAsMulti() {
        expect.oneCall(builderMock, VOID, "setIsSingleton", false);
        subject.asMulti();
    }

    public void testInHost() {
        MockClassEquals expected = new MockClassEquals(HostMatcher.class);
        expect.oneCall(builderMock, VOID, "setScope", expected);
        subject.in(TreeHolder.class);
    }

    public void testInName() {
        MockClassEquals expected = new MockClassEquals(NameMatcher.class);
        expect.oneCall(builderMock, VOID, "setScope", expected);
        subject.in("tree");
    }

    public void testInHostAndName() {
        MockClassEquals expected = new MockClassEquals(MultiMatcher.class);
        expect.oneCall(builderMock, VOID, "setScope", expected);
        subject.in(TreeHolder.class, "tree");
    }
}
