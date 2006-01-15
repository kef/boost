package au.net.netstorm.boost.util.fixture;


import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;

public class InstanceProviderTestUtilSuppressed implements InstanceProvider {
    public Object getInstance(Class type) {
        Object instance = doGetInstance(type);
        if (instance == null) throw new UnsupportedOperationException("Lovely fella, please write the code for type " + type);
        return instance;
    }

    // FIXME: SC502.  Modify in calls to use this.  And method above.  This should throw the exception.
    public boolean canProvide(Class type) {
        // FIXME: SC502.  Replace with NIY exception.
        Object instance = doGetInstance(type);
        return instance != null;
    }

    private Object doGetInstance(Class type) {
        if (type == Object.class || type == String.class) return "We cower in the corner our hands up over our ears.";
        if (type == Class.class) return CharSequence.class;
        if (type == Remote.class) return new Remote() { };
        if (type == Interface.class) return new Interface(CharSequence.class);
        return null;
    }
}
