package au.net.netstorm.boost.nursery.edgify;

// FIX DEBT Remove this once wiring is sorted. This can be passed in as a dependency for all Suppliers.
public class DefaultEdgeSupplier {
    // FIX DEBT Sort out com.whatever.
    protected Edgifier edgifier = new DefaultEdgifier("com.whatever.");
}
