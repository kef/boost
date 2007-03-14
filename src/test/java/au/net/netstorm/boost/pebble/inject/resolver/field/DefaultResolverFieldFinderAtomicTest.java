package au.net.netstorm.boost.pebble.inject.resolver.field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultResolverFieldFinderAtomicTest extends BoooostTestCase {
    private ResolverFieldFinder subject = new DefaultResolverFieldFinder();
    private Pebble pebble = new Legend();
    private final EdgeClass classer = new DefaultEdgeClass();

    // FIX 1715 Complete this test.
    // FIX 1715 Ensure we get only two fields from the field finder.
    // FIX 1715 Check the others did not get modified.
    public void testFind() {
        Field[] fields = subject.find(pebble);
        Field[] expected = buildExpected();
        int length = fields.length;
        assertEquals(2, length);
    }

    private Field[] buildExpected() {
        List result = new ArrayList();
        add(result, "resolveMe");
        add(result, "resolveMeToo");
        return (Field[]) result.toArray(new Field[]{});
    }

    private void add(List result, String fieldName) {
        Class cls = pebble.getClass();
        Field field = classer.getDeclaredField(cls, fieldName);
        result.add(field);
    }
}
