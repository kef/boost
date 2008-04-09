package au.net.netstorm.boost.sniper.atom;

public interface PrimitiveBoxer {
    Class getBoxed(Class primitive);

    boolean isPrimitive(Class candidate);

    boolean isBoxed(Class candidate);
}
