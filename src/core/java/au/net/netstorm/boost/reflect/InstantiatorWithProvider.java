package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.provider.Provider;

public interface InstantiatorWithProvider {
    <T> T createInstance(Class<T> implClass, Provider provider);
}
