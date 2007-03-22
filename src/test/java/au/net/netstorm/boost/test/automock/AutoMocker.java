package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;

interface AutoMocker {
    Mock mock(Object proxy);

    void mock(BoostField[] fields);
}
