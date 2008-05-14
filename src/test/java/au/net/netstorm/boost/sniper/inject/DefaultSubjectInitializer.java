package au.net.netstorm.boost.sniper.inject;

import java.lang.reflect.Field;
import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sniper.reflect.util.ClassTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.resolve.ImplementationLookup;

public class DefaultSubjectInitializer implements SubjectInitializer {
    ImplementationLookup lookup;
    Types typer;
    ClassTestUtil classer;
    FieldTestUtil fielder;

    public void inject(Object ref) {
        Class<?> testClass = ref.getClass();
        Field subjectField = fielder.get(testClass, "subject");
        Class<?> subjectIface = subjectField.getType();
        Class<?> subjectImpl = lookup.getImplementation(subjectIface);
        if (classer.isInstantiable(subjectImpl)) inject(ref, subjectImpl);
    }

    private void inject(Object ref, Class<?> subjectImpl) {
        Object subject = classer.newInstance(subjectImpl);
        fielder.setInstance(ref, "subject", subject);
    }
}
