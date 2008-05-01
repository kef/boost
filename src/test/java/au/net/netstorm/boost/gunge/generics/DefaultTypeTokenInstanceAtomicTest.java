package au.net.netstorm.boost.gunge.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

public final class DefaultTypeTokenInstanceAtomicTest extends LifecycleTestCase implements HasFixtures {
    private TypeTokenInstance subject;
    private ParameterizedType rawTypeToken;
    private ParameterizedType genericTypeToken;
    private ParameterizedType multiArgs;
    private ParameterizedType genericArgs;

    public void setUpFixtures() {
        rawTypeToken = extractTypeFromSuperInterface(new TypeToken<String>() {}.getClass());
        genericTypeToken= extractTypeFromSuperInterface(new TypeToken<List<String>>() {}.getClass());
        multiArgs = extractTypeFromSuperClass(HashMap.class);
        genericArgs = extractTypeFromSuperClass(ArrayList.class);
    }

    public void testWithRawTypeToken() {
        subject = new DefaultTypeTokenInstance(rawTypeToken);
        assertEquals(String.class, subject.rawType());
    }

    public void testWithGenericTypeToken() {
        try {
            new DefaultTypeTokenInstance(genericTypeToken);
            fail("Generic type tokens are not supported yet.");
        } catch (IllegalArgumentException e) { /* expected */ }
    }

    public void testWithMultipleSuperTypeArgs() {
        try {
            new DefaultTypeTokenInstance(multiArgs);
            fail("Should not be able to create a type token instance with multiple type arguments.");
        } catch (IllegalArgumentException e) { /* expected */ }
    }

    public void testWithGenericTypeArgs() {
        try {
            new DefaultTypeTokenInstance(genericArgs);
            fail("Should not be able to create a type token instance with genric type arguments.");
        } catch (IllegalArgumentException e) { /* expected */ }
    }

    private ParameterizedType extractTypeFromSuperClass(Class<?> c) {
        return (ParameterizedType) c.getGenericSuperclass();
    }

    private ParameterizedType extractTypeFromSuperInterface(Class<?> c) {
        return (ParameterizedType) c.getGenericInterfaces()[0];
    }

}
