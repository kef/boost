package au.net.netstorm.boost.util.array;

public interface ArrayMaster {
    Object[] minus(Object[] minuend, Object[] subtrahend);

    Object[] plus(Object[] array1, Object[] array2);

    // FIX DEBT Move to a primitive helper area.
    byte[] plus(byte[] array1, byte[] array2);

    boolean contains(Object[] array, Object o);

    boolean hasDuplicates(Object[] array);
}
