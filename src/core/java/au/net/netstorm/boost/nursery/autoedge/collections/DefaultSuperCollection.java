package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.gunge.collection.CollectionMaster;

public class DefaultSuperCollection implements SuperCollection {
    CollectionMaster master;
    public <T> List<T> filter(Iterable<T> iterable, Filter<T> filter) {
        List<T> result = new ArrayList<T>();
        for (T t : iterable) {
            if (filter.accept(t)) result.add(t);
        }
        return result;
    }

    public <T> List<T> filter(T[] array, Filter<T> filter) {
        List<T> result = new ArrayList<T>();
        for (T t : array) {
            if (filter.accept(t)) result.add(t);
        }
        return result;
    }

    public <S, T> List<T> map(Iterable<S> iterable, Mapper<S, T> mapper) {
        List<T> result = new ArrayList<T>();
        for (S s : iterable) {
            T t = mapper.map(s);
            result.add(t);
        }
        return result;
    }

    public <S, T>  List<T> map(S[] array, Mapper<S, T> mapper) {
        List<T> result = new ArrayList<T>();
        for (S s : array) {
            T t = mapper.map(s);
            result.add(t);
        }
        return result;
    }

    public <T> T find(Iterable<T> iterable, Finder<T> finder) {
        for (T t : iterable) {
            if (!finder.next(t)) break;
        }
        return finder.result();
    }
}
