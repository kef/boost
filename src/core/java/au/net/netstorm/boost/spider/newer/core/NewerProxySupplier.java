package au.net.netstorm.boost.spider.newer.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface NewerProxySupplier {
    Object nu(Interface newerInterface, Implementation classsToNu);
}
