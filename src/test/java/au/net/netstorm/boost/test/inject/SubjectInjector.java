package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.test.field.FieldSuffix;
import au.net.netstorm.boost.test.field.MockFieldSuffix;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

import java.lang.reflect.Field;
import java.util.List;

public final class SubjectInjector implements Injector {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ResolvableFieldFinder resolvableFieldFinder = new DefaultResolvableFieldFinder();
    private final FieldNameFinder fieldNameFinder = new DefaultFieldNameFinder();
    private final FieldSuffix mockSuffix = new MockFieldSuffix();

    public void inject(Object testCase) {
        Object subject = nullGetSubject(testCase);
        if (subject != null) {
            Field[] subjectFields = resolvableFieldFinder.find(subject);
            List testFields = fieldNameFinder.find(testCase);
            inject(testCase, testFields, subject, subjectFields);
        }
    }

    private void inject(Object testCase, List testFields, Object subject, Field[] subjectFields) {
        for (int i = 0; i < subjectFields.length; i++) {
            injectField(testFields, subjectFields[i], testCase, subject);
        }
    }

    private void injectField(List testFields, Field subjectField, Object testCase, Object subject) {
        if (isMatchingField(subjectField, testFields)) {
            String testFieldName = getTestFieldName(subjectField, testFields);
            Object value = fielder.getInstance(testCase, testFieldName);
            String subjectFieldName = getFieldName(subjectField);
            fielder.setInstance(subject, subjectFieldName, value);
        }
    }

    private String getTestFieldName(Field field, List testFields) {
        String name = getFieldName(field);
        if (testFields.contains(name)) return name;
        return getMockFieldName(field);
    }

    private String getMockFieldName(Field field) {
        return mockSuffix.addSuffix(field);
    }

    private boolean isMatchingField(Field field, List testFields) {
        String fieldName = getFieldName(field);
        if (testFields.contains(fieldName)) return true;
        String mockName = getMockFieldName(field);
        return testFields.contains(mockName);
    }

    private String getFieldName(Field field) {
        return field.getName();
    }

    // FIX DEBT Stinky.  Need a getField or fieldExists().
    private Object nullGetSubject(Object testCase) {
        try {
            return fielder.getInstance(testCase, "subject");
        } catch (EdgeException e) {
            return null;
        }
    }
}
