package au.net.netstorm.boost.util.tostring;

// FIX SC507 Move everything to util except primordial, start, time.
// FIX SC506 Consistent approach to static fields.
// FIX SC506 ? reflect.core reflect.type.
// FIX SC509 Interject or provide PrimordialTestCase.
// FIX SC509 Sort out reflect/introspect schism.
// FIX SC506 Check all fail<TestName> methods and convert.
// FIX SC506 Comb and replace string literals.
// FIX SC510 Create NotImplementedException.
// FIX SC506 Have a good hard look at and remove the "fixtures" package.  This stuff is smelly cheese.
// FIX SC509 Primordial extenders need to be final.  Put this check into primordial.
// FIX SC509 Throw exception from clone().
// FIX SC506 Minimal braces everywhere.
public interface ToStringMaster {
    String getString(Object ref);
}
