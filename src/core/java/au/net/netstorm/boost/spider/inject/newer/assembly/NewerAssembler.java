package au.net.netstorm.boost.spider.inject.newer.assembly;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.util.type.Interface;

public interface NewerAssembler {
    Newer assemble(Interface type);
}
