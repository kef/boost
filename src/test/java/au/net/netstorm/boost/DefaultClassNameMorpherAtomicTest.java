package au.net.netstorm.boost;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import junit.framework.TestCase;

public final class DefaultClassNameMorpherAtomicTest extends TestCase {
    private ClassNameMorpher morpher = new DefaultClassNameMorpher();

    // FIX 1665 Triangulate.
    // FIX 1665 Handle prefix not in class.
    // FIX 1665 Handle result class not existing.
    public void testStripPrefix() {
        checkStripPrefix(Map.class, "Tree", TreeMap.class);
        checkStripPrefix(Set.class, "Hash", HashSet.class);
    }

    public void testPrefixNotInClass() {
        try {
            morpher.stripPrefix("Bollackery", HashSet.class);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void checkStripPrefix(Class expected, String prefix, Class cls) {
        Class result = morpher.stripPrefix(prefix, cls);
        assertEquals(expected, result);
    }
}
