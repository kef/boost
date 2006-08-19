package au.net.netstorm.boost.test.atom;

interface PrimitiveMapper {
    Class getWrapped(Class primitive);

    boolean isPrimitive(Class candidate);
}
