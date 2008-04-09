package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;

interface PropertyNameProvider {
    String getPropertyMethodName(FieldSpec field);
}
