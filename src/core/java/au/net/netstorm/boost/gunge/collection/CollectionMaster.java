package au.net.netstorm.boost.gunge.collection;

import java.util.List;
import java.util.Set;

public interface CollectionMaster {
    <T> Set<T> immutableSet(T[] array);

    <T> Set<T> mutableSet(T[] array);

    <T> List<T> mutableList(T[] array);

    <T> List<T> immutableList(T[] array);
}
