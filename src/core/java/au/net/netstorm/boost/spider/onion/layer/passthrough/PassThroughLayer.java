package au.net.netstorm.boost.spider.onion.layer.passthrough;

import au.net.netstorm.boost.spider.onion.core.Closure;

public interface PassThroughLayer extends Closure {
    void setDelegate(Object delegate);
}
