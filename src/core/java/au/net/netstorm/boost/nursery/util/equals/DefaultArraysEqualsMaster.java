package au.net.netstorm.boost.nursery.util.equals;

import java.lang.reflect.Array;
import au.net.netstorm.boost.gunge.equals.ArraysEqualsMaster;

// FIX 2328 Belongs in nursery . gunge.equals
// FIX 2299 Up coverage and out of nursery.

// FIX SC509 TEST DRIVE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class DefaultArraysEqualsMaster implements ArraysEqualsMaster {
    public boolean equals(Object o1, Object o2) {
        validate(o1, o2);
        return arraysEquals(o1, o2);
    }

    private boolean arraysEquals(Object array1, Object array2) {
        if (Array.getLength(array1) != Array.getLength(array2)) return false;
        for (int i = 0; i < Array.getLength(array1); i++) {
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
}
