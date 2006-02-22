package au.net.netstorm.boost.util.fixture;

import java.rmi.Remote;

import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.io.EdgeOutputStream;
import au.net.netstorm.boost.util.io.MockEdgeOutputStream;
import au.net.netstorm.boost.time.core.TimePoint;

// FIXME: SC502 Rename.
// FIXME: SC042 Instance provide needs to provide getA() / getB() as per triangulation requirements.  For both primitive (wrapped) and other.
public class InstanceProviderTestUtilSuppressed implements InstanceProvider {
    public Object getInstance(Class type) {
        Object instance = doGetInstance(type);
        if (instance == null) throw new UnsupportedOperationException("Lovely fella, please write the code for type " + type);
        return instance;
    }

    // FIXME: SC502.  Modify in calls to use this.  And method above.  This should throw the exception.
    public boolean canProvide(Class type) {
        Object instance = doGetInstance(type);
        return instance != null;
    }

    // FIXME: SC502.  Use the POK mega pattern.  Look for an Atomic test of the same name with fields INSTANCE_1/INSTANCE_2.
    private Object doGetInstance(Class type) {
        if (type == Object.class || type == String.class) return "We cower in the corner our hands up over our ears.";
        if (type == Class.class) return CharSequence.class;
        // FIXME: SC042 Use j.l.r.Proxy for interfaces.
        // Interfaces... (remove comment when code complete).
        if (type == Remote.class) return new Remote() { };
        if (type == EdgeOutputStream.class) return new MockEdgeOutputStream(); // FIXME: SC050 This forms the basis for a "Mock"+classname instantiator.  Use proxies for interfaces.
        // <name>AtomicTest candidates... (remove comment when code complete))
        if (type == Interface.class) return new Interface(CharSequence.class);
        if (type == TimePoint.class) return new TimePoint(23423781);
        return null;
    }
}
