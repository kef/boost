package au.net.netstorm.boost.gunge.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultFunctionalCollection implements FunctionalCollection {
    public <T> List<T> filter(Iterable<T> iterable, Filter<T> filter) {
        List<T> result = new ArrayList<T>();
        for (T t : iterable) {
            if (filter.accept(t)) result.add(t);
        }
        return result;
    }

    public <T> List<T> filter(T[] array, Filter<T> filter) {
        Iterable<T> iterable = toIterable(array);
        return filter(iterable, filter);
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
        Iterable<S> iterable = toIterable(array);
        return map(iterable, mapper);
    }

    public <T> T find(Iterable<T> iterable, Finder<T> finder) {
        for (T t : iterable) {
            if (!finder.next(t)) break;
        }
        return finder.result();
    }

    public <T> T find(T[] array, Finder<T> finder) {
        Iterable<T> iterable = toIterable(array);
        return find(iterable, finder);
    }

    public <T> Iterable<T> toIterable(T[] array) {
        return Arrays.asList(array);
    }
}
