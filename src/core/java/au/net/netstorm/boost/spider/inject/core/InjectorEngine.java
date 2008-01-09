package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public interface InjectorEngine {
    void inject(UnresolvedInstance unresolved);
}
