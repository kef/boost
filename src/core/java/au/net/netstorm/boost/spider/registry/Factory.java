package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Factory {
    Blueprint get(Interface iface, Implementation host);

    boolean canHandle(Interface iface);
}
