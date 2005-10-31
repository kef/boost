package au.net.netstorm.boost.util.tostring;

// FIXME: SC507 Move everything to util except primordial, start, time.
// FIXME: SC506 Consistent approach to static fields.
// FIXME: SC506 ? reflect.core reflect.type.
// FIXME: SC509 Interject or provide PrimordialTestCase.
// FIXME: SC509 Sort out reflect/introspect schism.
// FIXME: SC506 Check all fail<TestName> methods and convert.
// FIXME: SC506 Comb and replace string literals.
// FIXME: SC510 Create NotImplementedException.
// FIXME: SC506 Have a good hard look at and remove the "fixtures" package.  This stuff is smelly cheese.
// FIXME: SC509 Primordial extenders need to be final.  Put this check into primordial.
// FIXME: SC509 Throw exception from clone().
// FIXME: SC506 Minimal braces everywhere.
public interface ToStringMaster {
    String getString(Object ref);
}
