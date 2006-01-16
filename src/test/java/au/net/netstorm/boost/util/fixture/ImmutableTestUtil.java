package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.type.Immutable;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIXME: SC509  Finish this.  Suggestion: check copy on construction, creating a valid object (valid parameters in
// constructor (add it to FieldTypeSpec?), final member variables, serializable, etc).  Just use checking methods
// and members (see MemberTestFixture.checkFieldImmutable).  With immutable objects there may not be a correlation
// between constructor, member name and method names such as getters.  DefaultFieldValueSpec is a problem too.

public class ImmutableTestUtil {
    public static void checkIsImmutableObject(Class cls, FieldSpec[] fields) {
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        fixture.checkClass(Immutable.class);
    }
}
