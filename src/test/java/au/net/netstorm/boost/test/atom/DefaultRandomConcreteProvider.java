package au.net.netstorm.boost.test.atom;

import java.util.Random;

// OK JavaNCSS|CyclomaticComplexity|ReturnCount {
public final class DefaultRandomConcreteProvider implements RandomConcreteProvider {
    private Random random = new Random();

    private interface InternalInterface {
    }

    public Object getRandom(Class type) {
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
        return null;
    }

    private Class randomClass() {
        return InternalInterface.class;
    }

    private String randomString() {
        return "Some random string " + random.nextLong();
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

    private Object randomObject() {
        return new Object();
    }
} // } OK JavaNCSS|CyclomaticComplexity|ReturnCount
