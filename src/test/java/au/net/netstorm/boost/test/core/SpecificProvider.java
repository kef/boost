package au.net.netstorm.boost.test.core;

public interface SpecificProvider extends Provider {
    boolean canProvide(Class type);
}
