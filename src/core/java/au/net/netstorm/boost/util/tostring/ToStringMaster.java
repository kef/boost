package au.net.netstorm.boost.util.tostring;

// FIX SC506 Consistent approach to static fields.
// FIX SC506 ? reflect.core reflect.type.
// FIX SC509 Sort out reflect/introspect schism.
// FIX SC506 Comb and replace string literals.
// FIX SC506 Have a good hard look at and remove the "fixtures" package.  This stuff is smelly cheese.
// FIX SC509 Primordial extenders need to be final.  Put this check into primordial.
// FIX SC509 Throw exception from clone().
// FIX SC506 Minimal braces everywhere.
public interface ToStringMaster {
    String getString(Object ref);
}
