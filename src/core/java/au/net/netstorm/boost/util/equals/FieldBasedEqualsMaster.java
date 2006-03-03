package au.net.netstorm.boost.util.equals;

import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public final class FieldBasedEqualsMaster implements EqualsMaster {
    private final ReflectMaster master = new DefaultReflectMaster();

    public boolean equals(Object o1, Object o2) {
        if (bothNull(o1, o2)) return true;
        if (eitherNull(o1, o2)) return false;
        if (differentClasses(o1, o2)) return false;
        return determineEqualityFromFields(o1, o2);
    }

    private boolean eitherNull(Object o1, Object o2) {
        return o1 == null || o2 == null;
    }

    private boolean bothNull(Object o1, Object o2) {
        return o1 == null && o2 == null;
    }

    private boolean determineEqualityFromFields(Object o1, Object o2) {
        FieldValueSpec[] spec1 = master.getInstanceFields(o1);
        FieldValueSpec[] spec2 = master.getInstanceFields(o2);
        if (spec1.length == 0) throw new IllegalArgumentException("Illegal type for comparison " + o1.getClass());
        for (int i = 0; i < spec1.length; i++) {
            if (!spec1[i].equals(spec2[i])) return false;
        }
        return true;
    }

    private boolean differentClasses(Object o1, Object o2) {
        return o1.getClass() != o2.getClass();
    }
}
