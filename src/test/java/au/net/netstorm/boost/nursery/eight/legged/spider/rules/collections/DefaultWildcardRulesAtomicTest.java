package au.net.netstorm.boost.nursery.eight.legged.spider.rules.collections;

import java.util.List;
import java.util.Iterator;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultWildcardRulesAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private WildcardRules subject;
    FieldTestUtil fielder;
    List rulesMock;
    Iterator iterMock;

    public void setUpFixtures() {
        subject = new DefaultWildcardRules();
        fielder.setInstance(subject, "rules", rulesMock);
    }

    public void testIterator() {
        expect.oneCall(rulesMock, iterMock, "iterator");
        Iterator iter = subject.iterator();
        assertSame(iterMock, iter);
    }
}
