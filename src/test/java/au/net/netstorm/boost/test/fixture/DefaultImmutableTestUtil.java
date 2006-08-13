package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Immutable;

// FIX SC509  Finish this.  Suggestion: check copy on construction, creating a valid object (valid parameters in
// constructor (add it to FieldTypeSpec?), final member variables, serializable, etc).  Just use checking methods
// and members (see MemberTestFixture.checkFieldImmutable).  With immutable objects there may not be a correlation
// between constructor, member name and method names such as getters.  DefaultFieldValueSpec is a problem too.

public final class DefaultImmutableTestUtil implements ImmutableTestUtil {

    // FIX SC050 Who should know about InstanceProvision (InstanceProviderForTest), the upper levels, or lower?
    public void checkIsImmutable(Class cls, FieldSpec[] fields) {
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        fixture.checkClass(Immutable.class);
    }
}
