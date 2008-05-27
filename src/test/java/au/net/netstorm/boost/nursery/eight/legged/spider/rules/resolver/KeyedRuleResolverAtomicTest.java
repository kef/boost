package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import java.util.Iterator;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.KeyedRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.WildcardRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class KeyedRuleResolverAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleResolver subject;
    KeyedRules keyedMock;
    RuleResolver wildcardedMock;
    InjectionSite siteMock;
    InjectionType typeMock;
    KeyedRule keyedRuleMock;
    WildcardRule wildcardRuleMock;
    RuleResolverChecker checker;
    Iterable iterableMock;
    Iterator iteratorMock;


    public void setUpFixtures() {
        subject = new KeyedRuleResolver(keyedMock, wildcardedMock);
    }

    public void testNonKeyed() {
        expect.oneCall(siteMock, typeMock, "type");
        expect.oneCall(keyedMock, false, "exists", typeMock);
        expect.oneCall(wildcardedMock, wildcardRuleMock, "resolve", siteMock);
        checker.checkResolved(subject, siteMock, wildcardRuleMock);
    }

    public void testResolveKeyed() {
        setExpectations(true);
        expect.oneCall(iteratorMock, keyedRuleMock, "next");
        expect.oneCall(keyedRuleMock, true, "accepts", siteMock);
        checker.checkResolved(subject, siteMock, keyedRuleMock);
     }

     public void testResolvedWildcardFallback() {
         setExpectations(false);
         expect.oneCall(wildcardedMock, wildcardRuleMock, "resolve", siteMock);
         checker.checkResolved(subject, siteMock, wildcardRuleMock);
     }

    private void setExpectations(boolean hasAny) {
        expect.oneCall(siteMock, typeMock, "type");
        expect.oneCall(keyedMock, true, "exists", typeMock);
        expect.oneCall(keyedMock, iterableMock, "get", typeMock);
        expect.oneCall(iterableMock, iteratorMock, "iterator");
        expect.oneCall(iteratorMock, hasAny, "hasNext");
    }
}
