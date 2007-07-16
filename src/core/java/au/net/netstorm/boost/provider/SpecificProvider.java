package au.net.netstorm.boost.provider;

public interface SpecificProvider extends Provider {
    boolean canProvide(Class type);
}
