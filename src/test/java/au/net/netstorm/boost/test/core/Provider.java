package au.net.netstorm.boost.test.core;

// FIX 2076 This similar to Spiders Provider.

// FIX 2076 Also split the canProvide out into separate interface.
public interface Provider {
    Object provide(Class type);

    boolean canProvide(Class type);
}
