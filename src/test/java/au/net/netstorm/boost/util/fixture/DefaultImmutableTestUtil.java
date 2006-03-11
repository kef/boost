package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.type.Immutable;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIXME: SC509  Finish this.  Suggestion: check copy on construction, creating a valid object (valid parameters in
// constructor (add it to FieldTypeSpec?), final member variables, serializable, etc).  Just use checking methods
// and members (see MemberTestFixture.checkFieldImmutable).  With immutable objects there may not be a correlation
// between constructor, member name and method names such as getters.  DefaultFieldValueSpec is a problem too.

// FIXME: SC050 INSTANCISE.
public final class DefaultImmutableTestUtil implements ImmutableTestUtil {

    // FIXME: SC050 Who should know about InstanceProvision (InstanceProvider), the upper levels, or lower?
    public void checkIsImmutable(Class cls, FieldSpec[] fields) {
        TestEmptyInstanceProvider empty = new TestEmptyInstanceProvider(); // FIXME: SC050 The fact that this is here is a BIG indicator of the smelliness of this code.
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        fixture.checkClass(Immutable.class, empty);
    }
}
