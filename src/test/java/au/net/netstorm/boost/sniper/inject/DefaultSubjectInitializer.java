package au.net.netstorm.boost.sniper.inject;

import java.lang.reflect.Field;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;

public class DefaultSubjectInitializer implements SubjectInitializer {
    ImplementationLookup lookup;
    Types typer;
    EdgeClass classer;
    EdgeField fielder;

    public void inject(Object ref) {
        Class<?> testClass = ref.getClass();
        Field subjectField = classer.getDeclaredField(testClass, "subject");
        Class<?> subjectIface = subjectField.getType();
        Class<?> subjectImpl = lookup.getImplementation(subjectIface);
        Object subject = classer.newInstance(subjectImpl);
        fielder.set(subjectField, ref, subject);
    }
}
