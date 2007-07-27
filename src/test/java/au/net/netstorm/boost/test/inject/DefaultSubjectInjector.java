package au.net.netstorm.boost.test.inject;

import java.lang.reflect.Field;
import java.util.List;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolvableFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultSubjectInjector implements SubjectInjector {
    private final MockInjector injector = new DefaultMockInjector();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ResolvableFieldFinder resolvableFieldFinder = new DefaultResolvableFieldFinder();
    private final FieldNameFinder fieldNameFinder = new DefaultFieldNameFinder();

    public void inject(BoooostCase testCase) {
        Object subject = nullGetSubject(testCase);
        if (testContainsSubjectField(subject)) {
            Field[] subjectFields = resolvableFieldFinder.find(subject);
            List testFields = fieldNameFinder.find(testCase);
            inject(testCase, testFields, subject, subjectFields);
        }
    }

    private boolean testContainsSubjectField(Object subject) {
        return subject != null;
    }

    private void inject(BoooostCase testCase, List testFields, Object subject, Field[] subjectFields) {
        for (int i = 0; i < subjectFields.length; i++) {
            Field subjectField = subjectFields[i];
            String subjectFieldName = subjectField.getName();
            injectField(testFields, subjectFieldName, testCase, subject);
            // FIX 2076 Test me
            injectMockField(subjectFieldName, testFields, testCase, subject);
        }
    }

    private void injectField(List testFields, String subjectFieldName, BoooostCase testCase, Object subject) {
        if (testFields.contains(subjectFieldName)) injector.inject(testCase, subject, subjectFieldName);
    }

    private void injectMockField(String subjectFieldName, List testFields, BoooostCase testCase, Object subject) {
        String testFieldName = subjectFieldName + "Mock";
        if (testFields.contains(testFieldName)) injector.inject(testCase, subject, testFieldName, subjectFieldName);
    }

    // FIX DEBT Stinky.  Need a getField or fieldExists().
    private Object nullGetSubject(BoooostCase testCase) {
        try {
            return fielder.getInstance(testCase, "subject");
        } catch (EdgeException e) {
            return null;
        }
    }
}
