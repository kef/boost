package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultSocker implements Socker {
    Nu nu;

    public Sock sock() {
        Host host = nu.nu(Host.class, "doggdot.us");
        Port port = nu.nu(Port.class, 8081);
        return nu.nu(Sock.class, host, port);
    }
}
