package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultClassToNuBuilder implements ClassToNuBuilder {
    private static final Object IGNORED = new Object();
    private final EdgeClass edgeClass = new DefaultEdgeClass();
    private final EdgeField edgeField = new DefaultEdgeField();

    public Implementation build(Class newerType) {
        Field classToNuField = edgeClass.getDeclaredField(newerType, "CLASS_TO_NU");
        classToNuField.setAccessible(true);
        Class classToNu = (Class) edgeField.get(classToNuField, IGNORED);
        return new DefaultImplementation(classToNu);
    }
}
