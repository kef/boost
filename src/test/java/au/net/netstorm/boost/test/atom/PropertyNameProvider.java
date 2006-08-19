package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface PropertyNameProvider {
    // FIX SC600 Move the property name determination into a separate class.
// FIX SC600 This was we can do get/is, and also the possibility of optional fields.
    String getPropertyMethodName(FieldSpec field);
}
