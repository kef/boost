package au.net.netstorm.boost.nursery.edgify;

// FIX 33397 Remove me once we're using the boost version.
public interface EdgifierHorizon {
    Class toReal(Class edgeClass);

    Class toEdge(Class realClass);
}
