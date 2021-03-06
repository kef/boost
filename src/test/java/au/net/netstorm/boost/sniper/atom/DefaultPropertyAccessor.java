package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sniper.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.MethodTestUtil;

final class DefaultPropertyAccessor implements PropertyAccessor {
    private static final Object[] NO_ARGUMENTS = null;
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();
    private MethodTestUtil methodUtil = new DefaultMethodTestUtil();

    public Object invoke(Object instance, FieldSpec field) {
        String methodName = nameProvider.getPropertyMethodName(field);
        return methodUtil.invoke(instance, methodName, NO_ARGUMENTS);
    }
}
