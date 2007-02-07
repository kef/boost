package au.net.netstorm.boost;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

public final class DefaultClassNameMorpherAtomicTest extends TestCase {

    public void testStripPrefix() {
        ClassNameMorpher morpher = new DefaultClassNameMorpher();
        Class result = morpher.stripPrefix("Hash", HashMap.class);
        assertEquals(Map.class, result);
    }
}
