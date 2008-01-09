package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX ()   2237 Move out of "nursery".
public interface Linkage {
    Implementation getHost();

    Interface getIface();

    String getName();

    boolean hosted();

    boolean named();
}
