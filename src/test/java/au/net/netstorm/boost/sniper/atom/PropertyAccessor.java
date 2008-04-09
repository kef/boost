package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;

interface PropertyAccessor {
    Object invoke(Object instance, FieldSpec field);
}
