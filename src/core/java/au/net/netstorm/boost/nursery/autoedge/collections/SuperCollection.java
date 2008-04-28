package au.net.netstorm.boost.nursery.autoedge.collections;

import java.util.Collection;

// FIXME-MH these are not specific to autoedger, pull out into appropriate place
public interface SuperCollection {
    <T> Collection<T> filter(Collection<T> c, Filter<T> filter);
    <S,T> Collection<T> map(Collection<S> c, Mapper<S,T> map);
}
