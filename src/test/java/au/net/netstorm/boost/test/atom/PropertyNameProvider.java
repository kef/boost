package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface PropertyNameProvider {
    String getPropertyMethodName(FieldSpec field);
}
