package au.net.netstorm.boost.gunge.atom;

public interface PrimitiveBoxer {
    Class getBoxed(Class primitive);

    boolean isPrimitive(Class candidate);

    boolean isBoxed(Class candidate);
}
