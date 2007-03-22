package au.net.netstorm.boost.test.automock;

public interface BoostField {
    Object get();

    void set(Object value);

    boolean isNull();

    boolean isFinal();

    boolean isArray();

    boolean isPrimitive();

    boolean isInterface();

    boolean isMockable();

    String getName();

    Class getType();
}
