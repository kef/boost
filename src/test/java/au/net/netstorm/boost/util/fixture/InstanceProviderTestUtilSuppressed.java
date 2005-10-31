package au.net.netstorm.boost.util.fixture;


import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;

public class InstanceProviderTestUtilSuppressed {
    // Checkstyle cyclomatic complexity and method length measures are turned for this file.
    static Object getSimpleInstance(Class type) {
        if (type == Object.class || type == String.class) return "We cower in the corner our hands up over our ears.";
        // FIXME: SC506 Replace with something.
        // FIXME: SC506 Remove references to Vlad.
//        if (type == Uuid.class) return new MockUuid();
        if (type == Class.class) return CharSequence.class;
        if (type == Remote.class)
            return new Remote() {
            };
        if (type == Interface.class) return new Interface(CharSequence.class);
        throw new UnsupportedOperationException("Lovely fella, please write the code for type " + type);
    }
}
