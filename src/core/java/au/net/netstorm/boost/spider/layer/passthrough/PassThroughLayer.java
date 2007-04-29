package au.net.netstorm.boost.spider.layer.passthrough;

import au.net.netstorm.boost.spider.layer.core.OldLayer;

public interface PassThroughLayer extends OldLayer {
    void setDelegate(Object delegate);
}
