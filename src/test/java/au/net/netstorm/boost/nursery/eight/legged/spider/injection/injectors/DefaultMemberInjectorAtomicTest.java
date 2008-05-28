package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMemberInjectorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private MemberInjector subject;
    MemberInjector memberMock;
    Object dummy;

    public void setUpFixtures() {
        MemberInjector[] members = {memberMock};
        subject = new DefaultMemberInjector(members);
    }

    public void testInject() {
        expect.oneCall(memberMock, VOID, "inject", dummy);
        subject.inject(dummy);
    }
}
