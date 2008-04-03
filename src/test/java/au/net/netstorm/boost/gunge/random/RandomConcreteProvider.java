package au.net.netstorm.boost.gunge.random;

public interface RandomConcreteProvider {
    Object getRandom(Class type);

    boolean canProvide(Class type);
}
