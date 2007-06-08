package au.net.netstorm.boost.type.map.core;

import au.net.netstorm.boost.spider.inject.newer.core.Newer;

// FIX BREADCRUMB 54563 Remove once we have NewTypeMap working.
public interface NewDefaultTypedMap extends Newer {
    Class CLASS_TO_NU = DefaultTypedMap.class;

    TypedMap nu(TypedMapRead typedMapRead, TypedMapWrite typedMapWrite);
}
