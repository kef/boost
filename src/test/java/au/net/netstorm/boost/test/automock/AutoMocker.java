package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import org.jmock.Mock;

interface AutoMocker {
    Mock getMock(Object proxy);

    void wireMocks(Field[] fields);
}
