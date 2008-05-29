package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class MockFactory implements Factory {
    private final Class<?> expected;

    public MockFactory(Class<?> expected) {
        this.expected = expected;
    }

    public Provider nu(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(InjectionSite site) {
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        return 0;
    }
    public boolean equals(Object o) {
        Class<?> actual = o.getClass();
        return expected == actual;
    }
}
