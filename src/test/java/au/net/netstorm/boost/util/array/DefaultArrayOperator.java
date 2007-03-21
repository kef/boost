package au.net.netstorm.boost.util.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultArrayOperator implements ArrayOperator {
    public Object[] minus(Object[] superSetArray, Object[] subSetArray) {
        Set result = convertToSet(superSetArray);
        Set subSet = convertToSet(subSetArray);
        result.removeAll(subSet);
        Object[] type = determineElementType(superSetArray);
        return result.toArray(type);
    }

    public Set convertToSet(Object[] array) {
        List list = Arrays.asList(array);
        return new HashSet(list);
    }

    private Object[] determineElementType(Object[] array) {
        Class arrayClass = array.getClass();
        Class componentType = arrayClass.getComponentType();
        return (Object[]) Array.newInstance(componentType, 0);
    }
}
