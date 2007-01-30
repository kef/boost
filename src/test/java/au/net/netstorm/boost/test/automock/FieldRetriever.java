package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;

public interface FieldRetriever {
    Field[] retrieve(Object ref);
}
