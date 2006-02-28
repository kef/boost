package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface DataTestUtil {
    // FIXME: SC050 ? Rename to checkIsData.
    void checkIsData(Class cls, FieldSpec[] fields);

    void checkIsData(Class cls, FieldSpec[] fields, InstanceProvider additional);
}
