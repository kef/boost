package au.net.netstorm.boost.util.tostring;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

// FIX SC600 Consistent approach to static fields.
// FIX SC600 Sort out reflect/introspect schism.
// FIX SC600 Comb and replace string literals.
// FIX SC600 Have a good hard look at and remove the "fixtures" package.  This stuff is smelly cheese.
// FIX SC600 Primordial extenders need to be final.  Put this check into primordial.
// FIX SC600 Throw exception from clone() in primordial.
// FIX SC600 With the ability to interface Data/Immutables we should no longer need TEST_1, TEST_2 values.

// FIX SC600 Remove all old-style triangulation.
public interface ToStringMaster {
    String getString(Object ref);

    String formatFields(Object ref, FieldValueSpec[] fields);
}
