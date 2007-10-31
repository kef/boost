package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.BlueprintsRead;
import au.net.netstorm.boost.spider.registry.DefaultBlueprint;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class ImplicitBlueprintsRead implements BlueprintsRead {
    private static final Stamp SINGLE = Stamp.SINGLE;
    private final ImplMaster impler;

    public ImplicitBlueprintsRead(ImplMaster impler) {
        this.impler = impler;
    }

    public Blueprint get(Interface iface) {
        Implementation impl = impler.impl(iface);
        return blueprint(impl);
    }

    public boolean exists(Interface iface) {
        return impler.hasImpl(iface);
    }

    private Blueprint blueprint(Implementation impl) {
        return new DefaultBlueprint(SINGLE, impl);
    }
}