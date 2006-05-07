package au.net.netstorm.boost.java.lang.reflect;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public interface ReflectFieldMaster {
    FieldValueSpec[] getInstanceFields(Object ref);
}
