package au.net.netstorm.boost.util.fixture;


import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;

public class InstanceProviderTestUtilSuppressed implements InstanceProvider {
    public Object getInstance(Class type) {
        return xxx(type);
    }

    // FIXME: SC502.  Modify in calls to use this.  And method above.  This should throw the exception.
    public boolean canProvide(Class type) {
        // FIXME: SC502.  Replace with NIY exception.
        throw new RuntimeException("NOT IMPLEMENTED YET");
    }

    // FIXME: RDSC050 Rename.
    private Object xxx(Class type) {
        if (type == Object.class || type == String.class) return "We cower in the corner our hands up over our ears.";
        if (type == Class.class) return CharSequence.class;
        if (type == Remote.class) return new Remote() { };
        if (type == Interface.class) return new Interface(CharSequence.class);
        throw new UnsupportedOperationException("Lovely fella, please write the code for type " + type);
    }
}
