package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.gunge.impl.ImplMapper;
import au.net.netstorm.boost.gunge.impl.DefaultImplMapper;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.DefaultInterface;

public final class DefaultMapping implements Mapping {
    // FIX 2394 align these concepts
    private final ImplMapper delegate = new DefaultImplMapper("Default");

    public boolean can(InjectionType type) {
        // FIX 2394 smelly.
        if (!type.isInterface()) return false;
        Interface iface = iface(type);
        return delegate.can(iface);
    }

    public String map(InjectionType type) {
        Interface iface = iface(type);
        return delegate.map(iface);
    }

    private Interface iface(InjectionType type) {
        Class<?> cls = type.rawClass();
        return new DefaultInterface(cls);
    }
}
