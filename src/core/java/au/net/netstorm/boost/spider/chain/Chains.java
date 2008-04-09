package au.net.netstorm.boost.spider.chain;

import au.net.netstorm.boost.gunge.type.Interface;

public interface Chains {
    boolean exists(Interface iface);

    Chain get(Interface iface);

    Chain[] all();
}
