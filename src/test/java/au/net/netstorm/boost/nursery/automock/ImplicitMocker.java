package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;

interface ImplicitMocker {
    void wireMocks();

    Mock getMock(Object proxy);
}
