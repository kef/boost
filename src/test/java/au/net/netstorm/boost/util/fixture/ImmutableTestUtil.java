/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface ImmutableTestUtil {
    // FIXME: SC050 Who should know about InstanceProvision (InstanceProvider), the upper levels, or lower?
    void checkIsImmutable(Class cls, FieldSpec[] fields);
}
