package au.net.netstorm.boost.util.typed;

import au.net.netstorm.boost.spider.newer.core.Newer;

public interface NewDefaultTypedMap extends Newer {
    Class CLASS_TO_NU = DefaultTypedMap.class;

    TypedMap nu(TypedMapRead read, TypedMapWrite write);
}
