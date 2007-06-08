package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;

public interface NewDefaultHolderMap extends Newer {
    Class CLASS_TO_NU = DefaultHolderMap.class;

    HolderMap nu(TypedMap typedMap);
}
