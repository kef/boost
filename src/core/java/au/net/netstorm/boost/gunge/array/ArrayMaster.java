package au.net.netstorm.boost.gunge.array;

import java.util.Collection;

public interface ArrayMaster {
    <T> T[] minus(T[] minuend, T... subtrahend);

    <T> T[] plus(T[] array1, T... array2);

    // FIX DEBT Move to a primitive helper area.
    byte[] plus(byte[] array1, byte[] array2);

    boolean contains(Object[] array, Object o);

    boolean hasDuplicates(Object[] array);

    <T> T[] removeDuplicates(T[] array);

    boolean intersects(Object[] o1, Object[] o2);

    <T> T[] toArray(Collection<T> collection, Class<T> componentType);

    Object[] toArray(Collection collection);
}
