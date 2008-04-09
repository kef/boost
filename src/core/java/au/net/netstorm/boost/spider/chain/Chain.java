package au.net.netstorm.boost.spider.chain;

import au.net.netstorm.boost.gunge.type.Data;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public interface Chain extends Data {
    Interface getType();

    Implementation[] getLinks();
}
