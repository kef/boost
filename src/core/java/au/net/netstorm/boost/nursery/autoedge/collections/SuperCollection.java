package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.List;

// FIXME-MH these are not specific to autoedger, pull out into appropriate place
public interface SuperCollection {
    <T> List<T> filter(Iterable<T> iterable, Filter<T> filter);
    <T> List<T> filter(T[] array, Filter<T> filter);
    <S,T> List<T> map(Iterable<S> iterable, Mapper<S,T> mapper);
    <S,T> List<T> map(S[] array, Mapper<S,T> mapper);
    <T> T find(Iterable<T> iterable, Finder<T> finder);
}
