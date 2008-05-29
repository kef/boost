package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

public interface InterfaceMapping {
    Scope to(Object instance);
    MultiplicityOrScope to(Factory factory);
    MultiplicityOrScope to(Provider provider);
    MultiplicityOrScope to(Class<?> impl);
}
