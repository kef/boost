package au.net.netstorm.boost.nursery.edgify;

// FIX 33397 Remove me once we're using the boost version.
public interface Edgifier {
    Object edgify(Object real, Class realClass);

    Object[] edgify(Object[] real, Class realClass);

    Object deEdgify(Object edge, Class edgeClass);

    Object[] deEdgify(Object[] edge, Class edgeClass);
}
