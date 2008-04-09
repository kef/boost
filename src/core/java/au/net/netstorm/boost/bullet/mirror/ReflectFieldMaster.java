package au.net.netstorm.boost.bullet.mirror;

import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;

public interface ReflectFieldMaster {
    FieldValueSpec[] getInstanceFields(Object ref);
}
