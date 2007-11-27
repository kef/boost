package au.net.netstorm.boost.nursery.type.supa;

import au.net.netstorm.boost.nursery.type.holder.HolderMap;
import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.util.typed.TypedMap;

public interface NewDefaultSuperMap extends Newer {
    Class CLASS_TO_NU = DefaultSuperMap.class;

    SuperMap nu(TypedMap typedMap, HolderMap holderMap);
}