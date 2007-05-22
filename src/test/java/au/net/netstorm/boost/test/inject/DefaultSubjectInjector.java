package au.net.netstorm.boost.test.inject;

import java.lang.reflect.Field;
import java.util.List;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultSubjectInjector implements SubjectInjector {
    private final MockInjector injector = new DefaultMockInjector();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ResolverFieldFinder resolverFieldFinder = new DefaultResolverFieldFinder();
    private final FieldNameFinder fieldNameFinder = new DefaultFieldNameFinder();

    public void inject(BoooostCase testCase) {
        Object subject = nullGetSubject(testCase);
        if (testContainsSubjectField(subject)) {
            Field[] subjectFields = resolverFieldFinder.find(subject);
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
            if (testFields.contains(subjectFieldName)) injector.inject(testCase, subject, subjectFieldName);
        }
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
