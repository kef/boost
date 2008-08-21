package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class PrefixMapping implements Mapping {
    private final String prefix;

    public PrefixMapping(String prefix) {
        this.prefix = prefix;
    }

    public String map(InjectionType type) {
        Class cls = type.rawClass();
        Package pkg = cls.getPackage();
        String namespace = pkg.getName();
        String name = cls.getSimpleName();
        return namespace + "." + prefix + name;
    }

    public boolean can(InjectionType type) {
        return true;
    }
}