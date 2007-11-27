package au.net.netstorm.boost.nursery.type.holder;

import au.net.netstorm.boost.spider.newer.core.Newer;
import au.net.netstorm.boost.util.typed.TypedMap;

public interface NewDefaultHolderMap extends Newer {
    Class CLASS_TO_NU = DefaultHolderMap.class;

    HolderMap nu(TypedMap typedMap);
}
