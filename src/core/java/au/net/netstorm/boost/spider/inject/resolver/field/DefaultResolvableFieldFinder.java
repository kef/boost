package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public final class DefaultResolvableFieldFinder implements ResolvableFieldFinder {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final ResolvableFieldMaster resolvable = new DefaultResolvableFieldMaster();

    public Field[] find(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        List result = find(ref, fields);
        return (Field[]) result.toArray(new Field[result.size()]);
    }

    private List find(Object ref, Field[] fields) {
        List result = new ArrayList();
        for (Field field : fields) optionallyAdd(result, ref, field);
        return result;
    }

    private void optionallyAdd(List result, Object ref, Field field) {
        if (!resolvable.isResolvableField(ref, field)) return;
        result.add(field);
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return classer.getDeclaredFields(cls);
    }
}
