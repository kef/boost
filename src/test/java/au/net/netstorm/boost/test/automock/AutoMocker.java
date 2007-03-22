package au.net.netstorm.boost.test.automock;

import org.jmock.Mock;

interface AutoMocker {
    Mock get(Object proxy);

    void mock(BoostField[] fields);
}
