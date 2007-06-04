package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolvableFieldFinderAtomicTest extends BoooostCase {
    private final ResolvableFieldFinder subject = new DefaultResolvableFieldFinder();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Object legend = new Legend();

    public void testFind() {
        Field[] expected = buildExpected();
        Field[] result = subject.find(legend);
        assertEquals(expected, result);
    }

    private Field[] buildExpected() {
        List result = new ArrayList();
        add(result, "resolveMe");
        add(result, "resolveMeToo");
        return (Field[]) result.toArray(new Field[]{});
    }

    private void add(List result, String fieldName) {
        Class cls = legend.getClass();
        Field field = classer.getDeclaredField(cls, fieldName);
        result.add(field);
    }
}
