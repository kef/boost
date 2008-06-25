package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.scalpel.testdata.java.util.List;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DedaultInjectionTypeBuilderAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private List<String> dummy;
    private Type parameterized;
    InjectionTypeBuilder subject;
    InjectionTypeChecker checker;
    FieldTestUtil fielder;
    Type typeMock;

    public void setUpFixtures() {
        Field f = fielder.get(DedaultInjectionTypeBuilderAtomicTest.class,  "dummy");
        parameterized = f.getGenericType();
    }

    public void testBuildRaw() {
        InjectionType result = subject.build(String.class);
        checker.checkType(result, result, String.class);
    }

    public void testBuildParameterized() {
        InjectionType result = subject.build(parameterized);
        checker.checkType(result, result, List.class);
    }
}
