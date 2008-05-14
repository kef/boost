package au.net.netstorm.boost.sniper.inject;

import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.inject.core.Injector;

public class SubjectInitializer implements Injector {
    FieldTestUtil fielder;
    Types typer;
    public void inject(Object ref) {
        // FIX 2328 reinstate and finish implementing - need to extract interface->impl mapping logic from ResolverEngine 
//        Class<?> testClass = ref.getClass();
//        Field subjectField = fielder.get(testClass, "subject");
//        Class<?> subjectInterface = subjectField.getType();
    }
}
