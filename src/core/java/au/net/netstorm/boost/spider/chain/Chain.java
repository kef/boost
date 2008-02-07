package au.net.netstorm.boost.spider.chain;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Chain extends Data {
    Interface getType();

    Implementation[] getLinks();
}
