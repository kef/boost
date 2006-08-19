package au.net.netstorm.boost.test.atom;

interface PrimitiveBoxer {
    Class getBoxed(Class primitive);

    boolean isPrimitive(Class candidate);

    boolean isBoxed(Class candidate);
}
