package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;

public interface AutoRandomizer {
    void randomizePrimitivesAndStrings(Field[] fields);
}
