package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Iterator;

public class DefaultIteratorUnsupportedRemoveChecker implements IteratorUnsupportedRemoveChecker {
    public void checkIterationRemoveUnsupported(Iterator<?> uut) {
        try {
            uut.remove();
        } catch (UnsupportedOperationException e) { /* expected*/ }
    }

}
