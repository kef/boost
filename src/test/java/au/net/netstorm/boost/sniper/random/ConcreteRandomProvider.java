package au.net.netstorm.boost.sniper.random;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
import au.net.netstorm.boost.gunge.provider.NotProvidedException;
import au.net.netstorm.boost.gunge.provider.SpecificProvider;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

// FIX DEBT SPLIT THIS CLASS!!!

// OK JavaNCSS|CyclomaticComplexity|ReturnCount {
public final class ConcreteRandomProvider implements SpecificProvider {
    private final Random random = new Random();
    private final EdgeClass classer = new DefaultEdgeClass();
    // FIX 1914 Use actual test fixtures here.  Not well known classes.
    private final Class[] randomClasses = {Bandaid.class, Lollipop.class, Scrunch.class};

    public <T> T provide(Class<T> type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        Object result = doGetRandom(type);
        return type.cast(result);
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
        if (type == BigDecimal.class) return randomBigDecimal();
        if (type == Throwable.class) return randomThrowable();
        if (type == RuntimeException.class) return randomRuntimeException();
        if (type == Date.class) return randomDate();
        return null;
    }

    private String randomString() {
        return "Some random string " + randomLong();
    }

    private Boolean randomBoolean() {
        return random.nextBoolean();
    }

    private Integer randomInteger() {
        return random.nextInt();
    }

    private Long randomLong() {
        return random.nextLong();
    }

    private Character randomCharacter() {
        Byte b = randomByte();
        return (char) b.byteValue();
    }

    private Float randomFloat() {
        return random.nextFloat();
    }

    private Double randomDouble() {
        return random.nextDouble();
    }

    private Byte randomByte() {
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);
        return bytes[0];
    }

    private BigInteger randomBigInteger() {
        long l = random.nextLong();
        return BigInteger.valueOf(l);
    }

    private BigDecimal randomBigDecimal() {
        long l = random.nextLong();
        return BigDecimal.valueOf(l);
    }

    private Class randomClass() {
        int integer = randomInteger();
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
        long longone = randomLong();
        long abs = Math.abs(longone);
        return new Date(abs);
    }
} // } OK JavaNCSS|CyclomaticComplexity|ReturnCount

