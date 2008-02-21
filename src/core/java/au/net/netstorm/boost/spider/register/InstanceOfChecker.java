package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Reference;

// FIX ()   2255 Overlaps with Marker - merge?
public interface InstanceOfChecker {
    void instanceOf(Reference instance, Implementation impl);
}
