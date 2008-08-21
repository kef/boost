package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX 2394 Clean up mapping stuff. This is to handle old style implMaster stuff.
// FIX 2394 But needs to be a more consisent mechanism.
public final class ImplMasterMapping implements Mapping {
    private final ImplMaster delegate;

    public ImplMasterMapping(ImplMaster delegate) {
        this.delegate = delegate;
    }

    public boolean can(InjectionType type) {
        if (!type.isInterface()) return false;
        Class<?> cls = type.rawClass();
        Interface iface = new DefaultInterface(cls);
        return delegate.hasImpl(iface);
    }

    public String map(InjectionType type) {
        Class cls = type.rawClass();
        Class mapped = delegate.impl(cls);
        return mapped.getName();
    }
}
