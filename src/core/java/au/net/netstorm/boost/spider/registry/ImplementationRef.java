package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.gunge.ref.Ref;

public interface ImplementationRef extends Ref {
    Implementation get();
}
