package au.net.netstorm.boost.test.atom;

public interface RandomConcreteProvider {
    Object getRandom(Class type);

    boolean canProvide(Class type);
}
