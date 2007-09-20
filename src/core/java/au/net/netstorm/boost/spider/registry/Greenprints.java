package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.Interface;

public interface Greenprints {
    Blueprint get(Interface iface);

    boolean exists(Interface iface);
}
