package au.net.netstorm.boost.gunge.reflect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.gunge.primitives.PrimitiveBoxer;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMethodSignatureRulesAtomicTest extends LifecycleTestCase implements InjectableSubject, InjectableTest, LazyFields {
    private Class<?>[] generic = {List.class, Set.class, Map.class};
    private Class<?>[] specific = {ArrayList.class, HashSet.class, HashMap.class};
    private Class<?>[] mixed = {List.class, HashSet.class, Map.class};
    private Class<?>[] primitive = {int.class};
    private Class<?>[] boxed = {Integer.class};
    private Class<?>[] dodge = {};
    MethodSignatureRules subject;
    PrimitiveBoxer boxer;

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

    public void testNotCompatibleWithIncorrectSize() {
        checkCompatible(false, mixed, dodge);
        checkCompatible(false, specific, dodge);
        checkCompatible(false, generic, dodge);
    }

    public void testCompatibleWithBoxing() {
        checkCompatible(true, primitive, boxed);
        checkCompatible(true, boxed, primitive);
    }

    public void testMoreSpecific() {
        checkMoreSpecific(true, mixed, specific);
        checkMoreSpecific(true, generic, specific);
        checkMoreSpecific(true, generic, mixed);
    }

    public void testNotMoreSpecific() {
        checkMoreSpecific(false, generic, generic);
        checkMoreSpecific(false, mixed, generic);
        checkMoreSpecific(false, specific, generic);
        checkMoreSpecific(false, specific, mixed);
        checkMoreSpecific(false, mixed, mixed);
        checkMoreSpecific(false, specific, specific);
    }

    private void checkCompatible(Class<?>[] types) {
        checkCompatible(true, types, types);
    }

    private void checkCompatible(boolean expected, Class<?>[] target, Class<?>[] canIBeAssignedToTarget) {
        assertEquals(expected, subject.compatible(target, canIBeAssignedToTarget));
    }

    private void checkMoreSpecific(boolean expected, Class<?>[] lhs, Class<?>[] rhs) {
        assertEquals(expected, subject.moreSpecific(lhs, rhs));
    }
}
