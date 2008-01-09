package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultInjector implements Injector {
    private final InjectorEngine engine;

    public DefaultInjector(InjectorEngine engine) {
        this.engine = engine;
    }

    public void inject(Object ref) {
        UnresolvedInstance unresolved = new DefaultBaseReference(ref);
        engine.inject(unresolved);
    }
}
