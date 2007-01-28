package au.net.netstorm.boost.nursery.pebble;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// FIX 1665 Move out of nursery.

// FIX 1665 Move to test tree.
public final class DefaultPebbleChecker implements PebbleChecker {
    EdgeClass edgeClass = new DefaultEdgeClass();

    public void check(Class impl) {
        String newer = impl.getName() + "_";
        tryForName(newer, impl);
    }

    private void tryForName(String newer, Class impl) {
        try {
            edgeClass.forName(newer);
        } catch (EdgeException e) {
            if (e.causeIs(ClassNotFoundException.class)) {
                throw new NoNewInterfaceException(newer, impl);
            }
        }
    }
}
