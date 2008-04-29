package au.net.netstorm.boost.demo.nursery.autoedge;

import au.net.netstorm.boost.nursery.autoedge.Edge;

public interface EdgeToBeEdgedClass extends Edge<ToBeEdgedClass> {
    String edgeMethod();
}
