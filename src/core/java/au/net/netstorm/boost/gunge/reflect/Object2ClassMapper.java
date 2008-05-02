package au.net.netstorm.boost.gunge.reflect;

import au.net.netstorm.boost.gunge.collection.Mapper;

// FIX 2328 does the spider support a better mechanism for 1 to many, interface to impl relationships

// FIX 2328 This will probably result in another yummy story card.
// FIX 2328 The mangler code which used Threaded<T> drove this too.
public interface Object2ClassMapper extends Mapper<Object, Class<?>> {
}
