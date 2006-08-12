package au.net.netstorm.boost.test.fixture;

import java.rmi.Remote;

import au.net.netstorm.boost.edge.java.io.EdgeOutputStream;
import au.net.netstorm.boost.time.core.TimePoint;
import au.net.netstorm.boost.util.type.Interface;


// FIXME: SC600 Checkstyle suppressions inline.
// FIX SC502 Rename.
// FIX SC517 Instance provide needs to provide getA() / getB() as per triangulation requirements.  For both primitive (wrapped) and other.
// FIX SC517 There is a class util.instance.DefaultInstanceProvider.  Merge with this.
//
//
//
//
// ---------------------------------------- FIXME: SC600 FROZEN -----------------------------------
//
//
//
//
public final class OldTriangulationProvider implements TriangulationProvider {
    public Object getInstance(Class type) {
        Object instance = doGetInstance(type);
        if (instance == null)
            throw new UnsupportedOperationException("Lovely fella, please write the code for type " + type);
        return instance;
    }

    // FIX SC502.  Modify in calls to use this.  And method above.  This should throw the exception.
    public boolean canProvide(Class type) {
        Object instance = doGetInstance(type);
        return instance != null;
    }

    // FIX SC502.  Use the POK mega pattern.  Look for an Atomic test of the same name with fields INSTANCE_1/INSTANCE_2.
    private Object doGetInstance(Class type) {
        if (type == Object.class || type == String.class) return "We cower in the corner our hands up over our ears.";
        if (type == Class.class) return CharSequence.class;
        if (type == Long.class) return new Long(10);
        // FIX SC517 Use j.l.r.Proxy for interfaces.
        // Interfaces... (remove comment when code complete).
        if (type == Remote.class) return new Remote() {
        };
        if (type == EdgeOutputStream.class)
            return new MockEdgeOutputStream(); // FIX SC050 This forms the basis for a "Mock"+classname instantiator.  Use proxies for interfaces.
        // <name>AtomicTest candidates... (remove comment when code complete))
        if (type == Interface.class) return new Interface(CharSequence.class);
        if (type == TimePoint.class) return new TimePoint(23423781);
        return null;
    }
}
