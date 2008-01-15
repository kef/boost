package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Linkage {
    Implementation getHost();

    Interface getIface();

    String getName();

    boolean hosted();

    boolean named();
}
