package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultWorker implements Worker {
    Nu nu;

    public Work work() {
        Host host = nu.nu(Host.class, "doggdot.us");
        Port port = nu.nu(Port.class, 8081);
        return nu.nu(Work.class, host, port);
    }
}
