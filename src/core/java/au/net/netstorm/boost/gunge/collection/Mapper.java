package au.net.netstorm.boost.gunge.collection;

public interface Mapper<S, T> {
    T map(S src);
}
