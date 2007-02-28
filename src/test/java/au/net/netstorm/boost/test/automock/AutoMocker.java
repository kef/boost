package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;

interface AutoMocker {
    Mock getMock(Object proxy);

    void wireMocks(BoostField[] fields);
}
