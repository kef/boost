package au.net.netstorm.boost.util.collection;

import java.util.List;
import java.util.Set;

public interface CollectionMaster {
    <T> Set<T> immutableSet(T[] array);

    <T> Set mutableSet(T[] array);

    <T> List mutableList(T[] array);

    <T> List immutableList(T[] array);
}
