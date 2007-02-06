package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;

// FIX 1665 Is this where we want this class?

// FIX 1665 Is this what we want to call this class? PrimitiveRandomizer?
public interface AutoRandomizer {
    void randomizePrimitivesAndStrings(Field[] fields);
}
