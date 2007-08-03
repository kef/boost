package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class DefaultPropertyNameProvider implements PropertyNameProvider {
    private final Captialiser captialiser = new DefaultCaptialiser();

    public String getPropertyMethodName(FieldSpec field) {
        String beanName = field.getName();
        Class beanType = field.getType();
        String capitalised = captialiser.captialise(beanName);
        return prefix(beanType) + capitalised;
    }

    private String prefix(Class beanType) {
        return isBoolean(beanType) ? "is" : "get";
    }

    private boolean isBoolean(Class beanType) {
        if (beanType.equals(boolean.class)) return true;
        return beanType.equals(Boolean.class);
    }
}
