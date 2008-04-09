package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.gunge.type.UnresolvedInstance;

public interface InjectorEngine {
    void inject(UnresolvedInstance unresolved);
}
