package au.net.netstorm.boost.spider.layer.passthrough;

import au.net.netstorm.boost.spider.layer.core.Layer;

public interface PassThroughLayer extends Layer {
    void setDelegate(Object delegate);
}
