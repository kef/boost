package au.net.netstorm.boost.test.field;

public interface BoostField {
    Object get();

    void set(Object value);

    String getName();

    Class getType();

    boolean isNull();

    boolean isFinal();

    boolean isStatic();

    boolean isArray();

    boolean isPrimitive();

    boolean isInterface();
}
