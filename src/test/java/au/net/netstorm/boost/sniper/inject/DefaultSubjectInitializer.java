package au.net.netstorm.boost.sniper.inject;

import java.lang.reflect.Field;

import au.net.netstorm.boost.spider.core.Types;
import au.net.netstorm.boost.sniper.reflect.util.ClassTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldMaster;

public class DefaultSubjectInitializer implements SubjectInitializer {
    ImplementationLookup lookup;
    Types typer;
    ClassTestUtil classer;
    FieldTestUtil fielder;
    ResolvableFieldMaster resolvable;

    public void inject(Object ref) {
        Field field = getSubjectField(ref);
        if (!resolvable.isResolvableField(ref, field)) return;
        Class<?> impl = getSubjectImpl(field);
        if (!classer.isInstantiable(impl)) return;
        inject(ref, impl);
    }

    private Class<?> getSubjectImpl(Field subjectField) {
        Class<?> subjectIface = subjectField.getType();
        return lookup.getImplementation(subjectIface);
    }

    private Field getSubjectField(Object ref) {
        Class<?> testClass = ref.getClass();
        return fielder.get(testClass, "subject");
    }

    private void inject(Object ref, Class<?> subjectImpl) {
        Object subject = classer.newInstance(subjectImpl);
        fielder.setInstance(ref, "subject", subject);
    }
}
