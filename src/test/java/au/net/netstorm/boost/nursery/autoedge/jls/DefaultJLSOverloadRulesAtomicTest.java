package au.net.netstorm.boost.nursery.autoedge.jls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultJLSOverloadRulesAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    private Class<?>[] generic = { List.class, Set.class, Map.class };
    private Class<?>[] specific = { ArrayList.class, HashSet.class, HashMap.class };
    private Class<?>[] mixed = { List.class, HashSet.class, Map.class };
    JLSOverloadRules uut;

    public void testCompatibleWithSelf() {
        checkCompatible(generic);
        checkCompatible(specific);
        checkCompatible(mixed);
    }

    public void testCompatibleWithMoreGeneric() {
        checkCompatible(true, generic, mixed);
        checkCompatible(true, generic, specific);
    }

    public void testNotCompatibleWithMoreSpecific() {
        checkCompatible(false, mixed, generic);
        checkCompatible(false, specific, mixed);
        checkCompatible(false, specific, generic);
    }

    public void testMoreSpecific() {
        checkMoreSpecific(true, specific, mixed);
        checkMoreSpecific(true, specific, generic);
        checkMoreSpecific(true, mixed, generic);
    }

    public void testNotMoreSpecific() {
        checkMoreSpecific(false, generic, generic);
        checkMoreSpecific(false, generic, mixed);
        checkMoreSpecific(false, generic, specific);
        checkMoreSpecific(false, mixed, specific);
        checkMoreSpecific(false, mixed, mixed);
        checkMoreSpecific(false, specific, specific);
    }

    private void checkCompatible(Class<?>[] types) {
        checkCompatible(true, types, types);
    }

    private void checkCompatible(boolean expected, Class<?>[] lhs, Class<?>[] rhs) {
        assertEquals(expected, uut.compatible(lhs, rhs));
    }

    private void checkMoreSpecific(boolean expected, Class<?>[] lhs, Class<?>[] rhs) {
        assertEquals(expected, uut.moreSpecific(lhs, rhs));
    }
}
