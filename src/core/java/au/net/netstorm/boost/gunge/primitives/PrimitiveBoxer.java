package au.net.netstorm.boost.gunge.primitives;

public interface PrimitiveBoxer {
    Class convertToBoxed(Class candidate);

    Class getBoxed(Class primitive);

    boolean isPrimitive(Class candidate);

    boolean isBoxed(Class candidate);
}
