package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class DefaultPropertyNameProvider implements PropertyNameProvider {
    public String getPropertyMethodName(FieldSpec field) {
        String beanName = field.getName();
        Class beanType = field.getType();
        String upper = upperFirstLetter(beanName);
        String remainder = getRemainder(beanName);
        return prefix(beanType) + upper + remainder;
    }

    private String prefix(Class beanType) {
        return isBoolean(beanType) ? "is" : "get";
    }

    private String upperFirstLetter(String beanName) {
        String firstLetter = beanName.substring(0, 1);
        return firstLetter.toUpperCase();
    }

    private String getRemainder(String beanName) {
        int endIndex = beanName.length();
        return beanName.substring(1, endIndex);
    }

    private boolean isBoolean(Class beanType) {
        if (beanType.equals(boolean.class)) return true;
        return beanType.equals(Boolean.class);
    }
}
