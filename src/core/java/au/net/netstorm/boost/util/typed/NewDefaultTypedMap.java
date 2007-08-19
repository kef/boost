package au.net.netstorm.boost.util.typed;

import au.net.netstorm.boost.spider.newer.core.Newer;

// FIX BREADCRUMB 57383 Remove once we have NewTypeMap working.
public interface NewDefaultTypedMap extends Newer {
    Class CLASS_TO_NU = DefaultTypedMap.class;

    TypedMap nu(TypedMapRead typedMapRead, TypedMapWrite typedMapWrite);
}
