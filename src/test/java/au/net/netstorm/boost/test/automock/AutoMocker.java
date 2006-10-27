package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;

interface AutoMocker {
    void wireMocks();

    Mock getMock(Object proxy);
}
