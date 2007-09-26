package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.util.Ref;
import au.net.netstorm.boost.util.type.Implementation;

public interface ImplementationRef extends Ref {
    // FIX 74285 Remove EMPTY.
    ImplementationRef EMPTY = new DefaultImplementationRef(null);

    Implementation get();
}
