package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class BlueprintedFactory implements Factory {
    private final BlueprintsRead blueprintsRead;

    public BlueprintedFactory(BlueprintsRead blueprintsRead) {
        this.blueprintsRead = blueprintsRead;
    }

    public Blueprint get(Implementation host, Interface iface) {
        return blueprintsRead.get(host, iface);
    }

    public boolean canHandle(Interface iface) {
        return blueprintsRead.exists(iface);
    }
}
