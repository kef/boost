package au.net.netstorm.boost.ioc;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public interface FieldResolver {
    void resolve(Object ref, FieldValueSpec fieldValueSpec);
}
