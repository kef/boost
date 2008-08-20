package au.net.netstorm.boost.nursery.gunge.equals;

import java.lang.reflect.Array;
import au.net.netstorm.boost.gunge.equals.EqualsMaster;

// FIX 2130 Out of the nursery ... quick smart.

public class ArrayEqualsMaster implements EqualsMaster {
    public boolean equals(Object o1, Object o2) {
        validate(o1, o2);
        return arraysEquals(o1, o2);
    }

    private boolean arraysEquals(Object array1, Object array2) {
        if (length(array1) != length(array2)) return false;
        for (int i = 0; i < length(array1); i++) {
            if (memberArraysUnequal(array1, array2, i)) return false;
        }
        return true;
    }

    private boolean memberArraysUnequal(Object array1, Object array2, int i) {
        Object o1 = Array.get(array1, i);
        Object o2 = Array.get(array2, i);
        return !o1.equals(o2);
    }

    private void validate(Object o1, Object o2) {
        checkIsArray(o1);
        checkIsArray(o2);
    }

    private void checkIsArray(Object o) {
        if (!isArray(o)) throw new IllegalArgumentException("Not an array: " + o);
    }

    private boolean isArray(Object o) {
        Class cls = o.getClass();
        return cls.isArray();
    }

    private int length(Object array) {
        return Array.getLength(array);
    }
}
