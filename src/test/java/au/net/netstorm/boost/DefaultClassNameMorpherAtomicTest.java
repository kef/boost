package au.net.netstorm.boost;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import au.net.netstorm.boost.edge.EdgeException;
import junit.framework.TestCase;

public final class DefaultClassNameMorpherAtomicTest extends TestCase {
    private ClassNameMorpher morpher = new DefaultClassNameMorpher();

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

    public void testStrippedClassNonExistent() {
        try {
            morpher.stripPrefix("TreeM", TreeMap.class);
            fail();
        } catch (EdgeException expected) { }
    }

    private void checkStripPrefix(Class expected, String prefix, Class cls) {
        Class result = morpher.stripPrefix(prefix, cls);
        assertEquals(expected, result);
    }
}
