package au.net.netstorm.boost.demo.nursery.autoedge;

import au.net.netstorm.boost.nursery.autoedge.Edge;

public interface EdgeToBeEdgedObject extends Edge<ToBeEdgedObject> {
    String getState();
    void setState(String state);
}
