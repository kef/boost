package au.net.netstorm.boost.spider.onion.layer.passthrough;

import au.net.netstorm.boost.spider.onion.core.OldLayer;

public interface OldPassThroughLayer extends OldLayer {
    void setDelegate(Object delegate);
}
