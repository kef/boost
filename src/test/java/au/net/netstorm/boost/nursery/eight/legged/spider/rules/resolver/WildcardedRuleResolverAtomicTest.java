package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import java.util.Iterator;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.WildcardRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.WildcardRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class WildcardedRuleResolverAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleResolver subject;
    WildcardRules wildcardedMock;
    InjectionSite siteMock;
    WildcardRule wildcardRuleMock;
    RuleResolverChecker checker;
    Iterator iteratorMock;


    public void setUpFixtures() {
        subject = new WildcardedRuleResolver(wildcardedMock);
    }

    public void testResolveKeyed() {
        setExpectations(true);
        expect.oneCall(iteratorMock, wildcardRuleMock, "next");
        expect.oneCall(wildcardRuleMock, true, "accepts", siteMock);
        checker.checkResolved(subject, siteMock, wildcardRuleMock);
     }

     public void testUnResolvable() {
         setExpectations(false);
         checker.checkUnResolvable(subject, siteMock);
     }

    private void setExpectations(boolean hasAny) {
        expect.oneCall(wildcardedMock, iteratorMock, "iterator");
        expect.oneCall(iteratorMock, hasAny, "hasNext");
    }
}
