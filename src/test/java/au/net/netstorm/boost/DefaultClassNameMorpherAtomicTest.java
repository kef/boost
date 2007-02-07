package au.net.netstorm.boost;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

public final class DefaultClassNameMorpherAtomicTest extends TestCase {
    private ClassNameMorpher morpher = new DefaultClassNameMorpher();

    // FIX 1665 Triangulate.
    // FIX 1665 Handle prefix not in class.
    // FIX 1665 Handle result class not existing.
    public void testStripPrefix() {
        checkStripPrefix(Map.class, "Hash", HashMap.class);
    }

    private void checkStripPrefix(Class expected, String prefix, Class cls) {
        Class result = morpher.stripPrefix(prefix, cls);
        assertEquals(expected, result);
    }
}
