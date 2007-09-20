package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Implementation;

public interface ContextAware {
    // FIX BREADCRUMB 73022 Better name?
    void setContext(Implementation impl);
}
