package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.SpecificProvider;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

// FIX DEBT SPLIT THIS CLASS!!!

// OK JavaNCSS|CyclomaticComplexity|ReturnCount {
public final class ConcreteRandomProvider implements SpecificProvider {
    private final Random random = new Random();
    private final EdgeClass classer = new DefaultEdgeClass();
    // FIX 1914 Use actual test fixtures here.  Not well known classes.
    private final Class[] randomClasses = {Bandaid.class, Lollipop.class, Scrunch.class};

    public <T> T provide(Class<T> type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        return (T) doGetRandom(type);
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
        if (type == BigInteger.class) return randomBigInteger();
        if (type == Throwable.class) return randomThrowable();
        if (type == RuntimeException.class) return randomRuntimeException();
        if (type == Date.class) return randomDate();
        return null;
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

    private BigInteger randomBigInteger() {
        long l = random.nextLong();
        return BigInteger.valueOf(l);
    }

    private Class randomClass() {
        int integer = randomInteger().intValue();
        int i = Math.abs(integer) % randomClasses.length;
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

    private RuntimeException randomRuntimeException() {
        String message = randomString();
        return new RuntimeException(message);
    }

    private Date randomDate() {
        long longone = randomLong().longValue();
        long abs = Math.abs(longone);
        return new Date(abs);
    }
} // } OK JavaNCSS|CyclomaticComplexity|ReturnCount

