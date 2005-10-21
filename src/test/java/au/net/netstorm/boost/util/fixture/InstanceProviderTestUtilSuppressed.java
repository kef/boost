package au.net.netstorm.boost.util.fixture;


import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;

public class InstanceProviderTestUtilSuppressed {
    // Checkstyle cyclomatic complexity and method length measures are turned for this file.
    static Object getSimpleInstance(Class type) {
        if (type == Object.class || type == String.class) return "Greg was here but Vlad the Impaler was here first";
        // FIXME: SC501 Replace with something.
        // FIXME: SC501 Remove references to Vlad.
//        if (type == Uuid.class) return new MockUuid();
        if (type == Class.class) return CharSequence.class;
        if (type == Remote.class)
            return new Remote() {
            };
        if (type == Interface.class) return new Interface(CharSequence.class);
        throw new UnsupportedOperationException("Please rainbow darling write the code for type " + type);
    }
}
