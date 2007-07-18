package au.net.netstorm.boost.test.random;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.SpecificProvider;

// OK JavaNCSS|CyclomaticComplexity|ReturnCount {
public final class ConcreteRandomProvider implements SpecificProvider {
    private final Random random = new Random();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Class[] randomClasses = {ArrayList.class, List.class, Random.class, Serializable.class};

    public Object provide(Class type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        return doGetRandom(type);
    }

    public boolean canProvide(Class type) {
        return doGetRandom(type) != null;
    }

    private Object doGetRandom(Class type) {
        if (type == Boolean.class) return randomBoolean();
        if (type == Integer.class) return randomInteger();
        if (type == Long.class) return randomLong();
        if (type == Double.class) return randomDouble();
        if (type == Float.class) return randomFloat();
        if (type == Byte.class) return randomByte();
        if (type == String.class) return randomString();
        if (type == Class.class) return randomClass();
        if (type == Object.class) return randomObject();
        if (type == Method.class) return randomMethod();
        if (type == Character.class) return randomCharacter();
        if (type == Throwable.class) return randomThrowable();
        if (type == Date.class) return randomDate();
        return null;
    }

    private Date randomDate() {
        return new Date(Math.abs(randomLong().longValue()));
    }

    private String randomString() {
        return "Some random string " + randomLong();
    }

    private Boolean randomBoolean() {
        boolean bool = random.nextBoolean();
        return Boolean.valueOf(bool);
    }

    private Integer randomInteger() {
        int i = random.nextInt();
        return new Integer(i);
    }

    private Long randomLong() {
        long l = random.nextLong();
        return new Long(l);
    }

    private Character randomCharacter() {
        Byte b = randomByte();
        char value = (char) b.byteValue();
        return new Character(value);
    }

    private Float randomFloat() {
        float f = random.nextFloat();
        return new Float(f);
    }

    private Double randomDouble() {
        double d = random.nextDouble();
        return new Double(d);
    }

    private Byte randomByte() {
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);
        return new Byte(bytes[0]);
    }

    private Class randomClass() {
        int i = Math.abs(randomInteger().intValue()) % randomClasses.length;
        return randomClasses[i];
    }

    private Object randomObject() {
        return new Object();
    }

    private Method randomMethod() {
        return classer.getMethod(LovelyInterface.class, "gorgeous", new Class[]{});
    }

    private Throwable randomThrowable() {
        String message = randomString();
        return new Throwable(message);
    }
} // } OK JavaNCSS|CyclomaticComplexity|ReturnCount

