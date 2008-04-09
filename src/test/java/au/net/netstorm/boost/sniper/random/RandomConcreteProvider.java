package au.net.netstorm.boost.sniper.random;

public interface RandomConcreteProvider {
    Object getRandom(Class type);

    boolean canProvide(Class type);
}
