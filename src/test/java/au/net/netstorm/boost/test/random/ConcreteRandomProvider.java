package au.net.netstorm.boost.test.random;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Random;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// OK JavaNCSS|CyclomaticComplexity|ReturnCount {
public final class ConcreteRandomProvider implements RandomProvider {
    private final Random random = new Random();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Class[] randomClasses = {LovelyInterface.class, Random.class, Serializable.class};

    public Object provide(Class type) {
        Object result = doGetRandom(type);
        if (result != null) return result;
        throw new UnsupportedOperationException("Hmm.  I cannot provide an instance of '" + type + "'.  " +
                "Might be worth edgifying (hiding behind an interface) this type or talking to the boosters!");
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
        return Integer.valueOf(i);
    }

    private Long randomLong() {
        long l = random.nextLong();
        return Long.valueOf(l);
    }

    private Character randomCharacter() {
        Byte b = randomByte();
        byte value = b.byteValue();
        return (char) value;
    }

    private Float randomFloat() {
        float f = random.nextFloat();
        return Float.valueOf(f);
    }

    private Double randomDouble() {
        double d = random.nextDouble();
        return Double.valueOf(d);
    }

    private Byte randomByte() {
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);
        return Byte.valueOf(bytes[0]);
    }

    private Class randomClass() {
        int i = Math.abs(randomInteger()) % 3;
        return randomClasses[i];
    }

    private Object randomObject() {
        return new Object();
    }

    private Method randomMethod() {
        return classer.getMethod(LovelyInterface.class, "gorgeous", new Class[]{});
    }
} // } OK JavaNCSS|CyclomaticComplexity|ReturnCount

