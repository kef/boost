package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerFieldBuilder implements NewerFieldBuilder {
    private static final Object IGNORED = new Object();
    private final EdgeClass edgeClass = new DefaultEdgeClass();
    private final EdgeField edgeField = new DefaultEdgeField();

    public NewerField build(Field field) {
        Class newerType = field.getType();
        Interface newerInterface = new DefaultInterface(newerType);
        Implementation classToNu = getClasstoNu(newerType);
        String fieldName = field.getName();
        return new DefaultNewerField(newerInterface, classToNu, fieldName);
    }

    private Implementation getClasstoNu(Class newerType) {
        Field classToNuField = edgeClass.getDeclaredField(newerType, "CLASS_TO_NU");
        classToNuField.setAccessible(true);
        Class classToNu = (Class) edgeField.get(classToNuField, IGNORED);
        return new DefaultImplementation(classToNu);
    }
}
