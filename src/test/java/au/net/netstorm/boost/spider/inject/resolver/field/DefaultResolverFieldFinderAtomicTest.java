package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.core.GoodCitizen;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultResolverFieldFinderAtomicTest extends BoooostCase {
    private final ResolverFieldFinder subject = new DefaultResolverFieldFinder();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final GoodCitizen goodCitizen = new Legend();

    public void testFind() {
        Field[] expected = buildExpected();
        Field[] result = subject.find(goodCitizen);
        assertEquals(expected, result);
    }

    private Field[] buildExpected() {
        List result = new ArrayList();
        add(result, "resolveMe");
        add(result, "resolveMeToo");
        return (Field[]) result.toArray(new Field[]{});
    }

    private void add(List result, String fieldName) {
        Class cls = goodCitizen.getClass();
        Field field = classer.getDeclaredField(cls, fieldName);
        result.add(field);
    }
}
