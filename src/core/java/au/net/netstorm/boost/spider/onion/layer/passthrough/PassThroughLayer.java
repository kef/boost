package au.net.netstorm.boost.spider.onion.layer.passthrough;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface PassThroughLayer extends Layer {
    void setDelegate(Object delegate);
}
