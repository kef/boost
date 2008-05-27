package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultKeyedRulesAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private KeyedRules subject;
    FieldTestUtil fielder;
    StrictMap rulesMock;
    InjectionType typeMock;
    InjectionType rawMock;
    Iterable keyedRulesMock;

    public void setUpFixtures() {
        subject = new DefaultKeyedRules();
        fielder.setInstance(subject, "rules", rulesMock);
    }

    public void testExistsForReifiedType() {
        expect.oneCall(rulesMock, true, "exists", typeMock);
        checkExists(true);
    }

    public void testExistsForRawType() {
        expect.oneCall(rulesMock, false, "exists", typeMock);
        expect.oneCall(typeMock, rawMock, "raw");
        expect.oneCall(rulesMock, true, "exists", rawMock);
        checkExists(true);
    }

    public void testGetForReifiedType() {
        expect.oneCall(rulesMock, true, "exists", typeMock);
        expect.oneCall(rulesMock, keyedRulesMock, "get", typeMock);
        checkGet();
    }

    public void testGetForRawType() {
        expect.oneCall(rulesMock, false, "exists", typeMock);
        expect.oneCall(typeMock, rawMock, "raw");
        expect.oneCall(rulesMock, keyedRulesMock, "get", rawMock);
        checkGet();
    }

    private void checkGet() {
        Iterable result = subject.get(typeMock);
        assertSame(keyedRulesMock, result);
    }

    private void checkExists(boolean expected) {
        boolean result = subject.exists(typeMock);
        assertEquals(expected, result);
    }
}
