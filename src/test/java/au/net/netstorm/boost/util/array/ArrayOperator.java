package au.net.netstorm.boost.util.array;

public interface ArrayOperator {
    Object[] minus(Object[] minuend, Object[] subtrahend);

    // FIX DEBT Move to a primitive helper area.
    byte[] add(byte[] array1, byte[] array2);
}
