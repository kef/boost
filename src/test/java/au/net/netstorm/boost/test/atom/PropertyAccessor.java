package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

interface PropertyAccessor {
    Object invoke(Object instance, FieldSpec field);
}
