package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.type.Interface;

public class DefaultClassTestUtil implements ClassTestUtil {
    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        Class type = targetInterface.getType();
        return type.isAssignableFrom(cls);
    }

    public boolean isSubclassOf(Class superClass, Class subClass) {
        return superClass.isAssignableFrom(subClass);
    }

    public Object newInstance(Class type) {
        throw new NotImplementedException();
        // FIXME: SC042 Complete this.
    }
}
