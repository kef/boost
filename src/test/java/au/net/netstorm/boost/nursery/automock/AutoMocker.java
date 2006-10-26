package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;

interface AutoMocker {
    void wireMocks();

    Mock getMock(Object proxy);
}
