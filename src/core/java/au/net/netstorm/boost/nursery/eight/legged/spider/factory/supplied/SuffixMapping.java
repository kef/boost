package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class SuffixMapping implements Mapping {
    private final String suffix;

    public SuffixMapping(String suffix) {
        this.suffix = suffix;
    }

    public boolean can(InjectionType type) {
        return true;
    }

    public String map(InjectionType type) {
        Class cls = type.rawClass();
        return cls.getName() + suffix;
    }
}
