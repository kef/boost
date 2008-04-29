package au.net.netstorm.boost.gunge.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class DefaultCollectionMaster implements CollectionMaster {
    public <T> Set<T> immutableSet(T[] array) {
        Set<T> set = mutableSet(array);
        return Collections.unmodifiableSet(set);
    }

    public <T> Set<T> mutableSet(T[] array) {
        List<T> list = mutableList(array);
        return new HashSet<T>(list);
    }

    public <T> List<T> mutableList(T[] array) {
        List<T> list = immutableList(array);
        return new ArrayList<T>(list);
    }

    public <T> List<T> immutableList(T[] array) {
        return Arrays.asList(array);
    }
}
