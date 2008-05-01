package au.net.netstorm.boost.gunge.collection;

import java.util.List;

public interface FunctionalCollection {
    <T> List<T> filter(Iterable<T> iterable, Filter<T> filter);

    <T> List<T> filter(T[] array, Filter<T> filter);

    <S, T> List<T> map(Iterable<S> iterable, Mapper<S, T> mapper);

    <S, T> List<T> map(S[] array, Mapper<S, T> mapper);

    <T> T find(Iterable<T> iterable, Finder<T> finder);

    <T> T find(T[] array, Finder<T> finder);
}
