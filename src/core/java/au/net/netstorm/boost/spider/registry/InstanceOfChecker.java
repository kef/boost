package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Reference;

// FIX ()   2255 Overlaps with Marker - merge?
public interface InstanceOfChecker {
    void instanceOf(Reference instance, Implementation impl);
}
