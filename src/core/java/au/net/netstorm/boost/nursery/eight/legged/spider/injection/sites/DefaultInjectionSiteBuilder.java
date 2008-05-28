package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public final class DefaultInjectionSiteBuilder implements InjectionSiteBuilder {
    public InjectionSite build(Field field) {
        throw new UnsupportedOperationException();
    }

    public InjectionSite[] build(Constructor constructor) {
        throw new UnsupportedOperationException();
    }
}
