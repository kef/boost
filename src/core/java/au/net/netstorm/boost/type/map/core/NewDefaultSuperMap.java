package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;

public interface NewDefaultSuperMap extends Newer {
    Class CLASS_TO_NU = DefaultSuperMap.class;

    SuperMap nu(TypedMap typedMap, HolderMap map);
}
