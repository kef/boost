package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.introspect.MethodSpec;

public interface ReflectMethodMaster {
    Method getMethod(Class cls, MethodSpec method);

    // SUGGEST (Dec 5, 2007): Big and long.  Like mine but not as pretty.
    // SUGGEST (Dec 6, 2007): Move into ExactReflectMaster maybe?
    // SUGGEST (Dec 6, 2007): Exact is floating around in a bunch of other places too.
    // SUGGEST (Dec 6, 2007): Sniff out and nail.
    Method getMethodWithExactParams(Class cls, MethodSpec method);

    String[] getPublicMethodNames(Object ref);

    Method[] getPublicMethods(Object ref);
}
