package au.net.netstorm.boost.test.field;

public interface BoostField {
    Object get();

    void set(Object value);

    boolean isNull();

    boolean isFinal();

    boolean isArray();

    boolean isPrimitive();

    boolean isInterface();

    String getName();

    Class getType();

    // FIX 1676 Out boy, out!
    boolean isInjectable();
}
