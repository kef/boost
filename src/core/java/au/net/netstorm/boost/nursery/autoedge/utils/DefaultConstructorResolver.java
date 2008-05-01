package au.net.netstorm.boost.nursery.autoedge.utils;

import java.lang.reflect.Constructor;
import java.util.List;

import au.net.netstorm.boost.gunge.collection.FunctionalCollection;

public class DefaultConstructorResolver implements ConstructorResolver {
    ConstructorFilter filter;
    MostSpecificSignatureFinder finder;
    FunctionalCollection collection;

    public <T> Constructor<T> resolve(Class<T> type, Object... p) {
        List<Constructor<?>> candidates = filter.filter(type, p);

        int size = candidates.size();
        if (size == 0) fail();
        if (size == 1) return head(candidates);

        return refine(candidates);
    }

    private <T> Constructor<T> refine(List<Constructor<?>> candidates) {
        Constructor<?> result = collection.find(candidates, finder);
        return cast(result);
    }

    private <T> Constructor<T> head(List<Constructor<?>> candidates) {
        Constructor<?> c = candidates.get(0);
        return cast(c);
    }

    @SuppressWarnings("unchecked")
    private <T> Constructor<T> cast(Constructor<?> c) {
        return (Constructor<T>) c;
    }

    private void fail() {
        throw new RuntimeException("Could not resolve a constructor.");
    }
}
