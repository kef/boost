package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Factory {
    Blueprint get(Implementation host, Interface iface);

    boolean canHandle(Interface iface);
}
