package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultAspector implements Aspector {
    private final Aspects aspects;

    public DefaultAspector(Aspects aspects) {
        this.aspects = aspects;
    }

    public void cut(Class iface, Class<? extends Layer> aspect) {
        aspects.add(iface, aspect);
    }
}
