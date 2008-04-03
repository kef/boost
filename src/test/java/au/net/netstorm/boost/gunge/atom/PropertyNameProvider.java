package au.net.netstorm.boost.gunge.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface PropertyNameProvider {
    String getPropertyMethodName(FieldSpec field);
}
