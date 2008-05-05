package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

public final class DefaultTypeInstanceAtomicTest extends LifecycleTestCase implements HasFixtures {
    private TypeInstance subject;
    private ParameterizedType rawTypeToken;
    private ParameterizedType genericTypeToken;
    private ParameterizedType multiArgs;
    private ParameterizedType genericArgs;

    public void setUpFixtures() {
        rawTypeToken = extractTypeFromSuperInterface(new TypeToken<String>() {
        }.getClass());
        genericTypeToken = extractTypeFromSuperInterface(new TypeToken<List<String>>() {
        }.getClass());
        multiArgs = extractTypeFromSuperClass(HashMap.class);
        genericArgs = extractTypeFromSuperClass(ArrayList.class);
    }

    public void testWithRawTypeToken() {
        subject = new DefaultTypeInstance(rawTypeToken);
        assertEquals(String.class, subject.raw());
    }

    public void testWithGenericTypeToken() {
        subject = new DefaultTypeInstance(genericTypeToken);
        assertEquals(List.class, subject.raw());
    }

    public void testWithMultipleSuperTypeArgs() {
        try {
            new DefaultTypeInstance(multiArgs);
            fail("Should not be able to create a type token instance with multiple type arguments.");
        } catch (IllegalArgumentException expected) { }
    }

    public void testWithGenericTypeArgs() {
        try {
            new DefaultTypeInstance(genericArgs);
            fail("Should not be able to create a type token instance with genric type arguments.");
        } catch (IllegalArgumentException expected) { }
    }

    private ParameterizedType extractTypeFromSuperClass(Class<?> c) {
        return (ParameterizedType) c.getGenericSuperclass();
    }

    private ParameterizedType extractTypeFromSuperInterface(Class<?> c) {
        return (ParameterizedType) c.getGenericInterfaces()[0];
    }
}
