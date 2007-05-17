package au.net.netstorm.boost.test.inject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.inject.resolver.field.DefaultResolverFieldFinder;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public final class DefaultSubjectInjector implements SubjectInjector {
    private final MockInjector injector = new DefaultMockInjector();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ResolverFieldFinder finder = new DefaultResolverFieldFinder();
    private final EdgeClass classer = new DefaultEdgeClass();

    public void inject(UsesMocks testCase) {
        Object subject = tryGetSubject(testCase);
        // FIX 39663 Is this ok for tests to have no subject.
        if (subject != null) {
            Field[] unresolvedFields = finder.find(subject);
            List availableFieldsList = getAvailableFieldNames(testCase);
            inject(testCase, subject, unresolvedFields, availableFieldsList);
        }
    }

    private Object tryGetSubject(UsesMocks testCase) {
        try {
            return fielder.getInstance(testCase, "subject");
        } catch (EdgeException e) {
            return null;
        }
    }

    private void inject(UsesMocks testCase, Object subject, Field[] unresolvedFields, List availableFields) {
        for (int i = 0; i < unresolvedFields.length; i++) {
            Field field = unresolvedFields[i];
            String name = field.getName();
            if (availableFields.contains(name)) injector.inject(testCase, subject, name);
        }
    }

    private List getAvailableFieldNames(UsesMocks testCase) {
        Field[] availableFields = getAvailableFields(testCase);
        List availableFieldsList = new ArrayList();
        for (int i = 0; i < availableFields.length; i++) {
            String name = availableFields[i].getName();
            availableFieldsList.add(name);
        }
        return availableFieldsList;
    }

    private Field[] getAvailableFields(UsesMocks testCase) {
        Class cls = testCase.getClass();
        return classer.getDeclaredFields(cls);
    }
}
