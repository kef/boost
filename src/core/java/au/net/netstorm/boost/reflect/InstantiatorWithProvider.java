package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.provider.Provider;

public interface InstantiatorWithProvider {
    Object createInstance(Class implClass, Provider provider);
}
