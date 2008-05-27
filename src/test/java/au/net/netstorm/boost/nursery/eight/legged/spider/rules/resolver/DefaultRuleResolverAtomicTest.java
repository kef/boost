package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import java.util.Iterator;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.Rules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultRuleResolverAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleResolver subject;
    Rules rulesMock;
    InjectionSite siteMock;
    Rule ruleMock;
    RuleResolverChecker checker;
    Iterator iteratorMock;


    public void setUpFixtures() {
        subject = new DefaultRuleResolver(rulesMock);
    }

    public void testResolveKeyed() {
        setExpectations(true);
        expect.oneCall(iteratorMock, ruleMock, "next");
        expect.oneCall(ruleMock, true, "accepts", siteMock);
        checker.checkResolved(subject, siteMock, ruleMock);
     }

     public void testUnResolvable() {
         setExpectations(false);
         checker.checkUnResolvable(subject, siteMock);
     }

    private void setExpectations(boolean hasAny) {
        expect.oneCall(rulesMock, iteratorMock, "iterator");
        expect.oneCall(iteratorMock, hasAny, "hasNext");
    }
}
