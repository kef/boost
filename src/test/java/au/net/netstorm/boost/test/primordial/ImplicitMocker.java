package au.net.netstorm.boost.test.primordial;

import org.jmock.Mock;

interface ImplicitMocker {
    void wireMocks();

    Mock getMock(Object proxy);
}
