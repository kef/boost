package au.net.netstorm.boost.test.atom;

public interface RandomPrimitiveProvider {
    Object getRandom(Class type);

    boolean canProvide(Class type);
}
