package au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver;

import java.util.Iterator;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.KeyedRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections.WildcardRules;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.Rule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.KeyedRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.core.WildcardRule;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2394 something bad happened here, this is a crazy
public final class DefaultRuleResolverAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private RuleResolver subject;
    FieldTestUtil fielder;
    KeyedRules keyedMock;
    WildcardRules wildcardedMock;
    InjectionSite siteMock;
    InjectionType typeMock;
    Iterable iterableMock;
    Iterator keyedIteratorMock;
    Iterator wildcardedIteratorMock;
    KeyedRule keyedRuleMock;
    WildcardRule wildcardRuleMock;

    public void setUpFixtures() {
        subject = new DefaultRuleResolver(keyedMock, wildcardedMock);
        fielder.setInstance(subject, "keyed", keyedMock);
        fielder.setInstance(subject, "wildcarded", wildcardedMock);
    }

    public void testResolveKeyed() {
        setKeyedOrWildcardedExpectations(true);
        setResolveKeyedExpectations(true);
        setRuleAcceptsExpectations(keyedIteratorMock, keyedRuleMock);
        checkResolve(keyedRuleMock);
    }

    public void testResolvedWildcarded() {
        setKeyedOrWildcardedExpectations(false);
        setResolveWildcardedExpectations(true);
        setRuleAcceptsExpectations(wildcardedIteratorMock, wildcardRuleMock);
        checkResolve(wildcardRuleMock);
    }

    public void testResolvedWildcardFallback() {
        setKeyedOrWildcardedExpectations(true);
        setResolveKeyedExpectations(false);
        setResolveWildcardedExpectations(true);
        setRuleAcceptsExpectations(wildcardedIteratorMock, wildcardRuleMock);
        checkResolve(wildcardRuleMock);
    }

    public void testUnresolvable() {
        setKeyedOrWildcardedExpectations(false);
        setResolveWildcardedExpectations(false);
        checkUnresolvable();
    }

    private void checkUnresolvable() {
        try {
            subject.resolve(siteMock);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private void checkResolve(Rule expected) {
        Rule result = subject.resolve(siteMock);
        assertSame(expected, result);
    }

    private void setKeyedOrWildcardedExpectations(boolean keyed) {
        expect.oneCall(siteMock, typeMock, "type");
        expect.oneCall(keyedMock, keyed, "exists", typeMock);
    }

    private void setResolveWildcardedExpectations(boolean hasElements) {
        expect.oneCall(wildcardedMock, wildcardedIteratorMock, "iterator");
        expect.oneCall(wildcardedIteratorMock, hasElements, "hasNext");
    }

    private void setResolveKeyedExpectations(boolean hasElements) {
        expect.oneCall(keyedMock, iterableMock, "get", typeMock);
        expect.oneCall(iterableMock, keyedIteratorMock, "iterator");
        expect.oneCall(keyedIteratorMock, hasElements, "hasNext");
    }

    private void setRuleAcceptsExpectations(Iterator iter, Rule rule) {
        expect.oneCall(iter, rule, "next");
        expect.oneCall(rule, true, "accepts", siteMock);
    }
}
