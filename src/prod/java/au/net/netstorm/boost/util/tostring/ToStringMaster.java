package au.net.netstorm.boost.util.tostring;

// FIXME: SC501 Move everything to util except primordial, start, time.
// FIXME: SC501 Consistent approach to static fields.
// FIXME: SC501 ? reflect.core reflect.type.
// FIXME: SC501 Move all test code into test hierarchy.
// FIXME: SC501 Quantum vs Class as name for tests.
// FIXME: SC501 Create primordial subpackage.
// FIXME: SC501 Rename all UnitTests to ClassTest.
// FIXME: SC501 Leave no fixmes.
// FIXME: SC501 Interject or provide PrimordialTestCase.
// FIXME: SC501 Sort out reflect/introspect schism.
// FIXME: SC501 Check all fail<TestName> methods and convert.
// FIXME: SC501 Ensure all tests sit in the test hierarchy.
// FIXME: SC501 Remove all vlad references.
// FIXME: SC501 Comb and replace string literals.
// FIXME: SC501 Test drive all exceptions.
// FIXME: SC501 Create NotImplementedException.
// FIXME: SC501 Have a good hard look at and remove the "fixtures" package.  This stuff is smelly cheese.
// FIXME: SC501 Remove all SC501 references.
// FIXME: SC501 Primordial extenders need to be final.  Put this check into primordial.
// FIXME: SC501 Throw exception from clone().
// FIXME: SC501 Minimal braces everywhere.
public interface ToStringMaster {
    String getString(Object ref);
}
