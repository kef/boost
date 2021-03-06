package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public interface Linkage {
    Implementation getHost();

    Interface getIface();

    Anchor getAnchor();

    boolean hosted();

    boolean anchored();
}
