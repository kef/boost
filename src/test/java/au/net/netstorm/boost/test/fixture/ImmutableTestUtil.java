package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface ImmutableTestUtil {
    // FIXME: SC050 Who should know about InstanceProvision (InstanceProviderForTest), the upper levels, or lower?
    void checkIsImmutable(Class cls, FieldSpec[] fields);
}
