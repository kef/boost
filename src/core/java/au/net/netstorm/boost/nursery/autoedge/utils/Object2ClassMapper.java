package au.net.netstorm.boost.nursery.autoedge.utils;

import au.net.netstorm.boost.nursery.autoedge.collections.Mapper;

// FIX 2328 does the spider support a better mechanism for 1 to many, interface to impl relationships

// FIX 2328 This ties back into the comment in DefaultAutoEdger.
public interface Object2ClassMapper extends Mapper<Object, Class<?>> {
}
