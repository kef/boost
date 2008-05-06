package au.net.netstorm.boost.bullet.mirror;

import au.net.netstorm.boost.gunge.provider.Provider;

public interface InstantiatorWithProvider {
    <T> T createInstance(Class<T> implClass, Provider provider);
}
